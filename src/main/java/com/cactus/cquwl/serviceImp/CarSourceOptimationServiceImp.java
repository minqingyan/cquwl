package com.cactus.cquwl.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Algorithm.AllContext;
import com.cactus.cquwl.Algorithm.AllContextImp;
import com.cactus.cquwl.Algorithm.IOptimization;
import com.cactus.cquwl.Algorithm.OptimizationImp;
import com.cactus.cquwl.Algorithm.Solution;
import com.cactus.cquwl.Util.CacheUtil;
import com.cactus.cquwl.Util.CacheUtils;
import com.cactus.cquwl.Util.CarUtil;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.dao.ICarSourceDao;
import com.cactus.cquwl.domain.entity.CarEasyMsg;
import com.cactus.cquwl.domain.entity.VehicleMsg;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.service.ICarSourceOptimizationService;

@Service
public class CarSourceOptimationServiceImp implements ICarSourceOptimizationService{

	@Autowired
	private ICarSourceDao carSourceDao;
	
	private static String path = "assets/img/car/";
	private static AllContext context = new AllContextImp();
	
	@Override
	@Transactional
	public List<List<CarEasyMsg>> getCarSourceTable(AdminUser user) {
		// TODO Auto-generated method stub
		// 从缓存中获取大宗散货  
		//BasicGood basicGood = CacheUtil.getBasicGoodInCache(user);
		BasicGood basicGood = (BasicGood) CacheUtils.get("dzshCache", user.getPhone());
		// 1.
		// 现在数据库中进行基本的匹配匹配 
		// 地点的匹配
		// 时间的匹配
		// 重量 体积的匹配
		List<CarSource> list = carSourceDao.selectCarSourceListByBasicGood(basicGood);
		// 2.
		// 如果 是大宗散货直接输出，
		// 如果 是普通件杂货进行车辆的拼接适应
		if(basicGood.getType() == 2){
			// 先求出每个车辆最多能装箱数目（按照长宽重量三种维度进行摆放）
			// 结果用Map<Integer, List<CarSource>> 的方式进行存储
			Map<Integer, List<Map<CarSource, String>>> maps = new HashMap<>();
			// strage 记录具体方案
			Map<Integer,List<String>> strage = new HashMap<>();
			List<String> strList = null;
			
			for(CarSource cs : list){
				// 获取最大装载数量
				// 
				Map<Integer, String> map = null;
				map = context.availableMaxCount(basicGood, cs, null, 0);
				// 获取数量
				Set<Integer> set = map.keySet();
				Iterator<Integer> inte = set.iterator();
				int count = 0;
				while(inte.hasNext()) {
					count = inte.next();
				}
		
				Map<CarSource, String> csts = null;
				if(maps.containsKey(count)){
					csts = new HashMap<>();
					csts.put(cs, map.get(count));
					maps.get(count).add(csts);
				}else{
					//List<CarSource> cars = new ArrayList<CarSource>();
					List<Map<CarSource, String>> cars = new ArrayList<>();
					csts = new HashMap<>();
					csts.put(cs, map.get(count));
					cars.add(csts);
					maps.put(count, cars);
				}
			}
			//IOptimization opt = new OptimizationImp();
			//List<List<CarSource>> groups = opt.getOptimizationGroup(maps, basicGood.getTotalPack());
			// 算法引入，求出最优组合
			Set<Integer> set = maps.keySet();
			int[] weight = new int[maps.size()];
			int[] nums = new int[maps.size()];
			Iterator<Integer> it = set.iterator();
			int k = 0;
			while(it.hasNext()){
				int temp = it.next();
				weight[k] = temp;
				nums[k] = maps.get(temp).size();
				k++;
			}
			// 调用方法求解
			Solution so = new Solution(weight, nums, basicGood.getTotalPack());
			so.resovle();
			Stack<int[]> groups = so.getResult();
			
			List<List<CarEasyMsg>>  cars = new ArrayList<>();
		    List<CarEasyMsg> msg = null;
		    while(!groups.isEmpty()) {	
		    	int[] re = groups.pop();
		    	msg = new ArrayList<>();
		    	CarEasyMsg car = null;
		    	for(int j = 0; j < re.length; j++){
		    		if(re[j] != 0){
		    			// 获取几个车子
				    	for(int m = 0; m < re[j]; m++){
				    		car = new CarEasyMsg();
				    		
				    		 Map<CarSource, String> tempMap = maps.get(weight[j]).get(m);
				    		 Set<CarSource> s = tempMap.keySet();
				    		 Iterator<CarSource> itm = s.iterator();
				    		 CarSource cs = null;
				    		 while(itm.hasNext()){
				    			 cs = itm.next();
				    		 }
				    		
				    		car.setId(cs.getCarId());
					    	car.setName(cs.getPublish().getAdminUser().getUserName());
					    	car.setMsg(cs.getCarNumber());
					    	car.setImg(path+ TextUtil.getRandom()+".jpg");
					    	car.setSum(weight[j]);
					    	
					    	String temp = tempMap.get(cs);
					    	
					    	String[] str = temp.split("&");
					    	
					    	car.setStrage(str[1]);
					    	car.setSumDetail(str[2]);
					    	car.setStrageImg(str[3]);
					    	car.setphone(cs.getPublish().getAdminUser().getPhone());
					    	msg.add(car);
				    	}
		    		}
		    	}
		    	cars.add(msg);
		    }
		    return cars;
		} else {
			List<List<CarEasyMsg>>  cars = new ArrayList<>();
			 List<CarEasyMsg> msg = null;
			for(CarSource car:list){
				msg = new ArrayList<>();
		    	CarEasyMsg unit = new CarEasyMsg();
		    	unit.setId(car.getCarId());
		    	unit.setMsg(car.getCarNumber());
		    	unit.setName(car.getPublish().getAdminUser().getUserName());
		    	unit.setImg(path+ TextUtil.getRandom()+".jpg");
		    	unit.setphone(car.getPublish().getAdminUser().getPhone());
		    	msg.add(unit);
		    	cars.add(msg);
			}
			return cars;
		}
		
	//	List<CarSource> list = carSourceDao.selectCarSourceList(1, 1);
		//输出
		/*
		List<VehicleMsg> cars=new ArrayList<VehicleMsg>();
		VehicleMsg re=null;
		for(CarSource car:list){
			re=new VehicleMsg();
			re.setId(car.getCarId().toString());
			re.setStartPlace(car.getPlaceStart());
			re.setCarOwnerName(car.getPublish().getAdminUser().getUserName());
			try {
				re.setRegisterDate("已注册"+TimeUtil.getMonths(car.getPublish().getAdminUser().getCreateDate().toString())+"个月");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			re.setPhone(car.getPublish()==null?"":car.getPublish().getAdminUser().getPhone());
			re.setDestination(car.getPlaceArrive());
			//String str=TextUtil.caculate(car.getCarLength()==null?0:car.getCarLength(), car.getCarWidth()==null?0:car.getCarWidth(), car.getCarHeigth()==null?0:car.getCarHeigth());
			StringBuffer sb = new StringBuffer();
			re.setCarType("车型:"+CarUtil.getName(car.getType()));
			re.setMaxWeight("载重:"+car.getWeight());
			re.setLwh("车长"+car.getCarLength()+" 车宽"+car.getCarWidth()+" 车高"+car.getCarHeigth());
			re.setCarNumber(car.getCarNumber());
			cars.add(re);
		}
		*/
	}

	@Override
	public JSONObject getStoreGoodsTable(AdminUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}

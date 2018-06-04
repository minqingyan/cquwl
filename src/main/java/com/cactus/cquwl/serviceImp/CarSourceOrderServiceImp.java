package com.cactus.cquwl.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.CacheUtils;
import com.cactus.cquwl.Util.CarUtil;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.dao.ICarSourceDao;
import com.cactus.cquwl.dao.ICarSourceOrderDao;
import com.cactus.cquwl.dao.IGoodSourceDao;
import com.cactus.cquwl.dao.IStoreGoodDao;
import com.cactus.cquwl.dao.IStoreSourceDao;
import com.cactus.cquwl.domain.entity.CarOrderResult;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.MyOrders;
import com.cactus.cquwl.pojo.StoreGood;
import com.cactus.cquwl.pojo.StoreSource;
import com.cactus.cquwl.service.ICarSourceOrderService;

@Service
public class CarSourceOrderServiceImp implements ICarSourceOrderService{
	
	@Autowired
	private ICarSourceOrderDao carSourceOrderDao;
	
	@Autowired
	private IGoodSourceDao goodSourceDao;
	
	@Autowired
	private ICarSourceDao carSourceDao;
	
	@Autowired
	private IStoreSourceDao storeSourceDao;
	
	@Autowired
	private IStoreGoodDao storeGoodDao;

	@Override
	@Transactional
	public JSONObject saveOrdering(AdminUser adminUser,String id,int flag) throws ParseException {
		// TODO Auto-generated method stub
		// id
		JSONObject json=new JSONObject();
		if(TextUtil.isEmpty(id) || TextUtil.isNullObject(adminUser)){
			json.put("status", 2);
			json.put("msg", "请重新提交订单！");
			return json;
		}
		MyOrders myorder=new MyOrders();
		myorder.setFlag(flag);
		myorder.setFlagId(Integer.parseInt(id));
		myorder.setOrderId(TextUtil.printOrderId(flag));
		myorder.setOrderTime(TimeUtil.getCurrentDate());
		myorder.setState(1);       // 订单  1 已结预定 ；2待评价；3已评价
		myorder.setAdminUser(adminUser);
		MyOrders result=carSourceOrderDao.saveOrder(myorder);
		if(!TextUtil.isNullObject(result)){
			// 将车源状态调整为已经预定
			// 1货源（仓库）；2货源（车辆）；3车源；4仓库源
			if(flag == 3){ 
				CarSource car=carSourceDao.findCarSourceById(id);
				car.setState(2);
				carSourceDao.addCarMsg(car);
			}else if(flag == 4){
				StoreSource ss=storeSourceDao.findStoreSourceById(id);
				ss.setState(2);
				storeSourceDao.saveStoreSource(ss);
			}else if(flag == 2){
				BasicGood bg=goodSourceDao.findGoodSource(id);
				bg.setState(2);
				goodSourceDao.saveGoodSource(bg);
			}else if(flag == 1 ){
				// 仓库货源
				StoreGood sg = storeGoodDao.findStoreGood(id);
				sg.setState(2);
				storeGoodDao.addStoreGood(sg);
			}
		}
		if(TextUtil.isNullObject(myorder)){
			json.put("status", 2);
			json.put("msg", "请重新提交订单！");
			return json;
		}
		json.put("status", 1);
		json.put("msg", "接单成功！");
		return json;
	}
	
	@Override
	@Transactional
	public JSONObject saveOrderingAndChangeGood(AdminUser adminUser,String ids,int flag) {
		// TODO Auto-generated method stub
		// id
		JSONObject json=new JSONObject();
		if(TextUtil.isEmpty(ids) || TextUtil.isNullObject(adminUser)){
			json.put("status", 2);
			json.put("msg", "请重新提交订单！");
			return json;
		}
		String[] id = ids.split("&");
		for(int i = 0; i < id.length; i++){
			if(!TextUtil.isEmpty(id[i]) && !TextUtil.isNullObject(id[i])){
				MyOrders myorder=new MyOrders();
				myorder.setFlag(flag);
				myorder.setFlagId(Integer.parseInt(id[i]));
				try {
					myorder.setOrderId(TextUtil.printOrderId(flag));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myorder.setOrderTime(TimeUtil.getCurrentDate());
				myorder.setState(1);       // 订单  1 已结预定 ；2待评价；3已评价
				myorder.setAdminUser(adminUser);
				MyOrders result=carSourceOrderDao.saveOrder(myorder);
				if(!TextUtil.isNullObject(result)){
					// 将车源状态调整为已经预定
					// 1货源（仓库）；2货源（车辆）；3车源；4仓库源
					if(flag == 3){ 
						CarSource car=carSourceDao.findCarSourceById(id[i]);
						car.setState(2);
						carSourceDao.addCarMsg(car);
					}else if(flag == 4){
						StoreSource ss=storeSourceDao.findStoreSourceById(id[i]);
						ss.setState(2);
						storeSourceDao.saveStoreSource(ss);
					}else if(flag == 2){
						BasicGood bg=goodSourceDao.findGoodSource(id[i]);
						bg.setState(2);
						goodSourceDao.saveGoodSource(bg);
					}else if(flag == 1 ){
						// 仓库货源
						StoreGood sg = storeGoodDao.findStoreGood(id[i]);
						sg.setState(2);
						storeGoodDao.addStoreGood(sg);
					}
				}
			}
		}
		// 获取缓存中的good
		BasicGood basicGood = (BasicGood) CacheUtils.get("dzshCache", adminUser.getPhone());
		basicGood.setState(2);
		goodSourceDao.saveGoodSource(basicGood);
		CacheUtils.remove("dzshCache", adminUser.getPhone());
		
		json.put("status", 1);
		json.put("msg", "接单成功！");
		return json;
	}

	@Override
	@Transactional
	public JSONObject findOrderByUser(AdminUser user,int flag) {
		// TODO Auto-generated method stub
		JSONObject json=new JSONObject();
		if(TextUtil.isNullObject(user)){
			json.put("status", 2);
			json.put("msg", "请重新登陆！");
			return json;
		}
		List<MyOrders> orders=carSourceOrderDao.findOrdersByUser(user, flag);
		
		List<CarOrderResult> list=new ArrayList<CarOrderResult>();
		CarOrderResult cor=null;
		for(MyOrders order:orders){
			cor=new CarOrderResult();
			cor.setId(order.getId());
			cor.setIsAssess(TextUtil.assess(order.getState()));
			cor.setOrderDate(order.getOrderTime().toString());
			cor.setOrderId(order.getOrderId());
			// id 找信息
			if(flag == 2){
				CarSource cs=carSourceDao.findCarSourceById(order.getFlagId().toString());
				cor.setCarNumber(cs==null?"":cs.getCarNumber());
				cor.setPlaceStart(cs.getPlaceStart() == null ? "" : cs.getPlaceStart());
				cor.setPlaceArrive(cs.getPlaceArrive() == null ? "" : cs.getPlaceArrive());
				cor.setCarOwnerName(cs.getPublish().getAdminUser().getUserName());
				try {
					cor.setRegisterDate("已注册"+TimeUtil.getMonths(cs.getPublish().getAdminUser().getCreateDate().toString())+"个月");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cor.setPhone(cs.getPublish()==null?"":cs.getPublish().getAdminUser().getPhone());
				//String str=TextUtil.caculate(car.getCarLength()==null?0:car.getCarLength(), car.getCarWidth()==null?0:car.getCarWidth(), car.getCarHeigth()==null?0:car.getCarHeigth());
				StringBuffer sb = new StringBuffer();
				cor.setCarType("车型:"+CarUtil.getName(cs.getType()));
				cor.setMaxWeight("载重:"+cs.getWeight());
				cor.setLwh("车长"+cs.getCarLength()+" 车宽"+cs.getCarWidth()+" 车高"+cs.getCarHeigth());
			}
			list.add(cor);
		}
		json.put("data", list);
		return json;
	}
	
	@Override
	@Transactional
	public String findOrderById(String orderId) {
		
		if(TextUtil.isEmpty(orderId)){
			return "";
		}
		MyOrders order = carSourceOrderDao.findOrderById(orderId);
		StringBuffer sb = new StringBuffer();
		sb.append("订单号：");
		sb.append(order.getOrderId());
		sb.append("        ");
		sb.append(order.getOrderTime());
		return sb.toString();
	}
	
}

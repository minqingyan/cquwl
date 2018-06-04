package com.cactus.cquwl.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.CarUtil;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.dao.ICarSourceDao;
import com.cactus.cquwl.domain.entity.CarResult;
import com.cactus.cquwl.domain.entity.VehicleMsg;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.MyPublish;
import com.cactus.cquwl.service.ICarSourceService;

@Service
public class CarSourceServiceImp implements ICarSourceService{

	@Autowired
	private ICarSourceDao carSourceDao;
	
	@Transactional
	@Override
	public void addCarMsg(CarSource car,AdminUser user) {
		// TODO Auto-generated method stub
		if(!TextUtil.isNullObject(car) && !TextUtil.isNullObject(user)){
			MyPublish publish=new MyPublish();
			publish.setAdminUser(user);
			publish.setState(1);  // 1空闲  2使用中
			publish.setFlag(3);   
			car.setPublish(publish);
			car.setState(1); //1有效  2无效
			car.setPublishTime(TimeUtil.getCurrentDate());
			carSourceDao.addCarMsg(car);
		}
	}

	@Transactional
	@Override
	public JSONObject selectCarTable(AdminUser user) {
		// TODO Auto-generated method stub
		
		List<CarSource> list=carSourceDao.selectCarSourceList(1,1);
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
		JSONObject json=new JSONObject();
		json.put("data", cars);
		return json;
	}

	@Override
	@Transactional
	public String findCarById(String id) {
		// TODO Auto-generated method stub
		if(TextUtil.isEmpty(id))
			return "";
		
		CarSource cs = carSourceDao.findCarSourceById(id);
		StringBuffer sb = new StringBuffer();
		sb.append(cs.getCarNumber());
		sb.append(" ");
		String str=TextUtil.caculate(cs.getCarLength()==null?0:cs.getCarLength(), cs.getCarWidth()==null?0:cs.getCarWidth(), cs.getCarHeigth()==null?0:cs.getCarHeigth());
		sb.append((cs.getType()!=null?(CarUtil.getName(cs.getType())+" "+cs.getWeight()==null?"":(cs.getWeight()+"吨 ")+str):""));
		return sb.toString();
	}
}
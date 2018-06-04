package com.cactus.cquwl.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.ICarAssessDao;
import com.cactus.cquwl.dao.ICarSourceDao;
import com.cactus.cquwl.dao.ICarSourceOrderDao;
import com.cactus.cquwl.domain.entity.CarAssessTable;
import com.cactus.cquwl.pojo.AllCarAssess;
import com.cactus.cquwl.pojo.CarAssess;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.MyOrders;
import com.cactus.cquwl.service.ICarAssessService;

@Service
public class CarAssessServiceImp implements ICarAssessService{

	@Autowired
	private ICarAssessDao carAssessDao;
	
	@Autowired
	private ICarSourceDao carSourceDao;
	
	@Autowired
	private ICarSourceOrderDao carSourceOrderDao;
	
	@Override
	@Transactional
	public JSONObject readCarAssessById(String id) {
		// TODO Auto-generated method stub
		CarAssessTable cat = new  CarAssessTable();
		JSONObject json = new JSONObject();
		if(TextUtil.isEmpty(id)){
			json.put("status", 2);
			json.put("data", cat);
			
		}else{
			CarSource cs = carSourceDao.findCarSourceById(id);
			if(TextUtil.isNullObject(cs)){
				json.put("status", 2);
				json.put("data", cat);
				return json;
			}
			AllCarAssess ac = carAssessDao.readCarAssessById(cs);
			if(!TextUtil.isNullObject(ac)){
				cat.setDdsj(ac.getArriveScore());
				cat.setFwtd(ac.getServiceScore());
				cat.setHshc(ac.getGoodSafe());
				cat.setSfhl(ac.getPayScore());
			}
			json.put("status", 1);
			json.put("data", cat);
		}
		return json;
	}

	@Override
	@Transactional
	public JSONObject addCarAssess(String id,String orderId,CarAssess ca){
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		if(TextUtil.isEmpty(orderId)){
			json.put("status", 2);
			json.put("msg", "订单id 丢失");
			return json;
		}
		MyOrders mo = carSourceOrderDao.findOrderById(orderId);
		mo.setFlag(3);
		carSourceOrderDao.saveOrder(mo);
		
		// 两个过程
		// 1 添加评价信息  ； 2 刷新总的评价信息数据
		ca.setOrder(mo);
		CarSource cs = carSourceDao.findCarSourceById(mo.getFlagId().toString());
		ca.setCarSource(cs);
		carAssessDao.addCarAssess(ca);
		
		AllCarAssess allCarAssess = carAssessDao.readCarAssessById(cs);
		// 如果不存在就插入
		// 如果存在就更新
		if(!TextUtil.isNullObject(allCarAssess)){
			allCarAssess.setArriveScore((allCarAssess.getArriveScore()+ca.getArriveScore())/2);
			allCarAssess.setGoodSafe((allCarAssess.getGoodSafe()+ca.getGoodSafe())/2);
			allCarAssess.setPayScore((allCarAssess.getPayScore()+ca.getPayScore())/2);
			allCarAssess.setServiceScore((allCarAssess.getServiceScore()+ca.getServiceScore())/2);
			carAssessDao.addAllCarAssess(allCarAssess);
		}
		json.put("status", 1);
		json.put("msg", "评价成功");
		return json;
	}
	
}

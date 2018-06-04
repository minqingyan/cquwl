package com.cactus.cquwl.serviceImp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.dao.IStoreGoodDao;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.MyPublish;
import com.cactus.cquwl.pojo.StoreGood;
import com.cactus.cquwl.service.IStoreGoodService;

@Service
public class StoreGoodServiceImp implements IStoreGoodService{

	@Autowired
	private IStoreGoodDao storeGoodDao;
	
	@Override
	@Transactional
	public JSONObject saveStoreGood(StoreGood sg, AdminUser adminUser) {
		// TODO Auto-generated method stub
		if(TextUtil.isNullObject(sg) || TextUtil.isNullObject(adminUser)){
			return null;
		}else{
			MyPublish my = new MyPublish();
			my.setAdminUser(adminUser);
			my.setFlag(1);
			my.setState(1);
			sg.setState(1);
			sg.setMyPublish(my);
			sg.setPublishDate(TimeUtil.getCurrentDate());
			storeGoodDao.addStoreGood(sg);
		}
		return null;
	}
	
	
	
	
}

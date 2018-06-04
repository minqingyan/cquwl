package com.cactus.cquwl.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.dao.IStoreSourceDao;
import com.cactus.cquwl.domain.entity.StoreMsg;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.MyPublish;
import com.cactus.cquwl.pojo.StoreSource;
import com.cactus.cquwl.service.IStoreSourceService;

@Service
public class StoreSourceServiceImp implements IStoreSourceService{

	@Autowired
	private IStoreSourceDao storeSourceDao;
	
	@Override
	@Transactional     // 添加仓库源
	public void saveStoreSource(StoreSource store, AdminUser user) {
		// TODO Auto-generated method stub
		if(!TextUtil.isNullObject(user) && !TextUtil.isNullObject(store)){
			MyPublish my = new MyPublish();
			my.setAdminUser(user);
			my.setFlag(1);
			my.setState(1);
			store.setPublishTime(TimeUtil.getCurrentDate());
			store.setPublish(my);
			storeSourceDao.saveStoreSource(store);
		}
		//刷选
	}

	@Override
	@Transactional
	public JSONObject selectStoreSource(int state, AdminUser user) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		if(TextUtil.isEmpty(String.valueOf(state)) || TextUtil.isNullObject(user)){
			json.put("status", 2);
			json.put("msg", "重新提交");
			return json;
		}
		List<StoreSource> list = storeSourceDao.selectStoreSource(state);
		List<StoreMsg> msgList  = new ArrayList<StoreMsg>();
		if(list.size()!=0){
			StoreMsg sm = null;
			for(StoreSource ss : list){
				sm = new StoreMsg();
				sm.setId(ss.getStoreId());
				sm.setPhone(ss.getPublish().getAdminUser().getPhone());
				try {
					sm.setRegisterDate("已注册"+TimeUtil.getMonths(ss.getPublish().getAdminUser().getCreateDate().toString())+"个月");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sm.setStoreCover("体积:"+ss.getVolumn()+"可用面积:"+ss.getArea());
				sm.setStoreDate(ss.getStartDate().toString());
				sm.setStorePlace(ss.getPlace());
				sm.setStoreName(ss.getName());
				sm.setType(ss.getType());
				sm.setUserName(ss.getPublish().getAdminUser().getUserName());
				msgList.add(sm);
			}
		}
		json.put("status", 1);
		json.put("msg", "信息如下");
		json.put("data", msgList);
		return json;
	}

}

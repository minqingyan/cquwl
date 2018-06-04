package com.cactus.cquwl.serviceImp;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.CacheUtil;
import com.cactus.cquwl.Util.CacheUtils;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.dao.IGoodSourceDao;
import com.cactus.cquwl.dao.IMyPublishDao;
import com.cactus.cquwl.dao.IStoreGoodDao;
import com.cactus.cquwl.domain.entity.GoodMsg;
import com.cactus.cquwl.domain.entity.GoodsTable;
import com.cactus.cquwl.domain.entity.ResultCarMsg;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.MyPublish;
import com.cactus.cquwl.pojo.StoreGood;
import com.cactus.cquwl.service.IGoodSourceService;

@Service
public class GoodSourceServiceImp implements IGoodSourceService{
	
	private static final String foodImg="assets/img/good/9CDE70645C3D943526B526C0300707B.jpg";
	private static final String person="assets/img/person/up_img01.jpg";
	
	@Autowired
	private IGoodSourceDao goodSourceDao;
	
	@Autowired
	protected IMyPublishDao publishDao;
	
	@Autowired
	private IStoreGoodDao storeGoodDao;
	
	@Transactional
	public List<ResultCarMsg> saveGoodSource(BasicGood good,AdminUser user) {
		// TODO Auto-generated method stub
		//先保存到发布中去
		if(!TextUtil.isNullObject(good) && !TextUtil.isNullObject(user)){
			//保存后持久化 BasicGood对象
			MyPublish publish=new MyPublish();
			publish.setAdminUser(user);
			publish.setState(1);
			publish.setFlag(2);
			good.setPublish(publish);
			good.setPublishTime(TimeUtil.getCurrentDate());
			BasicGood bg = goodSourceDao.saveGoodSource(good);
			// 保存到缓存中
			CacheUtils.put("dzshCache", user.getPhone().toString(), bg);
		}
		return null;
	}

	@Override
	@Transactional
	public JSONObject getGoodsTable(AdminUser user) {
		// TODO Auto-generated method stub
		List<BasicGood> goodList=goodSourceDao.getGoodSource(1);
		List<GoodMsg> tables=new ArrayList<GoodMsg>();
		GoodMsg gt=null;
		for(BasicGood good:goodList){
			gt=new GoodMsg();
			gt.setStartPlace(good.getPlaceStart());
			gt.setDestination(good.getPlaceArrive()==null ? "" :good.getPlaceArrive().toString());
			gt.setGoodOwnerName(good.getPublish().getAdminUser().getUserName());
			try {
				gt.setRegisterDate("已注册"+TimeUtil.getMonths(good.getPublish().getAdminUser().getCreateDate().toString())+"个月");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gt.setImg(person);
			gt.setPublishTime(good.getPublishTime() == null ? "" : good.getPublishTime().toString());
			gt.setType(good.getName());
			gt.setTotalMsg(" 体积:"+good.getVolumn()+",重量:"+good.getWeight());
			StringBuffer sb = new StringBuffer();
			System.out.println(good.getUnitLength());
			if(good.getUnitLength() == 0 || good.getUnitWidth() == 0 || good.getUnitHeight() == 0 || good.getUnitWeight() == 0){
				sb.append("");
			}else{
				sb.append("单件长"+good.getUnitLength().toString());
				sb.append(",宽"+good.getUnitWidth().toString());
				sb.append(",高"+good.getUnitHeight().toString());
				sb.append(",重量"+good.getUnitWeight().toString());
			}
			gt.setUnitMsg(sb.toString());
			gt.setId(good.getGoodId());
			gt.setPhone(good.getPublish()!=null?good.getPublish().getAdminUser().getPhone():"");
			gt.setPublishTime(good.getPublishTime()==null?"":good.getPublishTime().toString());
			gt.setDeliveryTime(good.getDeliveryTime()==null?"":good.getDeliveryTime().toString());
			gt.setUnloadTime(good.getUnloadTime()==null?"":good.getUnloadTime().toString());
			tables.add(gt);
		}
		JSONObject json=new JSONObject();
		json.put("data", tables);
		return json;
	}
	
	
	@Override
	@Transactional
	public JSONObject getMyGoodsTable(AdminUser user) {
		// TODO Auto-generated method stub
		List<BasicGood> goodList=goodSourceDao.getMyGoodSource(1,user);
		List<GoodMsg> tables=new ArrayList<GoodMsg>();
		GoodMsg gt=null;
		for(BasicGood good:goodList){
			gt=new GoodMsg();
			gt.setStartPlace(good.getPlaceStart());
			gt.setDestination(good.getPlaceArrive().toString());
			gt.setGoodOwnerName(good.getPublish().getAdminUser().getUserName());
			try {
				gt.setRegisterDate("已注册"+TimeUtil.getMonths(good.getPublish().getAdminUser().getCreateDate().toString())+"个月");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gt.setImg(person);
			gt.setPublishTime(good.getPublishTime() == null ? "" : good.getPublishTime().toString());
			gt.setType(good.getName());
			gt.setTotalMsg(" 体积:"+good.getVolumn()+",重量:"+good.getWeight());
			StringBuffer sb = new StringBuffer();
			System.out.println(good.getUnitLength());
			if(good.getUnitLength() == 0 || good.getUnitWidth() == 0 || good.getUnitHeight() == 0 || good.getUnitWeight() == 0){
				sb.append("");
			}else{
				sb.append("单件长"+good.getUnitLength().toString());
				sb.append(",宽"+good.getUnitWidth().toString());
				sb.append(",高"+good.getUnitHeight().toString());
				sb.append(",重量"+good.getUnitWeight().toString());
			}
			gt.setUnitMsg(sb.toString());
			gt.setId(good.getGoodId());
			gt.setPhone(good.getPublish()!=null?good.getPublish().getAdminUser().getPhone():"");
			gt.setPublishTime(good.getPublishTime()==null?"":good.getPublishTime().toString());
			gt.setDeliveryTime(good.getDeliveryTime()==null?"":good.getDeliveryTime().toString());
			gt.setUnloadTime(good.getUnloadTime()==null?"":good.getUnloadTime().toString());
			tables.add(gt);
		}
		JSONObject json=new JSONObject();
		json.put("data", tables);
		return json;
	}

	@Override
	@Transactional
	public JSONObject getMyStoreGoodsTable(AdminUser user) {
		// TODO Auto-generated method stub
		List<StoreGood> goodList=goodSourceDao.getMyStoreGoodSource(1,user);
		List<GoodMsg> tables=new ArrayList<GoodMsg>();
		GoodMsg gt=null;
		for(StoreGood good:goodList){
			gt=new GoodMsg();
			gt.setStartPlace(good.getStoreArea());
			gt.setDestination("");
			gt.setGoodOwnerName(good.getMyPublish().getAdminUser().getUserName());
			try {
				gt.setRegisterDate("已注册"+TimeUtil.getMonths(good.getMyPublish().getAdminUser().getCreateDate().toString())+"个月");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gt.setImg(person);
			gt.setPublishTime(good.getPublishDate() == null ? "" : good.getPublishDate().toString());
			gt.setType(good.getName());
			gt.setTotalMsg(" 体积:"+good.getVolumn() +",重量:"+good.getWeight() );
			gt.setUnitMsg("预计占用面积:"+ good.getCover());
			gt.setId(good.getGoodId());
			gt.setPhone(good.getMyPublish()!=null?good.getMyPublish().getAdminUser().getPhone():"");
			gt.setPublishTime(good.getPublishDate()==null?"":good.getPublishDate().toString());
			gt.setDeliveryTime(good.getStoreDate());
			gt.setUnloadTime("");
			tables.add(gt);
		}
		JSONObject json=new JSONObject();
		json.put("data", tables);
		return json;
	}
	
	@Override
	@Transactional
	public JSONObject getStoreGoodsTable(AdminUser user) {
		// TODO Auto-generated method stub
		List<StoreGood> goodList=storeGoodDao.selectStoreGoodList(1);
		List<GoodMsg> tables=new ArrayList<GoodMsg>();
		GoodMsg gt=null;
		for(StoreGood good:goodList){
			gt=new GoodMsg();
			gt.setStartPlace(good.getStoreArea());
			gt.setDestination("");
			gt.setGoodOwnerName(good.getMyPublish().getAdminUser().getUserName());
			try {
				gt.setRegisterDate("已注册"+TimeUtil.getMonths(good.getMyPublish().getAdminUser().getCreateDate().toString())+"个月");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gt.setImg(person);
			gt.setPublishTime(good.getPublishDate() == null ? "" : good.getPublishDate().toString());
			gt.setType(good.getName());
			gt.setTotalMsg(" 体积:"+good.getVolumn() +",重量:"+good.getWeight() );
			gt.setUnitMsg("预计占用面积:"+ good.getCover());
			gt.setId(good.getGoodId());
			gt.setPhone(good.getMyPublish()!=null?good.getMyPublish().getAdminUser().getPhone():"");
			gt.setPublishTime(good.getPublishDate()==null?"":good.getPublishDate().toString());
			gt.setDeliveryTime(good.getStoreDate());
			gt.setUnloadTime("");
			tables.add(gt);
		}
		JSONObject json=new JSONObject();
		json.put("data", tables);
		return json;
	}

	@Override
	@Transactional
	public String deleteGoodSource(String flag, String id) {
		// TODO Auto-generated method stub
		if(TextUtil.isEmpty(flag) || TextUtil.isEmpty(id))
			return "views/center/wdfbgood";
		if(flag.equals("1"))
			storeGoodDao.deleteStoreGood(id);
		if(flag.equals("2"))
			goodSourceDao.deleteGood(id);
		return "views/center/wdfbgood";
	}
	
}

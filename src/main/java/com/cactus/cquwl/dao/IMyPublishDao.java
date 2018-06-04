package com.cactus.cquwl.dao;

import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.MyPublish;

public interface IMyPublishDao {

	MyPublish saveMyPublish(MyPublish publish);
	MyPublish findMyPublishById(Integer id);
	
	MyPublish findMyPublishByUser(AdminUser user);
}

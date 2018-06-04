package com.cactus.cquwl.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.dao.IMyPublishDao;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.MyPublish;

@Repository
public class MyPublishDaoImp implements IMyPublishDao{

	@PersistenceContext  
    private EntityManager em;

	@Override
	public MyPublish saveMyPublish(MyPublish publish) {
		// TODO Auto-generated method stub
		if(em.contains(publish)|| publish.getPuId()!=null)
			em.merge(publish);
		em.persist(publish);
		return publish;
	}
	
	@Override
	public MyPublish findMyPublishById(Integer id) {
		// TODO Auto-generated method stub
		MyPublish publish= em.find(MyPublish.class, id);
		return publish;
	}

	@Override
	public MyPublish findMyPublishByUser(AdminUser user) {
		// TODO Auto-generated method stub
		TypedQuery<MyPublish> typedQuery=em.createNamedQuery("CQUWL_FIND_MYPUBLISH_BY_USER", MyPublish.class);
		typedQuery.setParameter("user", user);
		return typedQuery.getSingleResult();
	}
}

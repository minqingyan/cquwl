package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.IGoodSourceDao;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.MyPublish;
import com.cactus.cquwl.pojo.StoreGood;

@Repository
public class GoodSourceDaoImp implements IGoodSourceDao{

	@PersistenceContext  
    private EntityManager em;
	
	public BasicGood saveGoodSource(BasicGood good) {
		// TODO Auto-generated method stub
		if(good.getGoodId()!=null || em.contains(good))
			em.merge(good);
		else
			em.persist(good);
		return good;
	}

	@Override
	public List<BasicGood> getGoodSource(int state) {
		// TODO Auto-generated method stub
		TypedQuery<BasicGood> typedQuery=em.createNamedQuery("CQUWL_FIND_BASICGOOD_BY_STATE", BasicGood.class);
		typedQuery.setParameter("state", state);
		return typedQuery.getResultList();
	}

	@Override
	public BasicGood findGoodSource(String id) {
		// TODO Auto-generated method stub
		if(!TextUtil.isEmpty(id))
			return em.find(BasicGood.class, Integer.parseInt(id));
		return null;
	}

	@Override
	public List<BasicGood> getMyGoodSource(int state, AdminUser adminUser) {
		// TODO Auto-generated method stub
		TypedQuery<BasicGood> typedQuery=em.createNamedQuery("CQUWL_FIND_MY_BASICGOOD_BY_ADMINUSER_AND_STATE", BasicGood.class);
		typedQuery.setParameter("state", state);
		typedQuery.setParameter("adminUser", adminUser);
		return typedQuery.getResultList();
	}
	
	@Override
	public List<StoreGood> getMyStoreGoodSource(int state, AdminUser adminUser) {
		// TODO Auto-generated method stub
		TypedQuery<StoreGood> typedQuery=em.createNamedQuery("CQUWL_FIND_MY_STOREGOOD_BY_ADMINUSER_AND_STATE", StoreGood.class);
		typedQuery.setParameter("state", state);
		typedQuery.setParameter("adminUser", adminUser);
		return typedQuery.getResultList();
	}
	
	@Override
	public void deleteGood(String id) {
		// TODO Auto-generated method stub
		BasicGood sg = em.find(BasicGood.class, Integer.parseInt(id));
		em.remove(sg);
	}


}

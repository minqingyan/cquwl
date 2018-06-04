package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.IStoreGoodDao;
import com.cactus.cquwl.pojo.StoreGood;

@Repository
public class StoreGoodDaoImp implements IStoreGoodDao{

	@PersistenceContext  
    private EntityManager em;
	
	@Override
	public StoreGood addStoreGood(StoreGood sg) {
		// TODO Auto-generated method stub
		if(sg.getGoodId() != null || em.contains(sg))
			em.merge(sg);
		else
			em.persist(sg);
		return sg;
	}

	@Override
	public StoreGood findStoreGood(String id) {
		// TODO Auto-generated method stub
		if(!TextUtil.isEmpty(id))
			return (StoreGood)em.find(StoreGood.class, Integer.parseInt(id));
		return null;
	}

	@Override
	public List<StoreGood> selectStoreGoodList(int state) {
		// TODO Auto-generated method stub
		TypedQuery<StoreGood> typedQuery = em.createNamedQuery("CQUWUL_SELECT_STOREGOOD_STATE", StoreGood.class);
		typedQuery.setParameter("state", state);
		return typedQuery.getResultList();
	}

	@Override
	public void deleteStoreGood(String id) {
		// TODO Auto-generated method stub
		StoreGood sg = em.find(StoreGood.class, Integer.parseInt(id));
		em.remove(sg);
	}

}

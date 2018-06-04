package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.IStoreSourceDao;
import com.cactus.cquwl.pojo.StoreSource;

@Repository
public class StoreSourceDaoImp implements IStoreSourceDao{

	@PersistenceContext  
    private EntityManager em;
	
	@Override
	public StoreSource saveStoreSource(StoreSource store) {
		// TODO Auto-generated method stub
		if(em.contains(store) || store.getStoreId()!=null){
			em.merge(store);
		}else{
			store.setState(1);
			em.persist(store);
		}
		return store;
	}

	@Override
	public StoreSource findStoreSourceById(String id) {
		// TODO Auto-generated method stub
		if(!TextUtil.isEmpty(id))
			return em.find(StoreSource.class, Integer.parseInt(id));
		return null;
	}

	@Override
	public List<StoreSource> selectStoreSource(int state) {
		// TODO Auto-generated method stub
		TypedQuery<StoreSource> typedQuery = em.createNamedQuery("CQUWL_SELECT_STORESOURCE_STATE", StoreSource.class);
		typedQuery.setParameter("state", state);
		return typedQuery.getResultList();
	}

}

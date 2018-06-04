package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.cactus.cquwl.dao.IRemainCarSourceDao;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.RemainCarSource;

@Repository
public class RemainCarSourceDaoImp implements IRemainCarSourceDao{

	@PersistenceContext  
    private EntityManager em;
	
	@Override
	public RemainCarSource findAvailableCarSource(CarSource cs, int state) {
		// TODO Auto-generated method stub
		TypedQuery<RemainCarSource> typedQuery=em.createNamedQuery("CQUWL_FIND_REMAINCARSOURCE_BY_CARSOURCE_AND_STATE", RemainCarSource.class);
		typedQuery.setParameter("carSource", cs);
		typedQuery.setParameter("state", state);
		List<RemainCarSource> list = typedQuery.getResultList();
		
		if(list.size()!=0)
			return list.get(0);
		return null;
	}
	

}

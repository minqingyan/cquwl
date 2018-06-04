package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.dao.ICarAssessDao;
import com.cactus.cquwl.pojo.AllCarAssess;
import com.cactus.cquwl.pojo.CarAssess;
import com.cactus.cquwl.pojo.CarSource;

@Repository
public class CarAssessDaoImp implements ICarAssessDao{

	@PersistenceContext  
    private EntityManager em;
	
	@Override
	public AllCarAssess readCarAssessById(CarSource car) {
		// TODO Auto-generated method stub
		TypedQuery<AllCarAssess> typedQuery = em.createNamedQuery("CQUWL_FIND_CARASSESS_BY_CAR", AllCarAssess.class);
		typedQuery.setParameter("car",car);
		List<AllCarAssess> list = typedQuery.getResultList();
		if(list.size() != 0)
			return list.get(0);
		return null;
	}

	@Override
	public CarAssess addCarAssess(CarAssess ca) {
		// TODO Auto-generated method stub
		if(ca.getCarAssId() != null || em.contains(ca))
			em.merge(ca);
		else
			em.persist(ca);
		return ca;
	}

	@Override
	public AllCarAssess addAllCarAssess(AllCarAssess allCarAssess) {
		// TODO Auto-generated method stub
		if(allCarAssess.getCarAssId() != null || em.contains(allCarAssess))
			em.merge(allCarAssess);
		else
			em.persist(allCarAssess);
		return allCarAssess;
	}

	
}

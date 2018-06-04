package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.ICarSourceDao;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

@Repository
public class CarSourceDaoImp implements ICarSourceDao{

	@PersistenceContext  
    private EntityManager em;
	
	@Override
	public CarSource addCarMsg(CarSource good) {
		// TODO Auto-generated method stub
		if(good.getCarId()!=null || em.contains(good)){
			em.merge(good);
		}else{
			em.persist(good);
		}
		return good;
	}


	@Override
	public List<CarSource> selectCarSourceList(int firstState, int endState) {
		// TODO Auto-generated method stub
		TypedQuery<CarSource> typedQuery=em.createNamedQuery("CQUWL_FIND_CARSOURCE_BY_STATE", CarSource.class);
		typedQuery.setParameter("firstState", firstState);
		typedQuery.setParameter("endState", endState);
		return typedQuery.getResultList();
	}


	@Override
	public CarSource findCarSourceById(String id) {
		// TODO Auto-generated method stub
		if(!TextUtil.isEmpty(id))
			return em.find(CarSource.class, Integer.parseInt(id));
		else
			return null;
	}

	@Override
	public List<CarSource> selectCarSourceListByBasicGood(BasicGood basicGood) {
		// TODO Auto-generated method stub
		TypedQuery<CarSource> typedQuery=em.createNamedQuery("CQUWL_FIND_CARSOURCE_BY_PLACE_WEIGHT_TIME", CarSource.class);
		
		typedQuery.setParameter("startTime",basicGood.getDeliveryTime().toString());
		typedQuery.setParameter("placeStart", basicGood.getPlaceStart().toString());
		typedQuery.setParameter("placeArrive", basicGood.getPlaceArrive().toString());
		return typedQuery.getResultList();
	}
}

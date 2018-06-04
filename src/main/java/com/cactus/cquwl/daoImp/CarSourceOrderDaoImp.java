package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.ICarSourceOrderDao;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.MyOrders;

@Repository
public class CarSourceOrderDaoImp implements ICarSourceOrderDao{

	@PersistenceContext  
    private EntityManager em;
	
	@Override
	public MyOrders saveOrder(MyOrders myorder) {
		// TODO Auto-generated method stub
		if(myorder.getId()!=null || em.contains(myorder)){
			em.merge(myorder);
		}else{
			em.persist(myorder);
		}
		return myorder;
	}

	@Override
	public List<MyOrders> findOrdersByUser(AdminUser user, int flag) {
		// TODO Auto-generated method stub
		
		TypedQuery<MyOrders> typedQuery=em.createNamedQuery("CQUWL_FIND_ORDERS_BY_USER", MyOrders.class);
		typedQuery.setParameter("user", user);
		typedQuery.setParameter("flag", flag);
		return typedQuery.getResultList();
	}

	@Override
	public MyOrders findOrderById(String id) {
		// TODO Auto-generated method stub
		if(!TextUtil.isEmpty(id))
			return em.find(MyOrders.class, id);
		else
			return null;
	/*	TypedQuery<MyOrders> typedQuery=em.createNamedQuery("CQUWL_FIND_ORDERS_BY_ID", MyOrders.class);
		typedQuery.setParameter("orderId", id);
		List<MyOrders> list = typedQuery.getResultList();
		return list.get(0);*/
	}

}

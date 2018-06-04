package com.cactus.cquwl.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cactus.cquwl.dao.IAdminUserDao;
import com.cactus.cquwl.pojo.AdminUser;

@Repository
public class AdminUserDaoImp implements IAdminUserDao{
	
	@PersistenceContext  
    private EntityManager em;

	public AdminUser selectAdminUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminUser findAdminUserByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminUser selectAdminUserByPhone(String phone) {
		// TODO Auto-generated method stub
		TypedQuery<AdminUser> typedQuery=em.createNamedQuery("CQUWL_SELECT_ADMINUSER_BY_PHONE",AdminUser.class);
		typedQuery.setParameter("phone", phone);
		
		List<AdminUser> list = typedQuery.getResultList();
		if(list.size() !=0 )
			return list.get(0);
		else
			return null;
	}

	@Override
	public AdminUser saveAdminUser(AdminUser user) {
		// TODO Auto-generated method stub
		if(em.contains(user) || user.getAdminUserId()!=null){
			em.merge(user);
		}else{
			em.persist(user);
		}
		return user;
	} 

}

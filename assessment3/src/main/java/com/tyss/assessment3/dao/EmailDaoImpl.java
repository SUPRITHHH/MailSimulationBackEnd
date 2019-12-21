package com.tyss.assessment3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.assessment3.dto.UserInformation;


@Repository
public class EmailDaoImpl implements EmailDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public UserInformation login(String email, String password) {
		String jpql = "from UserInformation where email=:email and password=:password";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserInformation> query = manager.createQuery(jpql,UserInformation.class);
		query.setParameter("email",email);
		query.setParameter("password", password);
		try {
			UserInformation bean = query.getSingleResult();
		return bean;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int register(UserInformation bean) {

	    EntityManager manager = factory.createEntityManager();
	    EntityTransaction transaction = manager.getTransaction();
	    transaction.begin();
	    try {
	    	manager.persist(bean);
	    	transaction.commit();
	    	return bean.getUid();
	    }catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	

	
}

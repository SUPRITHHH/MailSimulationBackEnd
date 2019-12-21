package com.tyss.mailsimulation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.mailsimulation.dto.Mail_Info;
import com.tyss.mailsimulation.dto.User_Info;
@Repository
public class MailSimulationDaoImpl implements MailSimulationDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<Mail_Info> inbox(User_Info userInfo) {
		EntityManager manager = factory.createEntityManager();
		int id = userInfo.getUid();
		String jpql = "from Mail_Info where to_id=:id";
		TypedQuery<Mail_Info> query = manager.createQuery(jpql, Mail_Info.class);
		query.setParameter("id", id);
		List<Mail_Info> mailInfos = query.getResultList();
		return mailInfos;
	}

	@Override
	public List<Mail_Info> sentItems(User_Info userInfo) {
		EntityManager manager = factory.createEntityManager();
		int id = userInfo.getUid();
		String jpql = "from Mail_Info where from_id=:id";
		TypedQuery<Mail_Info> query = manager.createQuery(jpql, Mail_Info.class);
		query.setParameter("id", id);
		List<Mail_Info> mailInfos = query.getResultList();
		return mailInfos;
	}

	@Override
	public boolean composeMail(User_Info userInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(userInfo);
			transaction.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}

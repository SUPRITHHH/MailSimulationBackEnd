package com.tyss.mail.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.mail.dto.Mail_Info;

@Repository
public class MailSimulationDaoImpl implements MailSimulationDAO{

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean deleteMail(int mid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Mail_Info bean = manager.find(Mail_Info.class, mid);
		manager.remove(bean);
		transaction.commit();
		return true;
	}

}

package com.assisenior.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.assisenior.model.User;

public class UserService {

	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");;	
	
	private static EntityManager em = factory.createEntityManager();
	private static Query query;


	public static User create(User user) {
		query = em.createQuery("SELECT u FROM User u WHERE u.login = :param");
		query.setParameter("param", user.getLogin());
		List results = (List) query.getResultList();
		Iterator it = results.iterator();
		boolean LoginExist = false;

		while(it.hasNext()){
			LoginExist = true;
			break;
		}

		if(!LoginExist) {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return user;
		} else {
			return null;
		}
	}


	public static User find(String login, String password) {
		query = em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :pass");
		query.setParameter("login", login);
		query.setParameter("pass", password);
		
		List results = (List) query.getResultList();
		User user = new User();
		for(int i=0; i < results.size(); i++) {
			user = (User) results.get(i);
			break;
		}
		
		if (login.equalsIgnoreCase(user.getLogin()) && password.equals(user.getPassword())) {
			return user;
		} else {
			return null;
		}
	}
}

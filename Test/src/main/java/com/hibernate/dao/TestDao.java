package com.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

import com.hibernate.dto.User;

public class TestDao {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	public void saveUser(User u) {
		manager.persist(u);
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
		
		public void updateUser(User u) {
			manager.merge(u);
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			transaction.commit();
			
		}
		 public User getById(int id) {
			 User u=manager.find(User.class,id);
			 return u;
		 }
		 
		 public List<User> getAllUser(){
			 String hql="select u from User u";
			 Query q= manager.createQuery(hql);
			 List<User> list =q.getResultList();
			 return list;
			 
		 }
		 
		 public boolean deleteUser(int id) {
			 User u=manager.find(User.class,id);
			 if(u!=null) {
				 manager.remove(u);
				 EntityTransaction transaction =manager.getTransaction();
				 transaction.begin();
				 transaction.commit();
				 return true;
			 }
			 return false;
		 }
		
	}



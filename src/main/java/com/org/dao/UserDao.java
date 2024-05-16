package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Notes;
import com.org.dto.User;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
EntityManager em = emf.createEntityManager();
EntityTransaction et = em.getTransaction();
	public void saveAndUpdateUser(User user) {
		
		User u=new User();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setMobile(user.getMobile());
		u.setNotes(user.getNotes());
		et.begin();
		em.merge(u);
		et.commit();
	}
	public User fetchUserById(int id) {
		
		User user = em.find(User.class, id);
		return user;
	}
	public List<User> fetchAllUsers(){
		
		Query q = em.createQuery("select u from User u");
		List<User> resultList = q.getResultList();
		return resultList;
	}
	public User fetchUserByEmailAndPassword(String email,String password) {
		
		Query q = em.createQuery("Select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<User> list = q.getResultList();
		if(list.size()>=1)
		return list.get(0);
		else
			return null;
	}
	public void addNote(User user,List<Notes> list) {
		
		User u = em.find(User.class, user.getId());
		u.setNotes(list);
		et.begin();
		em.merge(u);
		et.commit();
	}
	public List<Notes> fetchUserNotes(User u){
		
		User user = em.find(User.class, u.getId());
		List<Notes> notes = user.getNotes();
		return notes;
	}
}

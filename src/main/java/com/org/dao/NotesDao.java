package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Notes;

public class NotesDao {
	public Notes fetchNotesById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		EntityManager em = emf.createEntityManager();
		Notes notes = em.find(Notes.class, id);
		return notes;
	}
	public List<Notes> fetchAllNotes(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select n from Notes n");
		List<Notes> resultList = query.getResultList();
		return resultList;
	}
}

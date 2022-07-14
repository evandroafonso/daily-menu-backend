package com.daily.menu.domain.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
	
	public static void main( String[] args ){
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("localhost/daily-menu");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            
            Product product = new Product();
            
            product.setName("Maçã");
            product.setFeature("Fruta");
            product.setQuantity(1);
           
    
            entityManager.persist(product);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }finally{
            entityManager.close();
            emf.close();
        }
    }

}

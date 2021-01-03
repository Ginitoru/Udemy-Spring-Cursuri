package com.luv2code.hibernate.demo.entity.demo;

import com.luv2code.hibernate.demo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceAuto");
        EntityManager em = emf.createEntityManager();


        try{

            Student student1 = new Student("gica", "vasile", "bbb@com.com");
            Student student2 = new Student("ion", "rica", "aaa@com.com");
            Student student3 = new Student("victor", "gigica", "yyy@com.com");

            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }



    }
}

package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.entity.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            em.getTransaction().begin();


            Instructor instructor = em.find(Instructor.class, 1);

            System.out.println(instructor);

            if(instructor != null){
                em.remove(instructor);

            }

            em.getTransaction().commit();
            




        }finally {
            em.close();
            emf.close();
        }


    }
}

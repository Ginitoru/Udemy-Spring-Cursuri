package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();



        try{

            Instructor instructor = new Instructor("chad", "patel", "sdcccf@xx.com");
            InstructorDetail instructorDetail = new InstructorDetail("zzz.youtube.com", "volei");

            instructor.setInstructorDetail(instructorDetail);

            em.getTransaction().begin();

            em.persist(instructor);

            em.getTransaction().commit();




        }finally {
            em.close();
            emf.close();
        }




    }
}

package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try {

            em.getTransaction().begin();

            InstructorDetail instructorDetail = em.find(InstructorDetail.class, 3);
            //setam instructorul null ca sa il putem sterge ->altfel nu ne lasa sa il stergem deoarce exista legatura intre cele 2 obiecte
            instructorDetail.getInstructor().setInstructorDetail(null);
            System.out.println(instructorDetail);
            em.remove(instructorDetail);

            em.getTransaction().commit();


        } finally {

            em.close();
            emf.close();

        }

    }
}
package com.luv2code.hibernate.demo.entity.demo;

import com.luv2code.hibernate.demo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UppdateStudentDemo {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceAuto");
        EntityManager em = emf.createEntityManager();

        try{

            int studentId = 1;

            String query = "UPDATE Student s SET s.email = :email WHERE s.id = :id ";



            em.getTransaction().begin();

            Query update = em.createQuery(query)
                            .setParameter("email", "xxx@xx.com")
                            .setParameter("id", studentId);

            System.out.println(update.executeUpdate());
            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }


    }
}

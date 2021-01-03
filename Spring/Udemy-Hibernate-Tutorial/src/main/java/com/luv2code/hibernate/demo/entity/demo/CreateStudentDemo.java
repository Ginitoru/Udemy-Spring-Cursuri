package com.luv2code.hibernate.demo.entity.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateStudentDemo {
    public static void main(String[] args) {

//        SessionFactory factory = new Configuration()
//                                .configure("hibernate.cfg.xml")
//                                .addAnnotatedClass(Student.class)
//                                .buildSessionFactory();
//
//
//        Session session = factory.getCurrentSession();
//
//
//        try{
//
//            System.out.println("Creating student..");
//            Student student = new Student("paul", "wall", "xx@gmail.com");
//
//            session.beginTransaction();
//            session.save(student);
//            session.getTransaction().commit();
//            System.out.println("done");
//
//
//
//
//        }finally {
//            factory.close();
//        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceAuto");
        EntityManager em  = emf.createEntityManager();


        try{
            Student student = new Student("paul", "wall", "xx@gmail.com");

            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }


    }
}

package com.luv2code.hibernate.demo.entity.demo;

import com.luv2code.hibernate.demo.entity.Student;

import javax.persistence.Persistence;
import java.beans.PersistenceDelegate;

public class ReadStudentDemo {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("serviceAuto");
        var em = emf.createEntityManager();


        try{

            Student student = new Student("XXX", "YYY", "zzz@yahoo.com");

            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();

            Student student2 = em.find(Student.class, student.getId());
            System.out.println(student2);

        }finally {
            em.close();
            emf.close();
        }




    }
}

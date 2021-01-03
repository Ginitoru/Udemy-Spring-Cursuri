package com.luv2code.hibernate.demo.entity.demo;

import com.luv2code.hibernate.demo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceAuto");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT s FROM Student s";

        List<Student> students = em.createQuery(query,Student.class)
                                .getResultList();


        displayStudents(students);

        String query2 = "SELECT s FROM Student s WHERE s.lastName =: lastName";

        List<Student> students1 = em.createQuery(query2,Student.class)
                            .setParameter("lastName","gigica")
                            .getResultList();

        System.out.println("*****************************");

        displayStudents(students1);


        System.out.println("*****************************");

        String query3 = "SELECT s FROM Student s WHERE s.lastName =: lastName OR s.firstName =: firstName ";

        List<Student> students3 = em.createQuery(query3, Student.class)
                                    .setParameter("lastName", "gigica")
                                    .setParameter("firstName", "XXX")
                                    .getResultList();

        displayStudents(students3);


        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        String query4 = "SELECT s FROM Student s WHERE s.email LIKE '%com.com'";

        List<Student> students4 = em.createQuery(query4, Student.class)
                                  .getResultList();

        displayStudents(students4);







    }

    private static void displayStudents(List<Student> students) {
        for(Student x: students){
            System.out.println(x);
        }
    }
}

package luv2.code.demo;

import luv2.code.entiy.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex5 {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            em.getTransaction().begin();

            Instructor instructor = em.find(Instructor.class, 1);

            System.out.println("luv2code : instructor" + instructor);
            System.out.println("luv2code : courser: " + instructor.getCourses());


            em.getTransaction().commit();
            em.close();


            System.out.println("luv2code : courser: " + instructor.getCourses());


        }finally {

            emf.close();
        }




    }
}

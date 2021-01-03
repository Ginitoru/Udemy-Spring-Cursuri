package luv2.code.demo;

import luv2.code.entiy.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();



        try{

            em.getTransaction().begin();

            Instructor instructor = em.find(Instructor.class, 1);

            System.out.println("instructor" + instructor);

            System.out.println("courser: " + instructor.getCourses());



            em.getTransaction().commit();



        }finally {
            em.close();
            emf.close();
        }


    }
}

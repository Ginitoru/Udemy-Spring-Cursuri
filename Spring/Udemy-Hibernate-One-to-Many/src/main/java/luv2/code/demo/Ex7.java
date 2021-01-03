package luv2.code.demo;

import luv2.code.entiy.Course;
import luv2.code.entiy.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex7 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();



        try{

            em.getTransaction().begin();

            Course course = new Course("pacman");

            course.addReview(new Review("great"));
            course.addReview(new Review("funny"));
            course.addReview(new Review("uau"));
            course.addReview(new Review("belea"));

            em.persist(course);

            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }


    }
}

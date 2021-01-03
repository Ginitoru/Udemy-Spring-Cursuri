package luv2.code.demo;

import luv2.code.entiy.Course;
import luv2.code.entiy.Instructor;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {

        var emf= Persistence.createEntityManagerFactory("udemy");
        var em = emf.createEntityManager();


        try{


            em.getTransaction().begin();

            Instructor instructor = em.find(Instructor.class, 1);

            Course course = new Course("footbal");
            Course course2 = new Course("chess");

            instructor.add(course);
            instructor.add(course2);

            em.persist(instructor);



            em.getTransaction().commit();






        }finally {
            em.close();
            emf.close();
        }


    }

}

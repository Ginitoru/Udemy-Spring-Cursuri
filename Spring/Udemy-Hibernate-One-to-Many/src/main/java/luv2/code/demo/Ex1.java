package luv2.code.demo;

import luv2.code.entiy.Instructor;
import luv2.code.entiy.InstructorDetail;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            Instructor instructor = new Instructor("gica", "ion", "xxx@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "dance");

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

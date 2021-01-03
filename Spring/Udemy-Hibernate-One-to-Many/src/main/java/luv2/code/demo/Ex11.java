package luv2.code.demo;

import luv2.code.entiy.Course;
import luv2.code.entiy.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex11 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            em.getTransaction().begin();

//            Course course = em.find(Course.class, 10);
//
//            em.remove(course);

            Student student = em.find(Student.class, 1);

            em.remove(student);



            em.getTransaction().commit();




        }finally {
            em.close();
            emf.close();
        }
    }
}

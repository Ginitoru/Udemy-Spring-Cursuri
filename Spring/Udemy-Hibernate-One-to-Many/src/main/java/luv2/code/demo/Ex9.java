package luv2.code.demo;

import luv2.code.entiy.Course;
import luv2.code.entiy.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex9 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            em.getTransaction().begin();

            Course course = new Course("wow");
            Course course1 = new Course("sc2");

            course.addStudent(new Student("gica", "ion", "asdas@.com"));
//            course.addStudent(new Student("xx", "ccc", "jjj@.com"));
//            course.addStudent(new Student("hhh", "iocccn", "dd@.com"));
//            course.addStudent(new Student("iii", "lll", "jhg@.com"));
//
//            course1.addStudent(new Student("gica", "ion", "asdas@.com"));
//            course1.addStudent(new Student("xx", "ccc", "jjj@.com"));


            em.getTransaction().commit();




        }finally {
            em.close();
            emf.close();

        }

    }
}

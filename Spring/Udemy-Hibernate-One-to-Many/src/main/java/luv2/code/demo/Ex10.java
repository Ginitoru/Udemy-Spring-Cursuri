package luv2.code.demo;

import luv2.code.entiy.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex10 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            em.getTransaction().begin();

//            Student student = em.find(Student.class, 1);
//            System.out.println(student);
//
//            System.out.println(student.getCourses());

            String jpql ="SELECT s FROM Student s JOIN FETCH s.courses  WHERE s.id = :id";

            Student stundet2 = em.createQuery(jpql,Student.class)
                                .setParameter("id", 1)
                                .getSingleResult();

            System.out.println(stundet2.getCourses());
            System.out.println(stundet2.getId());

            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }


    }
}

package luv2.code.demo;

import luv2.code.entiy.Instructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex6 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy");
        EntityManager em = emf.createEntityManager();


        try{

            em.getTransaction().begin();

            String jpql ="SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = :id ";

            Instructor instructor = em.createQuery(jpql, Instructor.class)
                                    .setParameter("id", 1)
                                    .getSingleResult();






            em.getTransaction().commit();






        }finally {
            em.close();
            emf.close();
        }

    }
}

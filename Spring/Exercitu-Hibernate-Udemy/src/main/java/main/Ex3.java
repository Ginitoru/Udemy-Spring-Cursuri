package main;

import javax.persistence.Persistence;
import javax.persistence.Query;

public class Ex3 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("hibernateUdemy");
        var em = emf.createEntityManager();


        try{

            String jpql = "DELETE FROM Employee e WHERE e.id = :id";

            em.getTransaction().begin();

            Query query = em.createQuery(jpql)
                            .setParameter("id", 1);

            System.out.println(query.executeUpdate());

            em.getTransaction().commit();





        }finally {
            em.close();
            emf.close();
        }



    }
}

package com.luv2code.hibernate.demo.entity.demo;

import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("serviceAuto");
        var em = emf.createEntityManager();


        try{

            String jpql = "DELETE FROM Student s WHERE s.id = :id ";

            em.getTransaction().begin();

            Query delete =  em.createQuery(jpql)
                            .setParameter("id", 2);

            System.out.println(delete.executeUpdate());

            em.getTransaction().commit();



        }finally {
            em.close();
            emf.close();
        }


    }
}

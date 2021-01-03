package main;

import model.Employee;

import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("hibernateUdemy");
        var em = emf.createEntityManager();


        try{

            Employee employee1 = new Employee("gigel", "gica", "escavator");
            Employee employee2 = new Employee("xxx", "ion", "haihaubau");
            Employee employee3 = new Employee("fane", "gimbirel", "vantilator");
            Employee employee4 = new Employee("geta", "bioenergeta", "torpila");

            em.getTransaction().begin();
            em.persist(employee1);
            em.persist(employee2);
            em.persist(employee3);
            em.persist(employee4);

            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }





    }
}

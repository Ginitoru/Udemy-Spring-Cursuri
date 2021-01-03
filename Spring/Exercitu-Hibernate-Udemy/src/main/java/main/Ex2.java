package main;

import model.Employee;
import org.hibernate.type.descriptor.java.SerializableTypeDescriptor;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("hibernateUdemy");
        var em = emf.createEntityManager();

        String jpql = "SELECT e FROM Employee e";
        String jpql2 = "SELECT e FROM Employee e WHERE e.id = :id";
        String jpql3 = "SELECT e FROM Employee e WHERE e.company = :company";


        try{

            List<Employee> employees = em.createQuery(jpql, Employee.class)
                                        .getResultList();

            for(Employee e: employees){
                System.out.println(e);
            }

            Employee e = em.createQuery(jpql2, Employee.class)
                        .setParameter("id", 1)
                        .getSingleResult();

            System.out.println("***************************");

            System.out.println(e);

            System.out.println("***************************");

            List<Employee> employees1 = em.createQuery(jpql3, Employee.class)
                                        .setParameter("company", "torpila")
                                        .getResultList();

            System.out.println(employees1);



        }finally {
            em.close();
            emf.close();
        }



    }
}

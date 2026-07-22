package com.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ) {

        // first configure the xml file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter id : ");
//        Long id  = sc.nextLong();
//        sc.nextLine();
//        System.out.print("Enter email : ");
//        String email = sc.nextLine();
//        System.out.print("Enter name : ");
//        String name = sc.nextLine();
//        System.out.println("Enter salary : ");
//        double salary = sc.nextDouble();



        // ========= add a new employee =========
//        Employee e1 = new Employee();
//        e1.setId(id);
//        e1.setName(name);
//        e1.setEmail(email);
//        e1.setSalary(salary);
//        session.persist(e1);
//        transaction.commit();


        // ========= update an employee =========
//        Employee employee = session.find(Employee.class, 1L);
//        if (employee != null) {
//            employee.setName("Adwait Patel");
//            employee.setEmail("adwait@gmail.com");
//            employee.setSalary(56000);
//        }
//        session.persist(employee);
//        transaction.commit();


        // ========= delete an employee =========
//        Employee employee = session.find(Employee.class, 1002L);
//        if (employee != null) {
//            session.remove(employee);
//            System.out.println("Employee deleted successfully.");
//        } else {
//            System.out.println("Employee not found.");
//        }
//        transaction.commit();


        // ========= find employee by email =========
//        Employee employee = session.createQuery(
//                "FROM Employee WHERE email = :email", Employee.class)
//                .setParameter("email", "adp@gmail.com")
//                .uniqueResult();
//        System.out.println(employee == null ? "Not found" : employee);



        // ========= find employees with salary > 50k =========
//        List<Employee> employees = session.createQuery(
//                "FROM Employee WHERE salary > :salary", Employee.class)
//                .setParameter("salary", 50000)
//                .list();
//        for (Employee e : employees) {
//            System.out.println(e);
//        }



        // ========= find avg salary of employees =========
//        Double avgSalary = session.createQuery(
//                "SELECT AVG(salary) FROM Employee", Double.class)
//                .uniqueResult();
//
//        System.out.println("Average Salary : " + avgSalary);




        session.close();
    }
}

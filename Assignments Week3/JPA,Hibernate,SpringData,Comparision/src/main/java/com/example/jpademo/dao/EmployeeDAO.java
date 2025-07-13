package com.example.jpademo.dao;

import com.example.jpademo.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
  private static final SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .buildSessionFactory();

  public Integer addEmployee(Employee employee) {
    Transaction tx = null;
    Integer employeeID = null;
    try (Session session = factory.openSession()) {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
    }
    return employeeID;
  }
}

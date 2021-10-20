package com.javalive.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author javalive.com
 */
@Entity
@Table(name = "EMPLOYEE2")
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "EMP_ID")
   private long id;

   @Column(name = "NAME", nullable = false, unique = true)
   private String name;

   @Column(name = "DESIGNATION")
   private String designation;

   @Column(name = "SALARY")
   private double salary;
   
   /*
	 * There is an important difference that might not be obvious when you look at
	 * the following code snippets. When you map a many-to-many association, you
	 * should use a Set instead of a List as the attribute type. Otherwise,
	 * Hibernate will take a very inefficient approach to remove entities from the
	 * association. It will remove all records from the association table and
	 * re-insert the remaining ones. You can avoid that by using a Set instead of a
	 * List as the attribute type.
	 */

   @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
   @JoinTable(name = "EMPLOYEE_ADDRESS2", 
         joinColumns = { @JoinColumn(name = "EMP_ID") }, 
         inverseJoinColumns = { @JoinColumn(name = "ADDR_ID") })
   private Set<Address> addresses = new HashSet<Address>();

   public Employee() { }
   
   public Employee(String name, String designation, double salary) {
      this.name = name;
      this.designation = designation;
      this.salary = salary;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDesignation() {
      return designation;
   }

   public void setDesignation(String designation) {
      this.designation = designation;
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public Set<Address> getAddresses() {
      return addresses;
   }

   public void setAddresses(Set<Address> addresses) {
      this.addresses = addresses;
   }

}

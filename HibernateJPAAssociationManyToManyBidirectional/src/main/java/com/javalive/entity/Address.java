package com.javalive.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author javalive.com
 */
@Entity
@Table(name = "ADDRESS2")
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ADDR_ID")
   private long id;

   @Column(name = "CITY")
   private String city;

   @Column(name = "STATE")
   private String state;

   @Column(name = "COUNTRY")
   private String country;

   @Column(name = "ZIP")
   private String zip;

   /*
	 * There is an important difference that might not be obvious when you look at
	 * the following code snippet. When you map a many-to-many association, you
	 * should use a Set instead of a List as the attribute type. Otherwise,
	 * Hibernate will take a very inefficient approach to remove entities from the
	 * association. It will remove all records from the association table and
	 * re-insert the remaining ones. You can avoid that by using a Set instead of a
	 * List as the attribute type.
	 */
   
   @ManyToMany(fetch=FetchType.LAZY, mappedBy = "addresses")
   private Set<Employee> employees = new HashSet<Employee>();

   public Address() {  }
   
   public Address(String city, String state, String country, String zip) {
      this.city = city;
      this.state = state;
      this.country = country;
      this.zip = zip;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getZip() {
      return zip;
   }

   public void setZip(String zip) {
      this.zip = zip;
   }

   public Set<Employee> getEmployees() {
      return employees;
   }

   public void setEmployees(Set<Employee> employees) {
      this.employees = employees;
   }
}

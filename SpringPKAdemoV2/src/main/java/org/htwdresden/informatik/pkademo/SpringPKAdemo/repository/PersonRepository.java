package org.htwdresden.informatik.pkademo.SpringPKAdemo.repository;

import java.time.LocalDate;

import java.util.List;

import org.htwdresden.informatik.pkademo.SpringPKAdemo.model.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	//List<Person> findByOrderByBirthDateDesc();
	
	//List<Person> findByBirthDate(LocalDate birthDate);
	
	@Query("SELECT p FROM Person p WHERE p.birthDate = ?1")
	List<Person> findByBirthDate(LocalDate birthDate);
	
	List<Person> findByBirthDateGreaterThan(LocalDate birthDate);
	
	List<Person> findByAddress_Zip(String zip);

	/*
	@Query("SELECT p FROM Person p JOIN p.address a " + 
			"WHERE a.zip = ?1")
	*/
	@Query("SELECT p FROM Person p JOIN p.address WHERE p.address.zip = ?1")
	List<Person> findByZip(String zip);
	
	
	//@Query("SELECT p FROM Person p WHERE p.birthDate.getYear() = ?1")
	//@Query("SELECT p FROM Person p WHERE p.birthDate.getYear().equal(?1)")
	@Query("SELECT p FROM Person p WHERE year(p.birthDate) = ?1")
	List<Person> findByBirthYear(int year);

}

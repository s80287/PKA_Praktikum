package org.htwdresden.informatik.pkademo.SpringPKAdemo.repository;

import java.util.List;

import org.htwdresden.informatik.pkademo.SpringPKAdemo.model.Club;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club, Long>{

	/*
	@Query("select b from Bike b where b.type = ?1 and b.frameSize >= ?2")
    List<Bike> findByTypeAndFrameSizeGreaterThan(String type, Integer frameSize);
	*/
	
    //@Query("SELECT c FROM Club c WHERE c.name LIKE ?1")
	List<Club> findByNameContaining(String name);

}
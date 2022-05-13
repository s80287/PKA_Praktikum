package org.htwdresden.informatik.pkademo.SpringPKAdemo;

import org.htwdresden.informatik.pkademo.SpringPKAdemo.model.Address;
import org.htwdresden.informatik.pkademo.SpringPKAdemo.model.Bike;
import org.htwdresden.informatik.pkademo.SpringPKAdemo.model.Club;
import org.htwdresden.informatik.pkademo.SpringPKAdemo.repository.ClubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
@SpringBootApplication
public class TestClubEntity {

	//private static final Logger log = LoggerFactory.getLogger(SpringPkAdemoApplication.class);
	private static final Logger log = LoggerFactory.getLogger(TestClubEntity.class);
	
	public static void main(String[] args) {
		//SpringApplication.run(SpringPkAdemoApplication.class, args);
		SpringApplication.run(TestClubEntity.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ClubRepository clubRepository) {
		return (args) -> {
			clubRepository.save(new Club("Hochschulstraße", new Address("Hochschulstr.", 48, "01069", "Dresden")));
			clubRepository.save(new Club("Clubmensa", new Address("Mensastr.", 12, "01069", "Dresden")));
			clubRepository.save(new Club("ClubTU", new Address("TUStr.", 56, "01458", "Dresden")));
		
			// findAll()
			log.info("Club found with findAll()");
			log.info("-------------------------");
			for (Club club : clubRepository.findAll()) {
				log.info(club.toString());
			}
			log.info("");
			
			// findByName()
			log.info("Club found with findByNameContaining()");
			log.info("----------------------------");
			for (Club club : clubRepository.findByNameContaining("Club")) {
				log.info(club.toString());
			}
			log.info("");
			
		};
	}

}
*/
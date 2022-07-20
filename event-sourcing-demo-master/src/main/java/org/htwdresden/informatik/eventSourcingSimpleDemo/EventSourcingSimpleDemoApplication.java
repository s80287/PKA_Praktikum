package org.htwdresden.informatik.eventSourcingSimpleDemo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.htwdresden.informatik.eventSourcingExercise.event.JoinEvent;
import org.htwdresden.informatik.eventSourcingExercise.event.LeaveEvent;
import org.htwdresden.informatik.eventSourcingExercise.event.ReversalDomainEvent;
import org.htwdresden.informatik.eventSourcingExercise.model.Address;
import org.htwdresden.informatik.eventSourcingExercise.model.ChessClub;
import org.htwdresden.informatik.eventSourcingExercise.model.Gender;
import org.htwdresden.informatik.eventSourcingExercise.model.Member;
import org.htwdresden.informatik.eventSourcingExercise.model.Name;
import org.htwdresden.informatik.eventSourcingExercise.model.Person;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.ArrivalEvent;

import org.htwdresden.informatik.eventSourcingSimpleDemo.service.EventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EventSourcingSimpleDemoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EventSourcingSimpleDemoApplication.class);

	private List<Person> persons = new ArrayList<Person>();
	private List<ChessClub> clubs = new ArrayList<ChessClub>();
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EventSourcingSimpleDemoApplication.class, args);
		log.info("context name: "+context.getDisplayName());
		
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application Started!");
		// create some test data
		initTestData();
		
		EventProcessor eventProcessor = new EventProcessor();
		
		ChessClub c = clubs.get(0);
		
		Person maxMustermann2 = new Person(
				new Name("Max",' ', "Mustermann2"), 
				new Address("Musterstr.", 10, "01069", "Dresden"),
				Gender.MALE, LocalDate.of(2010, 11, 7));
		
		// implement JoinEvent.java 
		eventProcessor.process(new JoinEvent(LocalDate.of(2022, 2, 2), maxMustermann2, c));
		
		// persons from person list should join the chess club using join event
		for (Person p : persons) {
			eventProcessor.process(new JoinEvent(LocalDate.of(2010, 10, 10), p, c));
		}
		
		
		// implement LeaveEvent
		// one person should leave the chess club using leave event
		eventProcessor.process(new LeaveEvent(LocalDate.of(2022, 7, 1), maxMustermann2, c));
		
		// print out the number of active members using your implementation of activeMembers method
		System.out.println("Active members number(activeMembers()): " + c.activeMembers());
		
		// true 3
		//System.out.println("Active members number: " + c.getTotalMembersNumber());
		
	    Person lisaLustig = new Person(
				new Name("Lisa",' ', "Lustig"), 
				new Address("Einsteinstr.", 17, "01445", "Radebeul"),
				Gender.FEMALE, LocalDate.of(1998, 10, 2));
	    
	    // lisa lustig joined the club using JoinEvent 
	    eventProcessor.process(new JoinEvent(LocalDate.of(2020, 10, 10), lisaLustig, c));
	    // not in memberList??
	    System.out.println("Is lisaLustig member?: " + c.isMember(lisaLustig));
	    
	    // TODO lisa lustig leaved the club (but still in member list) using leave event
	    eventProcessor.process(new LeaveEvent(LocalDate.of(2021, 10, 10), lisaLustig, c));
	    System.out.println("Is lisaLustig member?: " + c.isMember(lisaLustig));
	    System.out.println("Active members number(activeMembers()): " + c.activeMembers());
	    
	    // TODO undo/reverse join of lisa lustig (delete from member list) 
	    
		
	}
	
	private void initTestData() {
		Person ferdinandFuchs = new Person(
				new Name("Ferdinand",' ', "Fuchs"), 
				new Address("Musterstr.", 12, "01445", "Radebeul"),
				Gender.MALE, LocalDate.of(2012, 3, 7));
		
		Person maxMustermann = new Person(
				new Name("Max",' ', "Mustermann"), 
				new Address("Musterstr.", 10, "01067", "Dresden"),
				Gender.MALE, LocalDate.of(2010, 11, 7));
		
		Person fridaMusterfrau = new Person(
				new Name("Frida",' ', "Musterfrau"), 
				new Address("Musterstr.", 10, "01067", "Dresden"),
				Gender.FEMALE, LocalDate.of(2011, 4, 28));
		
		
		persons.add(ferdinandFuchs);
		persons.add(maxMustermann);
		persons.add(fridaMusterfrau);
		
		for (Person person : persons) {
			log.info("create person: "+person);	
		}
		
		ChessClub gruenweiss = new ChessClub("F2808", "SG Grün-Weiß Dresden", new Address("Freiberger Straße", 31, "01067", "Dresden"));
		clubs.add(gruenweiss);
		
		for (ChessClub club : clubs) {
			log.info("create chess club: "+club);	
		}
		
		
	}
	
	

}

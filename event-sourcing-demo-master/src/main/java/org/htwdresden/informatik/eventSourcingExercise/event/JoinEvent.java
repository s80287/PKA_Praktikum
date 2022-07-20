package org.htwdresden.informatik.eventSourcingExercise.event;

import java.time.LocalDate;

import org.htwdresden.informatik.eventSourcingExercise.model.ChessClub;
import org.htwdresden.informatik.eventSourcingExercise.model.Member;
import org.htwdresden.informatik.eventSourcingExercise.model.Person;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//TODO implement JoinEvent (as DomainEvent)
public class JoinEvent extends DomainEvent {
	private static final Logger log = LoggerFactory.getLogger(JoinEvent.class);
	
	// attributes
	private Person person;
	private Member member;
	private ChessClub chessClub;
	
	private String currentState;
	private String priorState;
	
	
	public JoinEvent(LocalDate date, Person person, ChessClub club) {
	       super(date);
	       setPerson(person);
	       setChessClub(club);
	}

	
	@Override
	public void process() {
        log.info("process");
        member = new Member(person);
        member.handleJoin(this);
	}

	
	// setter getter
	public Person getPerson() {
		return person;
	}

	
	public void setPerson(Person person) {
		this.person = person;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public ChessClub getChessClub() {
		return chessClub;
	}


	public void setChessClub(ChessClub chessClub) {
		this.chessClub = chessClub;
	}


	public String getCurrentState() {
		return currentState;
	}


	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}


	public String getPriorState() {
		return priorState;
	}


	public void setPriorState(String priorState) {
		this.priorState = priorState;
	}
	
	

}

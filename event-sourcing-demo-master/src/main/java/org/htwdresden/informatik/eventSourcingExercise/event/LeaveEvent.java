package org.htwdresden.informatik.eventSourcingExercise.event;

import java.time.LocalDate;

import org.htwdresden.informatik.eventSourcingExercise.model.ChessClub;
import org.htwdresden.informatik.eventSourcingExercise.model.Member;
import org.htwdresden.informatik.eventSourcingExercise.model.Person;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO implement LeaveEvent (as DomainEvent)
public class LeaveEvent extends DomainEvent {
	private static final Logger log = LoggerFactory.getLogger(LeaveEvent.class);
	
	// attributes
	private Person person;
	private Member member;
	private ChessClub chessClub;
	
	public LeaveEvent(LocalDate date, Person person, ChessClub club) {
		//Member member = (Member) person;
		//member.setExitDate(LocalDate.now());
		
		super(date);
	    setPerson(person);
	    setChessClub(club);
	}

	@Override
	public void process() {
        log.info("process");
        member = new Member(person);
        member.handleLeave(this);
	}

	
	// getter setter
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
	

	

}

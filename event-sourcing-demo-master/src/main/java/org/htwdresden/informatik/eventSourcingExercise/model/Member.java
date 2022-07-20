package org.htwdresden.informatik.eventSourcingExercise.model;

import java.time.LocalDate;

import java.util.Date;
import java.util.Random;

import org.htwdresden.informatik.eventSourcingExercise.event.JoinEvent;
import org.htwdresden.informatik.eventSourcingExercise.event.LeaveEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Member extends Person {
    private int memberNumber; // Mitgliedsnummer
	//public static int totalMemberNumber = 0;
	private String clubZPS; // ZPS Verein
    private LocalDate entryDate; // Eintrittsdatum
    private LocalDate exitDate; // Austrittsdatum
    private MemberState state;
    private String dwz;
    private int elo;
    private FideTitle fideTitle;
    
    public Member() {super();}
    
    public Member(Name name, Address address, Gender gender, LocalDate birthDate, int memberNumber, String clubZPS) {
        super(name,address,gender,birthDate);
        this.memberNumber = memberNumber;
        this.clubZPS = clubZPS;
        this.entryDate = LocalDate.now();
    
        this.dwz = "";
        Random r = new Random();
        this.elo = r.nextInt(1400);
        
    }
    
    /*
    public Member(Person person, ChessClub chessClub) {
    	super(person);
    
    	this.memberNumber = totalMemberNumber + 1;
    	this.clubZPS = chessClub.getZps();
        this.entryDate = LocalDate.now();
        
        this.dwz = "";
        Random r = new Random();
        this.elo = r.nextInt(1400);
    }
   	*/
    
    public Member(Person p) {
    	super(p);
    }
    
    public String getMemberZPS() {
        return Integer.toString(memberNumber)+"-"+clubZPS;
    }

    public int getMemberNumber() {
        return memberNumber;
    }
    

    public String getClubZPS() {
        return clubZPS;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public MemberState getState() {
        return state;
    }

    public String getDwz() {
        return dwz;
    }

    public void setDwz(String dwz) {
        this.dwz = dwz;
    }
    
    public void setExitDate(LocalDate exitDate) {
    	this.exitDate = exitDate;
    }
    
    
    public int getElo() {
        return elo;
    }

    public FideTitle getFideTitle() {
        return fideTitle;
    }
    
    // handleJoin
    public void handleJoin(JoinEvent joinEvent) {
    	log.info("handleJoin");
    	
    	//###joinEvent
    	// add to memberList
    	joinEvent.getChessClub().handleJoin(joinEvent);
    	
    	
    	this.clubZPS = joinEvent.getChessClub().getZps();
    	
    	// attributes from person
    	// unnecessary
    	// generate memberNumber
    	this.memberNumber = joinEvent.getChessClub().getTotalMembersNumber() + 1;
    	joinEvent.getChessClub().incrementTotalMembersNumber();
    }
    
    // handleLeave
    public void handleLeave(LeaveEvent leaveEvent) {
    	log.info("handleLeave");
    	this.exitDate = LocalDate.now();
    	
    	//###leaveEvent
    	//leaveEvent.getChessClub().handleLeave(leaveEvent);
    	
    	
    	leaveEvent.getChessClub().decrementTotalMembersNumber();
    }
    
    // reverseJoin
    public void handleReverseJoin() {
    	
    }
    

	@Override
      public String toString() {
        String s = super.toString(); 
        
        // Mitgliedsnummer mit führenden Nullen auffüllen
        String formatted = String.format("%04d", this.memberNumber);
        
        return s+'\n' + "Mitgliedsnummer: "+formatted+'\n'+"Verein: "+this.getClubZPS();
        
      }
}
    


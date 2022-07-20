package org.htwdresden.informatik.eventSourcingExercise.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.htwdresden.informatik.eventSourcingExercise.event.JoinEvent;
import org.htwdresden.informatik.eventSourcingExercise.event.LeaveEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Cargo;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessClub extends Club {
	private static final Logger log = LoggerFactory.getLogger(ChessClub.class); 
	
	private String zps;
    private List<Member> memberList = new ArrayList<Member>();
    
    private int totalMembersNumber = 0;
    
	private String currentState;
	
	
	public ChessClub(String zps, String name, Address address) {
		super(name, address);
		this.zps = zps;
	}
	
	public String getZps() {
		return zps;
	}
	
	
	

	public int getTotalMembersNumber() {
		return totalMembersNumber;
	}

	public void setTotalMembersNumber(int totalMembersNumber) {
		this.totalMembersNumber = totalMembersNumber;
	}
	
	public void incrementTotalMembersNumber() {
		this.totalMembersNumber++;
	}
	
	public void decrementTotalMembersNumber() {
		this.totalMembersNumber--;
	}
	
	

	public boolean isMember(Person p) {
		if(memberIndex(p) != -1 ) {
			log.info("found member "+p.getName().getFullName());
			return true;
		}
		return false;
	}
	
	// return -1 if member is not found
	// otherwise position in list 
	private int memberIndex(Person p) {
		for (Member member : memberList) {
			if(p.equals(member)) {
				return memberList.indexOf(member);	
			}
		}
		return -1;
	}
	
	public List<Member> getMembers() {
		return memberList;
	}
	
	
	// TODO implement active members. method should return the number of active members
	// i.e. where exitDate is null
	public long activeMembers() {
		//return 0;
		int activeMembersNumber = 0;
		
		
		for (Member m : memberList) {
			/*
			if (m.getExitDate() != null) {
				activeMembersNumber++;
			}
			*/
			
			if (m.getExitDate() == null) {
				activeMembersNumber++;
			}
			
		}
		
		return activeMembersNumber;
	}
	
	public void handleJoin(JoinEvent joinEvent) {
		// correct???
		log.info("###handleJoin");
		
		this.currentState = joinEvent.getCurrentState();
		memberList.add(joinEvent.getMember());		
		// memberList.forEach(member -> member.handleJoin(joinEvent));
    }
	
	
	public void handleReverseJoin(JoinEvent joinEvent) {
		// TODO handleReverseJoin
		
		// correct??
		
		log.info("###handleReverseJoin");
		memberList.remove(joinEvent.getMember());
		
		//this.currentState = joinEvent.getPriorState();
	
	
	}
	
	private Member getMember(Person p) {
		int memberIndex = memberIndex(p);
		if(memberIndex != -1) {
			Member m = memberList.get(memberIndex);
			return m;
		}
		return null;
	}
		
		
	public void handleLeave(LeaveEvent leaveEvent) {
		// log.info("handleUnload");
	    // simple removement of cargo --> remove all, without regards to amount
	    //cargoList.removeIf(cargo -> cargo.getType().equals(unloadEvent.getCargo().getType()));
	    
		log.info("###handleLeave");
		// removement
		// remove category???
		// remove all
		
		memberList.remove(leaveEvent.getMember());
		//memberList.removeIf(member -> member.getState().equals(leaveEvent.getMember().getState()));
	}
	

}

package pka.excercise.solution;

import java.util.Comparator;

import pka.excercise.*;

public class MemberEloComparator implements Comparator<Member>{
	public int compare(Member m1, Member m2) {
		
		if (m1.getMemberElo() == m2.getMemberElo()) {
			return 0;
		}
		else if (m1.getMemberElo() > m2.getMemberElo()) {
			return 1;
		}
		else {
			return -1;
		}
		
		
		// primitive int != reference type Integer
		//return m1.getMemberElo().compareTo(m2.getMemberElo());
	}
	
}

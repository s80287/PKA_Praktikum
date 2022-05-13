package pka.excercise.solution;

import pka.excercise.*;
import java.util.*;

public class MemberNameComparator implements Comparator<Member>{
	public int compare(Member m1, Member m2) {
		if ((m1.getName().getLastname()).compareTo(m2.getName().getLastname()) == 0) {
			return (m1.getName().getFirstName()).compareTo(m2.getName().getFirstName());
		}
		else {
			return (m1.getName().getLastname()).compareTo(m2.getName().getLastname());
		}
	}
	
}

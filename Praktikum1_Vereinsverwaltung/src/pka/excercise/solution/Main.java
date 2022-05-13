package pka.excercise.solution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import pka.excercise.Address;
import pka.excercise.Name;
import pka.excercise.Person;
import pka.excercise.solution.*;

public class Main {

	public static void main(String[] args) {
		/*
		// Praktikum 1: Vererbung
		Member m1 = new Member();
		
		// attributes class person
		m1.setName(new Name("Tony", ' ', "Bui"));
		m1.setBirthday(LocalDate.of(2000, 1, 1));
		m1.setGender(Gender.MAN);
		m1.setAddress(new Address("Hochschulstraße", 1, "01069", "Dresden"));
		m1.setEmail("tony.bui@htw-dresden.de");
		m1.setTel("0123456789");
		
		// attributes class member
		m1.setMemberNr("260");
		m1.setMemberZPSClubCode("F2208");
		m1.setMemberDateJoin(LocalDate.now());
		m1.setMemberDWZ("1326-19");
		m1.setMemberElo(1306);
		
		System.out.println(m1.toString());
		*/
		
		// Praktikum 4: Comparable

		// Aufgabe 1a
		/*
		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.setBirthday(LocalDate.of(2000, 1, 1));
		p2.setBirthday(LocalDate.of(2005, 3, 7));
		
		int result = p1.compareTo(p2);
		
		if (result > 0) {
			System.out.println("p1 younger");
		}
		else if (result < 0) {
			System.out.println("p2 younger");
		}
		else {
			System.out.println("same");
		}
		*/
		
		
		// Aufgabe 1b
		/*
		Person[] personArray = new Person[3];
		personArray[0] = new Person(LocalDate.of(2001, 1, 1));
		personArray[1] = new Person(LocalDate.of(2002, 2, 2));
		personArray[2] = new Person(LocalDate.of(2003, 3, 3));
		
		// nur eine Vergleichsmöglichkeit möglich
		Arrays.sort(personArray);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for (Person p : personArray) {
			System.out.println((p.getBirthday()).format(formatter));
		}
		*/
		
		// Aufgabe 2c
		Member[] memberArray = new Member[3];
		memberArray[0] = new Member(new Name("Max", 'a', "Mustermann"), 600);
		memberArray[1] = new Member(new Name("Anton", 'a', "Mustermann"), 200);
		memberArray[2] = new Member(new Name("Mai", 'a', "Pham"), 800);
		
		// sort
		Arrays.sort(memberArray, new MemberEloComparator());
		Arrays.sort(memberArray, new MemberNameComparator());
		
		// print
		for (Member m : memberArray) {
			System.out.println(m.getName().getFirstName() + " " +
					m.getName().getLastname() + " " + m.getMemberElo());
		}
		
		// end of main()
	}
		
}

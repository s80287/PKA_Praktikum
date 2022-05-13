package pka.excercise.solution;

import pka.excercise.Name;
import pka.excercise.Person;
import pka.excercise.Address;
import java.time.LocalDate;

public class Member extends Person {
	// member attributes 
	private String memberNr;
	private String ZPSClubCode;
	// ZPSPlayerNr = "P" + ZPSClubCode + "-" + memberNr
	private String ZPSPlayerNr;
	private LocalDate dateJoin;
	private LocalDate dateLeave;
	private Status status;
	// deutsche Wertungszahl
	private String DWZ;
	private int elo;
	private FIDETitle title;
	
	// constructor
	// constructor with only elo and name
	Member(Name name, int elo) {
		super(name);
		this.elo = elo;
	}
	
	// methode
	// getter
	public String getMemberZPSPlayerNr()
	{
		return ZPSClubCode + "-" + memberNr;
	}
	
	public String getMemberNr()
	{
		return this.memberNr;
	}
	
	public String getMemberZPSClubCode()
	{
		return this.ZPSClubCode;
	}
	
	public LocalDate getMemberDateJoin()
	{
		return this.dateJoin;
	}
	
	public LocalDate getMemberDateLeave()
	{
		return this.dateLeave;
	}
	
	public String getMemberDWZ()
	{
		return this.DWZ;
	}
	
	public int getMemberElo()
	{
		return this.elo;
	}
	
	// setter
	public void setMemberNr(String nr)
	{
		this.memberNr = nr;
	}
	
	public void setMemberZPSClubCode(String clubCode)
	{
		this.ZPSClubCode = clubCode;
	}
	
	public void setMemberDateJoin(LocalDate date)
	{
		this.dateJoin = date;
	}
	
	public void setMemberDateLeave(LocalDate date)
	{
		this.dateLeave = date;
	}
	
	public void setMemberDWZ(String DWZ)
	{
		this.DWZ = DWZ;
	}
	
	public void setMemberElo(int elo)
	{
		this.elo = elo;
	}
	
	/** Override the toString method */
	@Override
	public String toString() {
		//return '\n' + name.getFullName() + '\n' +
		//	address.getFullAddress() + '\n';
		return super.toString() + getMemberZPSPlayerNr() + '\n'
			+ getMemberDateJoin() + '\n'
			+ getMemberDateLeave() + '\n'
			+ getMemberDWZ() + '\n'
			+ getMemberElo() + '\n';
	}

}

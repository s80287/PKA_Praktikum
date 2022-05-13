package pka.excercise.solution;

import pka.excercise.*;

public class ChessClub extends Club {

	// attributes
	private String ZPSCode;

	// constructor
	public ChessClub(Name name, Address address,
			Person chairperson, String ZPSCode) {
		super(name, address, chairperson);
		this.ZPSCode = ZPSCode;
	}
	
	// method
	// getter setter
	public void setChessClubZPSCode(String ZPSCode)
	{
		this.ZPSCode = ZPSCode;
	}
	
	public String getChessClubZPSCode()
	{
		return this.ZPSCode;
	}

}

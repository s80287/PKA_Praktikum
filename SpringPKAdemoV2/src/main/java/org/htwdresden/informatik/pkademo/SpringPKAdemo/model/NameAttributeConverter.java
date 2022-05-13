package org.htwdresden.informatik.pkademo.SpringPKAdemo.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class NameAttributeConverter implements AttributeConverter<Name, String>{

	@Override
	public String convertToDatabaseColumn(Name nameAttribute) {
		
		String fname = nameAttribute.getFirstName() == null ? "anonymous" : nameAttribute.getFirstName();
		String lname = nameAttribute.getLastname() == null ? "" : nameAttribute.getLastname();
		
		return fname + " " + lname;
	}
	
	@Override
	public Name convertToEntityAttribute(String sqlName) {
		
		if (sqlName != null && sqlName.split(" ").length > 0) {
			String fname = sqlName.split(" ")[0];
			String lname = sqlName.split(" ")[1];
			
			return new Name(fname, ' ', lname);
		}
		
		return null;
	}

}

package edu.m2i.tests;

import edu.m2i.entites.Date;
import edu.m2i.validators.ValidateDate;

public class TestMain {

	public static void main(String[] args) {
		Date date = new Date(12, 3, 2003);
		ValidateDate validateDate = new ValidateDate();
		if (validateDate.verifierDate(date)) {
			System.out.println("Date " + date.toString() + " est valide");
		} else {
			System.out.println("Date " + date.toString() + " n'est pas valide");
		}
	}

}

package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	public static java.util.Date date(int year,int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}

	@BeforeClass
	public static void setup() {

	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {


		Staff a,b,c,d,e,f,g;
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		try {
			a = new Staff("Tyler","Nathan","Tank", date(1996,8,22), "136 Chestnut Street", "(302)-111-2233", "123@gmail.com", "monday 2-3", 2, 60000.00, date(1996,8,22), eTitle.MR);
			b = new Staff("Mike","Anthony","Croce", date(1990,8,22), "22 Sicamore Street", "(302)-121-2233", "1234@gmail.com", "tuesday 2-3", 2, 70000.00, date(1996,8,22), eTitle.MR);
			c = new Staff("Noah","Junior","Jones",date(1996,8,22), "136 Chestnut Street", "(302)-131-2233", "12345@gmail.com", "wednsday 2-3", 2, 75000.00, date(1996,8,22), eTitle.MR);
			d = new Staff("Aaron","Jeff","Rodgers", date(1996,8,22), "136 Chestnut Street", "(302)-141-2233", "123456@gmail.com", "thursday 2-3", 2, 65000.00, date(1996,8,22), eTitle.MR);
			e = new Staff("Jack","Henry","Honor", date(1996,8,22), "136 Chestnut Street", "(302)-111-2233", "123@gmail.com", "monday 2-3", 2, 60000.00, date(1996,8,22), eTitle.MR);
			
			staffList.add(a);
			staffList.add(b);
			staffList.add(c);
			staffList.add(d);
			staffList.add(e);
			
		} catch (PersonException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		

		double total = 0;
		double count = 0;
		double average = 0;
		for (Staff staff : staffList) {
			total += staff.getSalary();
			count++;
		}
		average = total/count;
		 System.out.println("Average salary is:" + average);
		//		assertTrue("asserting average salary == 66000", average == 66000.00);
		assertEquals(average, 66000.0, 0.0);


		try {
			f = new Staff("Jack","Henry","Honor", date(1896,8,22), "136 Chestnut Street", "(302)-111-2233", "123@gmail.com", "monday 2-3", 2, 60000.00, date(1996,8,22), eTitle.MR);
		} catch (PersonException e1) {

			System.out.println("PersonException Caught: too old");
		}
		
		try {
			g = new Staff("Tyler","Nathan","Tank", date(1996,8,22), "136 Chestnut Street", "(302)-11-2233", "123@gmail.com", "monday 2-3", 2, 60000.00, date(1996,8,22), eTitle.MR);
		} catch (PersonException e1) {

			System.out.println("PersonException Caught: Invalid Phone Number");
		}

	}	

}
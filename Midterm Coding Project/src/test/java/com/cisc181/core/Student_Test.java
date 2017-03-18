package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import java.util.Date;
import java.util.List;
public class Student_Test {
	static ArrayList<Student> StudentList = new ArrayList<Student>();
	static ArrayList<Course> CourseList = new ArrayList<Course>();
	static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	static ArrayList<Section> SectionList = new ArrayList<Section>();
	static Course c1, c2, c3;
	static Semester fall, spring;
	static Section s1,s2,s3,s4,s5,s6;
	static Student st1,st2,st3,st4,st5,st6,st7,st8,st9,st10;
	
	@BeforeClass
	public static void setup() {

		
		c1 = new Course("Math",3,eMajor.CHEM);
		CourseList.add(c1);
		c2 = new Course("Science",3,eMajor.NURSING);
		CourseList.add(c2);
		c3 = new Course("ECON",3,eMajor.BUSINESS);
		CourseList.add(c3);

		
		fall = new Semester(date(2015,8,22),date(2015,12,7));
		spring = new Semester(date(2016,1,20), date(2016,5,27));
		SemesterList.add(fall);
		SemesterList.add(spring);

		
		s1 = new Section(c1.getCourseID(),fall.getSemesterID());
		s2 = new Section(c2.getCourseID(),fall.getSemesterID());
		s3 = new Section(c3.getCourseID(),fall.getSemesterID());
		s4 = new Section(c1.getCourseID(),spring.getSemesterID());
		s5 = new Section(c2.getCourseID(),spring.getSemesterID());
		s6 = new Section(c3.getCourseID(),spring.getSemesterID());

		SectionList.add(s1);
		SectionList.add(s2);
		SectionList.add(s3);
		SectionList.add(s4);
		SectionList.add(s5);
		SectionList.add(s6);

		

		try {
			st1 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st2 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st3 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st4 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st5 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st6 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st7 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st8 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st9 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");
			st10 = new Student("John","Jake","Smith", date(1996,5,22), eMajor.COMPSI,"123 Smith st","(302)-111-2222", "123@gmail.com");

			StudentList.add(st1);
			StudentList.add(st2);
			StudentList.add(st3);
			StudentList.add(st4);
			StudentList.add(st5);
			StudentList.add(st6);
			StudentList.add(st7);
			StudentList.add(st8);
			StudentList.add(st9);
			StudentList.add(st10);

		} catch (PersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static java.util.Date date(int year,int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}

	@Test
	public void test() {
		ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
		List<Enrollment> Student1EnrollmentList;
		List<Enrollment> Student10EnrollmentList;
		Enrollment e;
		double grade;
		grade = 0.0;
		for (Student student : StudentList) {
			grade += 0.4;
			for (Section section : SectionList) {
				e = new Enrollment(student.getStudentID(),section.getSectionID());
				e.setGrade(grade);
				EnrollmentList.add(e);
			}
		}
		System.out.println("number of enrolled students:" + EnrollmentList.size());
		Student1EnrollmentList = EnrollmentList.subList(0, 5);
		Student10EnrollmentList = EnrollmentList.subList(54, 59);
		double total = 0;
		double count = 0;
		double average = 0;
		for (Enrollment enrollment : Student1EnrollmentList) {
			total += enrollment.getGrade();
			count++;
		}
		average = total/count;
		System.out.println("GPA is:" + average);			
		assertEquals(average, 0.4, 0.0);
		total = 0;
		count = 0;
		average = 0;
		for (Enrollment enrollment : Student10EnrollmentList) {
			total += enrollment.getGrade();
			count++;
		}
		average = total/count;
		System.out.println("GPA is:" + average);
		assertEquals(average, 4.0, 0.1);

		double c1total = 0;
		double c1count = 0;
		double c1average = 0;
		double c2total = 0;
		double c2count = 0;
		double c2average = 0;
		double c3total = 0;
		double c3count = 0;
		double c3average = 0;
		for (Enrollment enrollment : EnrollmentList) {
			UUID sid = enrollment.getSectionID(); 
			if(sid == s1.getSectionID() || sid == s4.getSectionID()){
				c1total += enrollment.getGrade();
				c1count++;
			}
			if(sid == s2.getSectionID() || sid == s5.getSectionID()){
				c2total += enrollment.getGrade();
				c2count++;
			}if(sid == s3.getSectionID() || sid == s6.getSectionID()){
				c3total += enrollment.getGrade();
				c3count++;
			}
		}
		c1average = c1total/c1count;
		c2average = c2total/c2count;
		c3average = c3total/c3count;
		
		System.out.println("Course 1 average:" + c1average);
		assertEquals(c1average, 2.2, 0.1);
		assertEquals(c2average, 2.2, 0.1);
		assertEquals(c3average, 2.2, 0.1);
		
		//change student major
		StudentList.get(0).setMajor(eMajor.NURSING);

	}
}
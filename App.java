package com.sathya.Hibernate6;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sathya.jpa.Course;
import com.sathya.jpa.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
       SessionFactory factory=con.buildSessionFactory();
       Session session=factory.openSession();
       Transaction tx=session.beginTransaction();
       Set<Student>javastudent=new HashSet<Student>();
       Set<Student>pythonstudent=new HashSet<Student>();
       Set<Student>cstudent=new HashSet<Student>();
       Set<Course> sathyacourse = new HashSet<Course>();
		Set<Course> divyacourse = new HashSet<Course>();
       Student student=new Student();
       student.setName("sathya");
       student.setAge(21);
       javastudent.add(student);
       cstudent.add(student);
       Student student1=new Student();
       student1.setName("divya");
       student1.setAge(22);
       javastudent.add(student1);
       cstudent.add(student1);
       Course course=new Course();
       course.setCname("Java");
       course.setCamt(12000);
       Course course1=new Course();
       course1.setCname("python");
       course1.setCamt(13000);
       Course course2=new Course();
       course2.setCname("C");
       course2.setCamt(13000);
       sathyacourse.add(course);
		sathyacourse.add(course1);
		divyacourse.add(course1);
		divyacourse.add(course2);
		student.setCourse(sathyacourse);
		student1.setCourse(divyacourse);
       course.setStudent(javastudent);
       course1.setStudent(pythonstudent);
       course2.setStudent(cstudent);
       session.save(student);
       session.save(student1);
	   tx.commit();
	   session.close();
	   factory.close();
   }
       
}

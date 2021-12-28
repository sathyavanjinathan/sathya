package com.sathya.jpa;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cid;
	String cname;
	int camt;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course", joinColumns=@JoinColumn(name="course_id"),inverseJoinColumns=@JoinColumn(name="student_id"))
	private Set<Student> student;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCamt() {
		return camt;
	}
	public void setCamt(int camt) {
		this.camt = camt;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	

}

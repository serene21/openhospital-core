package org.isf.lab.model;

/*------------------------------------------
 * Laboratory - laboratory exam execution model
 * -----------------------------------------
 * modification history
 * 02/03/2006 - theo - first beta version
 * 10/11/2006 - ross - new fields data esame, sex, age, material, inout flag added
 * 06/01/2016 - Antonio - ported to JPA
 * 
 *------------------------------------------*/

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.isf.exa.model.Exam;
import org.isf.patient.model.Patient;

@Entity
@Table(name="LABORATORY")
public class Laboratory 
{
	@Id 
	@Column(name="LAB_ID")
	private int code;
	
	@Column(name="LAB_MATERIAL")
	private String material;

	@ManyToOne
	@JoinColumn(name="LAB_EXA_ID_A")
	private Exam exam;
	
	@Column(name="LAB_DATE")
	private GregorianCalendar registrationDate;
	
	@Column(name="LAB_EXAM_DATE")
	private GregorianCalendar examDate;
	
	@Column(name="LAB_RES")
	private String result;
	
	@Column(name="LAB_LOCK")
	private int lock;
	
	@Column(name="LAB_NOTE")
	private String note;

	@ManyToOne
	@JoinColumn(name="LAB_PAT_ID")
	private Patient patient;
	
	@Column(name="LAB_PAT_NAME")
	private String patName;
	
	@Column(name="LAB_PAT_INOUT")
	private String InOutPatient;
	
	@Column(name="LAB_AGE")
	private int age;
	
	@Column(name="LAB_SEX")
	private String sex;
	
	@Transient
	private volatile int hashCode = 0;
	
	public Laboratory() { }
	
	public Laboratory(int aCode,Exam aExam,GregorianCalendar aDate,String aResult,
			int aLock, String aNote, Patient aPatId, String aPatName){
		code=aCode;
		exam=aExam;
		registrationDate=aDate;
		result=aResult;
		lock=aLock;
		note=aNote;
		patient=aPatId;
		patName=aPatName;
	}
	public Exam getExam(){
		return exam;
	}
	public GregorianCalendar getDate(){
		return registrationDate;
	}
	public String getResult(){
		return result;
	}
	public int getCode(){
		return code;
	}
	public int getLock(){
		return lock;
	}
	public void setCode(int aCode){
		code=aCode;
	}
	public void setExam(Exam aExam){
		exam=aExam;
	}
	public void setLock(int aLock){
		lock=aLock;
	}
	public GregorianCalendar getExamDate() {
		return examDate;
	}
	public void setExamDate(GregorianCalendar exDate) {
		this.examDate = exDate;
	}	
	public void setDate(GregorianCalendar aDate){
		registrationDate=aDate;
	}
	public void setResult(String aResult){
		result=aResult;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Patient getPatId() {
		return patient;
	}
	public void setPatId(Patient patient) {
		this.patient = patient;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getInOutPatient() {
		return InOutPatient;
	}
	public void setInOutPatient(String InOut) {
		if (InOut==null) InOut="";
		this.InOutPatient = InOut;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Laboratory)) {
			return false;
		}
		
		Laboratory laboratory = (Laboratory)obj;
		return (this.getCode() == laboratory.getCode());
	}
	
	@Override
	public int hashCode() {
	    if (this.hashCode == 0) {
	        final int m = 23;
	        int c = 133;
	        
	        c = m * c + code;
	        
	        this.hashCode = c;
	    }
	  
	    return this.hashCode;
	}
}


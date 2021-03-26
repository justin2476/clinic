package com.clinic.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Appointment")
public class Appointment {
	@Id
	private ObjectId id;
	private String treatmentName;
	private String room;
	private String doctor;
	private int doctorId;
	private Date startDate;
	private Date endDate;
	private boolean isAttented = false;
	private boolean isBooked = false;
	private boolean isConsultation = false;
	private long patientId;
	private String vistorName;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(String doctor, String startDate, String endDate) {
		super();
		this.doctor = doctor;
		this.startDate = dateGenerator(startDate);
		this.endDate = dateGenerator(endDate);
	}
	public Appointment(String doctor, String startDate, String endDate, long pId) {
		super();
		this.doctor = doctor;
		this.startDate = dateGenerator(startDate);
		this.endDate = dateGenerator(endDate);
		this.patientId=pId;
	}

	public static Date dateGenerator(String time) {
		String target = time;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date result = null;
		try {
			result = format.parse(target);
		} catch (ParseException ex) {
			Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isAttented() {
		return isAttented;
	}

	public void setAttented(boolean isAttented) {
		this.isAttented = isAttented;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public boolean isConsultation() {
		return isConsultation;
	}

	public void setConsultation(boolean isConsultation) {
		this.isConsultation = isConsultation;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getVistorName() {
		return vistorName;
	}

	public void setVistorName(String vistorName) {
		this.vistorName = vistorName;
	}
	

}

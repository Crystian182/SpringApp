package it.unisalento.se.saw.dto;

import java.util.Date;

import it.unisalento.se.saw.domain.Classroom;
import it.unisalento.se.saw.domain.Status;

public class TicketDTO {
	
	private int id;
	private String title;
	private StatusDTO statusDTO;
	private TeacherDTO teacherDTO;
	private ClassroomDTO classroomDTO;
	private String text;
	private Date date;
    private String note;
    
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	public TeacherDTO getTeacherDTO() {
		return teacherDTO;
	}
	public void setTeacherDTO(TeacherDTO teacherDTO) {
		this.teacherDTO = teacherDTO;
	}
	public ClassroomDTO getClassroomDTO() {
		return classroomDTO;
	}
	public void setClassroomDTO(ClassroomDTO classroomDTO) {
		this.classroomDTO = classroomDTO;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

}

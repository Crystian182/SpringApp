package it.unisalento.se.saw.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.ITicketService;
import it.unisalento.se.saw.domain.Building;
import it.unisalento.se.saw.domain.Classroom;
import it.unisalento.se.saw.domain.Ticket;
import it.unisalento.se.saw.domain.User;
import it.unisalento.se.saw.dto.ClassroomDTO;
import it.unisalento.se.saw.dto.StatusDTO;
import it.unisalento.se.saw.dto.TeacherDTO;
import it.unisalento.se.saw.dto.TicketDTO;
import it.unisalento.se.saw.exceptions.TicketNotFoundException;



@RestController
@RequestMapping("/ticket")
public class TicketRestController {
	
	@Autowired
	ITicketService ticketService;
	
	public TicketRestController() {
		super();
	}
	
	public TicketRestController(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	
	@GetMapping(value="/getAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TicketDTO> getAll(){
		List<Ticket> tickets = ticketService.getAll();
		List<TicketDTO> newTicketDTOs = new ArrayList<TicketDTO>();
		for(int i=0; i<tickets.size(); i++) {
			Ticket ticket = tickets.get(i);
			newTicketDTOs.add(this.EntityToDTO(ticket));
		}
		return newTicketDTOs;
	}
	
	
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public TicketDTO getById(@PathVariable("id")int id) throws TicketNotFoundException{
		Ticket ticket = ticketService.getById(id);
		return this.EntityToDTO(ticket);
	}
	
	@PostMapping(value="/edit", produces=MediaType.APPLICATION_JSON_VALUE)
	public TicketDTO edit(@RequestBody TicketDTO ticketDTO) throws TicketNotFoundException{
		Ticket ticket = ticketService.edit(this.DTOToEntity(ticketDTO));
		return this.EntityToDTO(ticket);
	}
	
	@PostMapping(value="/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public TicketDTO save(@RequestBody TicketDTO ticketDTO){
		Ticket ticket = ticketService.save(this.DTOToEntity(ticketDTO));
		return this.EntityToDTO(ticket);
	}
	
	@PostMapping(value="/delete/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id")int id) throws TicketNotFoundException{
		ticketService.delete(id);
	}	
	
	
	public TicketDTO EntityToDTO(Ticket ticket) {
		
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId(ticket.getUserByUserIduser().getIduser());
		teacherDTO.setName(ticket.getUserByUserIduser().getName());
		teacherDTO.setSurname(ticket.getUserByUserIduser().getSurname());
		
		ClassroomDTO classroomDTO = new ClassroomDTO();
		classroomDTO.setId(ticket.getClassroom().getIdclassroom());
		classroomDTO.setName(ticket.getClassroom().getName());
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setIdstatus(ticket.getStatus().getIdstatus());
		statusDTO.setDescription(ticket.getStatus().getDescription());
		
		TicketDTO ticketDTO = new TicketDTO();
		
		ticketDTO.setId(ticket.getIdticket());
		ticketDTO.setTitle(ticket.getTitle());
		ticketDTO.setStatusDTO(statusDTO);
		ticketDTO.setTeacherDTO(teacherDTO);
		ticketDTO.setClassroomDTO(classroomDTO);

		return ticketDTO;
	}
	
	public Ticket DTOToEntity(TicketDTO ticketDTO) {

		User teacher = new User();
		teacher.setIduser(ticketDTO.getTeacherDTO().getId());
		teacher.setSurname(ticketDTO.getTeacherDTO().getSurname());
		teacher.setName(ticketDTO.getTeacherDTO().getName());
		
		Building building = new Building();
		building.setIdbuilding(ticketDTO.getClassroomDTO().getBuilding().getId());
		building.setName(ticketDTO.getClassroomDTO().getBuilding().getName());
		building.setAddress(ticketDTO.getClassroomDTO().getBuilding().getAddress());
		
		Classroom classroom = new Classroom();
		classroom.setIdclassroom(ticketDTO.getClassroomDTO().getId());
		classroom.setName(ticketDTO.getClassroomDTO().getName());
		classroom.setBuilding(building);
		
		Ticket ticket = new Ticket();
		try {
			ticket.setIdticket(ticketDTO.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		ticket.setTitle(ticketDTO.getTitle());
		ticket.setDate(ticketDTO.getDate());
		ticket.setUserByUserIduser(teacher);
		ticket.setText(ticketDTO.getText());
		ticket.setClassroom(classroom);
		
		return ticket;
	}
	
	
}

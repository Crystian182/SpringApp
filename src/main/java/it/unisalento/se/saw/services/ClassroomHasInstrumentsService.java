package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.Iservices.IClassroomHasInstrumentsService;
import it.unisalento.se.saw.domain.ClassroomHasInstruments;
import it.unisalento.se.saw.repositories.ClassroomHasInstrumentsRepository;

@Service
public class ClassroomHasInstrumentsService implements IClassroomHasInstrumentsService{
	
	@Autowired
	ClassroomHasInstrumentsRepository classroomHasInstrumentsRepository;
	
	@Transactional
	public List<ClassroomHasInstruments> getInstrumentsFromClassroom(int idClassroom){
		return classroomHasInstrumentsRepository.findInstrumentsByClassroom(idClassroom);
	}

}

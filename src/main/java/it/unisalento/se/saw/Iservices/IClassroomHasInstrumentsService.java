package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.ClassroomHasInstruments;

public interface IClassroomHasInstrumentsService {
	
	public List<ClassroomHasInstruments> getInstrumentsFromClassroom(int idClassroom);

}

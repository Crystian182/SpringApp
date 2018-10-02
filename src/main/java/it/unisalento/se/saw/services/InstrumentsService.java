package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.Iservices.IInstrumentsService;
import it.unisalento.se.saw.domain.Classroom;
import it.unisalento.se.saw.domain.Instruments;
import it.unisalento.se.saw.exceptions.ClassroomNotFoundException;
import it.unisalento.se.saw.exceptions.InstrumentNotFoundException;
import it.unisalento.se.saw.repositories.InstrumentsRepository;

@Service
public class InstrumentsService implements IInstrumentsService{

	@Autowired
	InstrumentsRepository instrumentsRepository;
	
	@Transactional(readOnly=true)
	public List<Instruments> getAll(){
		return instrumentsRepository.findAll();
	}
	
/*	@Transactional
	public List<Instruments> insert(Instruments instruments) {
		return instrumentsRepository.insert(instruments);
	}
	*/
	
	@Transactional
	public Instruments save(Instruments instruments) {
		return instrumentsRepository.save(instruments);
	}

	@Transactional
	public void delete(int id) throws InstrumentNotFoundException {
		// TODO Auto-generated method stub
		try {
			Instruments instruments = instrumentsRepository.findById(id).get();
			instrumentsRepository.delete(instruments);
		} catch (Exception e) {
			// TODO: handle exception
			throw new InstrumentNotFoundException();
		}
		
	}
	
}

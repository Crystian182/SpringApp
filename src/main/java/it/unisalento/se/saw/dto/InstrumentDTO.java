package it.unisalento.se.saw.dto;

import java.util.HashSet;
import java.util.Set;

import it.unisalento.se.saw.domain.ClassroomHasInstruments;

public class InstrumentDTO {
	
	private Integer idinstruments;
    private String name;
    private int quantity;
	
    
    public Integer getIdinstruments() {
		return idinstruments;
	}
	public void setIdinstruments(Integer idinstruments) {
		this.idinstruments = idinstruments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


    
    

}

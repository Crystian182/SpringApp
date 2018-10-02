package it.unisalento.se.saw.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.models.Response;

@ControllerAdvice  
@RestController
public class TicketNotFoundException extends Exception {

	 @ExceptionHandler(value = TicketNotFoundException.class)  
	  public ResponseEntity<Response> handleException(Exception e) {
	        return new ResponseEntity<Response>(new Response("Ticket non esistente"), HttpStatus.BAD_REQUEST);
	    }

}

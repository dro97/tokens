package carpool.jwt.msecurityjwt.controller.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;

import carpool.jwt.msecurityjwt.model.AuthenticationResponse;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler (value = {JsonParseException.class})
	public ResponseEntity<AuthenticationResponse> errorToken(JsonParseException ex){
		AuthenticationResponse respuesta = new AuthenticationResponse();
		
		respuesta.setCodeError("COD5895");
		respuesta.setMsgError("Error en el token");
		
		return ResponseEntity.ok(respuesta);
	}

}


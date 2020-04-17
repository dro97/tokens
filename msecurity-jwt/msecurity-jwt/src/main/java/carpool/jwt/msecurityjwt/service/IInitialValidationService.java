package carpool.jwt.msecurityjwt.service;

import javax.servlet.http.HttpServletRequest;

import carpool.jwt.msecurityjwt.model.AuthenticationRequest;
import carpool.jwt.msecurityjwt.model.AuthenticationResponse;

public interface IInitialValidationService {
	
	AuthenticationResponse validacionInicial(AuthenticationRequest data ,HttpServletRequest request);
	
	
	

}

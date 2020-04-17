/**
 * 
 */
package carpool.jwt.msecurityjwt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carpool.jwt.msecurityjwt.model.AuthenticationRequest;
import carpool.jwt.msecurityjwt.model.AuthenticationResponse;
import carpool.jwt.msecurityjwt.service.IInitialValidationService;




/**
 * @author wizar
 *
 */
@Controller
public class HelloResource {
	@Autowired
	private IInitialValidationService initialService;
	
	@RequestMapping(value ="/authenticate",method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,final @Context HttpServletRequest request) throws Exception{
		
		

		
		return ResponseEntity.ok(initialService.validacionInicial(authenticationRequest, request));
	}
	

	

}

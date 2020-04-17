package carpool.jwt.msecurityjwt.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import carpool.jwt.msecurityjwt.model.AuthenticationRequest;
import carpool.jwt.msecurityjwt.model.AuthenticationResponse;

@Service
public class InitialValidationService implements IInitialValidationService{

	 @Autowired
	    private MyUserDetailsService userDetailsService;

	    @Autowired
	    private JwtUtil jwtUtil;
	
	@Override
	public AuthenticationResponse validacionInicial(AuthenticationRequest data, HttpServletRequest request) {
		
		AuthenticationResponse respuesta = new AuthenticationResponse();
		
		
		 final String authorizationHeader = request.getHeader("Authorization");

	        String username = null;
	        String jwt = null;

	        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            jwt = authorizationHeader.substring(7);
	            username = jwtUtil.extractUsername(jwt);
	        }


	        if (username != null ) {

	            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

	            if (jwtUtil.validateToken(jwt, userDetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                
		    		respuesta.setCodeError("COD95");
		    		respuesta.setMsgError("token correcto"); 
	                
	            }else {
	            	respuesta.setCodeError("COD084");
	            	respuesta.setMsgError("usuario erroneo");
	            	
	            }
	        }else {
	        	
	        	

	    		final UserDetails userDetails = userDetailsService.loadUserByUsername(data.getxDAta());
	    		final String jwtNew  = jwtUtil.generateToken(userDetails);
	    		
	    		respuesta.setJwt(jwtNew);
	    		respuesta.setCodeError("COD95");
	    		respuesta.setMsgError("token generado exitosamente");
	        	
	        }
		
		
		return respuesta;
	}

}

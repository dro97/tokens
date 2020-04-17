/**
 * 
 */
package carpool.jwt.msecurityjwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import carpool.jwt.msecurityjwt.model.CarpoolUsersEO;
import carpool.jwt.msecurityjwt.repository.IUsersRepository;
import carpool.jwt.msecurityjwt.util.EncryptionUtil;

/**
 * @author wizar
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsersRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
		
		String password  = "";
		
		String user  = "";
				
		CarpoolUsersEO entidad = new CarpoolUsersEO();
		if(userCode.length()<20){
			
			
			
			
		String 	plaintText=userCode;
			
			
			
			
			entidad = userRepo.getNick(plaintText);
		
		}else {
			user  = userCode.substring(userCode.indexOf(',')+1,userCode.length());
			
			password  =  userCode.substring(0,userCode.indexOf(','));
			
			
		String 	plainUser = EncryptionUtil.decrypt(user);
			String plainPassword = EncryptionUtil.decrypt(password);
			entidad = userRepo.obtenerEntidad(plainUser,plainPassword);

		}
		
			
		
		return new User(entidad.getNick(),entidad.getPassword(),new ArrayList<>());
		
		
	}

}

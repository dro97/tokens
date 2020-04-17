/**
 * 
 */
package carpool.jwt.msecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import carpool.jwt.msecurityjwt.model.CarpoolUsersEO;

/**
 * @author wizar
 *
 */
public interface IUsersRepository extends JpaRepository<CarpoolUsersEO, Long>{

	@Query("SELECT c from  CarpoolUsersEO c where c.nick =:nick")
	CarpoolUsersEO getNick(@Param(value = "nick") String userCode);
	
	@Query("SELECT c from CarpoolUsersEO c where c.userCode =:codigo and c.password=:passs")
	CarpoolUsersEO obtenerEntidad(@Param(value = "codigo") String userCode, @Param(value= "passs" )String password);

}
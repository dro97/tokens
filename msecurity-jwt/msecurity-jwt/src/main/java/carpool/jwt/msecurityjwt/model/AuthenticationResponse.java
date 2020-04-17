/**
 * 
 */
package carpool.jwt.msecurityjwt.model;

/**
 * @author wizar
 *
 */
public class AuthenticationResponse {

	private  String jwt;
	
	private String codeError;
	
	private String msgError;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
	

	


}

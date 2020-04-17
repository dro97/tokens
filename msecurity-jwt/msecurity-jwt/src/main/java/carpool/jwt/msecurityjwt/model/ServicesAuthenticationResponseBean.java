/**
 * 
 */
package carpool.jwt.msecurityjwt.model;

/**
 * @author wizar
 *
 */
public class ServicesAuthenticationResponseBean {

	private String codeError;
	
	private String msjError;

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getMsjError() {
		return msjError;
	}

	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}
	
	
	
}

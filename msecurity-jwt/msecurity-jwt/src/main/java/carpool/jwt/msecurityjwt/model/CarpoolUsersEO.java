/**
 * 
 */
package carpool.jwt.msecurityjwt.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wizar
 *
 */
@Table(name = "carpool_users")
@Entity
public class CarpoolUsersEO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idusers")
	private Long id;
	@Column(name = "nick")
	private String nick;
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "phone")
	private String phone;
	@Column(name = "university")
	private String university;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "usercode")
	private String userCode;	

	

	public String getUserCode() {
	return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}

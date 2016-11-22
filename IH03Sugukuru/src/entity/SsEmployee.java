package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_employee database table.
 * 
 */
@Entity
@Table(name="ss_employee")
@NamedQuery(name="SsEmployee.findAll", query="SELECT s FROM SsEmployee s")
public class SsEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_code")
	private String employeeCode;

	private String address;

	@Column(name="building_name")
	private String buildingName;

	@Column(name="city_name")
	private String cityName;

	@Column(name="emergency_contact")
	private String emergencyContact;

	@Column(name="first_name")
	private String firstName;

	private String name;

	private String password;

	@Column(name="phone_no")
	private String phoneNo;

	private int position;

	@Column(name="postal_code")
	private String postalCode;

	private String purectures;

	@Temporal(TemporalType.DATE)
	@Column(name="register_date")
	private Date registerDate;

	private int sex;

	@Temporal(TemporalType.DATE)
	@Column(name="termination_date")
	private Date terminationDate;

	@Column(name="termination_flg")
	private int terminationFlg;

	@Column(name="town_name")
	private String townName;

	public SsEmployee() {
	}

	/**
	 * 以下アクセサメソッド
	 */
	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getEmergencyContact() {
		return this.emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPurectures() {
		return this.purectures;
	}

	public void setPurectures(String purectures) {
		this.purectures = purectures;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getTerminationDate() {
		return this.terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public int getTerminationFlg() {
		return this.terminationFlg;
	}

	public void setTerminationFlg(int terminationFlg) {
		this.terminationFlg = terminationFlg;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}
}
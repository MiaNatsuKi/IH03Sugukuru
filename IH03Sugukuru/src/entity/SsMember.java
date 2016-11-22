package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_member database table.
 * 
 */
@Entity
@Table(name="ss_member")
@NamedQuery(name="SsMember.findAll", query="SELECT s FROM SsMember s")
public class SsMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="member_code")
	private String memberCode;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String building;

	@Column(name="city_name")
	private String cityName;

	@Column(name="firest_name")
	private String firestName;

	@Column(name="first_name_inclination")
	private String firstNameInclination;

	private String name;

	@Column(name="name_inclination")
	private String nameInclination;

	private String password;

	@Column(name="phone_no")
	private String phoneNo;

	@Column(name="postal_code")
	private String postalCode;

	private String prefecture;

	@Temporal(TemporalType.DATE)
	@Column(name="regist_date")
	private Date registDate;

	@Column(name="town_name")
	private String townName;

	@Temporal(TemporalType.DATE)
	@Column(name="without_date")
	private Date withoutDate;

	@Column(name="without_flg")
	private int withoutFlg;

	public SsMember() {
	}

	public String getMemberCode() {
		return this.memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getFirestName() {
		return this.firestName;
	}

	public void setFirestName(String firestName) {
		this.firestName = firestName;
	}

	public String getFirstNameInclination() {
		return this.firstNameInclination;
	}

	public void setFirstNameInclination(String firstNameInclination) {
		this.firstNameInclination = firstNameInclination;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameInclination() {
		return this.nameInclination;
	}

	public void setNameInclination(String nameInclination) {
		this.nameInclination = nameInclination;
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

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public Date getRegistDate() {
		return this.registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Date getWithoutDate() {
		return this.withoutDate;
	}

	public void setWithoutDate(Date withoutDate) {
		this.withoutDate = withoutDate;
	}

	public int getWithoutFlg() {
		return this.withoutFlg;
	}

	public void setWithoutFlg(int withoutFlg) {
		this.withoutFlg = withoutFlg;
	}

}
package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_client database table.
 * 
 */
@Entity
@Table(name="ss_client")
@NamedQuery(name="SsClient.findAll", query="SELECT s FROM SsClient s")
public class SsClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_code")
	private String clientCode;

	private String address;

	@Column(name="building_name")
	private String buildingName;

	@Column(name="city_name")
	private String cityName;

	@Column(name="client_department")
	private String clientDepartment;

	@Column(name="client_name")
	private String clientName;

	@Column(name="client_name_phonetic")
	private String clientNamePhonetic;

	@Column(name="client_person_change")
	private String clientPersonChange;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private String fax;

	@Column(name="phone_no")
	private String phoneNo;

	@Column(name="postal_code")
	private String postalCode;

	private String prefecturs;

	@Lob
	private String remark;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="town_name")
	private String townName;

	public SsClient() {
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
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

	public String getClientDepartment() {
		return this.clientDepartment;
	}

	public void setClientDepartment(String clientDepartment) {
		this.clientDepartment = clientDepartment;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientNamePhonetic() {
		return this.clientNamePhonetic;
	}

	public void setClientNamePhonetic(String clientNamePhonetic) {
		this.clientNamePhonetic = clientNamePhonetic;
	}

	public String getClientPersonChange() {
		return this.clientPersonChange;
	}

	public void setClientPersonChange(String clientPersonChange) {
		this.clientPersonChange = clientPersonChange;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public String getPrefecturs() {
		return this.prefecturs;
	}

	public void setPrefecturs(String prefecturs) {
		this.prefecturs = prefecturs;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

}
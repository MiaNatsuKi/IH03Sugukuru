package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_earnings database table.
 * 
 */
@Entity
@Table(name="ss_earnings")
@NamedQuery(name="SsEarning.findAll", query="SELECT s FROM SsEarning s")
public class SsEarning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="earning_code")
	private String earningCode;

	@Column(name="client_code")
	private String clientCode;

	@Temporal(TemporalType.DATE)
	@Column(name="earning_date")
	private Date earningDate;

	@Column(name="earning_no")
	private String earningNo;

	@Temporal(TemporalType.DATE)
	@Column(name="issuance_date")
	private Date issuanceDate;

	private String person;

	private String subject;

	public SsEarning() {
	}

	public String getEarningCode() {
		return this.earningCode;
	}

	public void setEarningCode(String earningCode) {
		this.earningCode = earningCode;
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Date getEarningDate() {
		return this.earningDate;
	}

	public void setEarningDate(Date earningDate) {
		this.earningDate = earningDate;
	}

	public String getEarningNo() {
		return this.earningNo;
	}

	public void setEarningNo(String earningNo) {
		this.earningNo = earningNo;
	}

	public Date getIssuanceDate() {
		return this.issuanceDate;
	}

	public void setIssuanceDate(Date issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
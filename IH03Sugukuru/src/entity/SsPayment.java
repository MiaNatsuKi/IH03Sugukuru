package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_payments database table.
 * 
 */
@Entity
@Table(name="ss_payments")
@NamedQuery(name="SsPayment.findAll", query="SELECT s FROM SsPayment s")
public class SsPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_code")
	private String paymentCode;

	@Column(name="account_item")
	private String accountItem;

	@Column(name="employee_code")
	private String employeeCode;

	@Temporal(TemporalType.DATE)
	@Column(name="issuance_date")
	private Date issuanceDate;

	@Column(name="members_flag")
	private int membersFlag;

	@Temporal(TemporalType.DATE)
	@Column(name="payment_day")
	private Date paymentDay;

	private int price;

	private String summary;

	private int total;

	public SsPayment() {
	}

	public String getPaymentCode() {
		return this.paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getAccountItem() {
		return this.accountItem;
	}

	public void setAccountItem(String accountItem) {
		this.accountItem = accountItem;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getIssuanceDate() {
		return this.issuanceDate;
	}

	public void setIssuanceDate(Date issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	public int getMembersFlag() {
		return this.membersFlag;
	}

	public void setMembersFlag(int membersFlag) {
		this.membersFlag = membersFlag;
	}

	public Date getPaymentDay() {
		return this.paymentDay;
	}

	public void setPaymentDay(Date paymentDay) {
		this.paymentDay = paymentDay;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
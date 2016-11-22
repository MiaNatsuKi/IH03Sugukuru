package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_claims database table.
 * 
 */
@Entity
@Table(name="ss_claims")
@NamedQuery(name="SsClaim.findAll", query="SELECT s FROM SsClaim s")
public class SsClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="claim_code")
	private String claimCode;

	@Temporal(TemporalType.DATE)
	@Column(name="claim_date")
	private Date claimDate;

	@Column(name="claim_no")
	private String claimNo;

	@Column(name="client_code")
	private String clientCode;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="earning_code")
	private String earningCode;

	private int payment;

	@Column(name="plaim_price")
	private int plaimPrice;

	private int purchase;

	private String subject;

	private int sumtax;

	public SsClaim() {
	}

	public String getClaimCode() {
		return this.claimCode;
	}

	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	public Date getClaimDate() {
		return this.claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimNo() {
		return this.claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEarningCode() {
		return this.earningCode;
	}

	public void setEarningCode(String earningCode) {
		this.earningCode = earningCode;
	}

	public int getPayment() {
		return this.payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getPlaimPrice() {
		return this.plaimPrice;
	}

	public void setPlaimPrice(int plaimPrice) {
		this.plaimPrice = plaimPrice;
	}

	public int getPurchase() {
		return this.purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSumtax() {
		return this.sumtax;
	}

	public void setSumtax(int sumtax) {
		this.sumtax = sumtax;
	}

}
package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_estimation database table.
 * 
 */
@Entity
@Table(name="ss_estimation")
@NamedQuery(name="SsEstimation.findAll", query="SELECT s FROM SsEstimation s")
public class SsEstimation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="estimation_code")
	private String estimationCode;

	@Column(name="approval_status")
	private int approvalStatus;

	@Column(name="client_code")
	private String clientCode;

	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Column(name="employee_code")
	private String employeeCode;

	@Temporal(TemporalType.DATE)
	@Column(name="estimated_date")
	private Date estimatedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="expiration_date")
	private Date expirationDate;

	@Lob
	private String remark;

	private String subject;

	private int total;

	@Column(name="transaction_condition")
	private String transactionCondition;

	public SsEstimation() {
	}

	public String getEstimationCode() {
		return this.estimationCode;
	}

	public void setEstimationCode(String estimationCode) {
		this.estimationCode = estimationCode;
	}

	public int getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getEstimatedDate() {
		return this.estimatedDate;
	}

	public void setEstimatedDate(Date estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTransactionCondition() {
		return this.transactionCondition;
	}

	public void setTransactionCondition(String transactionCondition) {
		this.transactionCondition = transactionCondition;
	}

}
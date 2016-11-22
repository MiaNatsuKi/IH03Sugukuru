package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_credit database table.
 * 
 */
@Entity
@Table(name="ss_credit")
@NamedQuery(name="SsCredit.findAll", query="SELECT s FROM SsCredit s")
public class SsCredit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsCreditPK id;

	@Column(name="credit_amount")
	private int creditAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="modification_date")
	private Date modificationDate;

	@Lob
	private String remark;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	public SsCredit() {
	}

	public SsCreditPK getId() {
		return this.id;
	}

	public void setId(SsCreditPK id) {
		this.id = id;
	}

	public int getCreditAmount() {
		return this.creditAmount;
	}

	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Date getModificationDate() {
		return this.modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
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

}
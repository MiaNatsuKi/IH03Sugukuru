package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_discount database table.
 * 
 */
@Entity
@Table(name="ss_discount")
@NamedQuery(name="SsDiscount.findAll", query="SELECT s FROM SsDiscount s")
public class SsDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsDiscountPK id;

	@Column(name="dedication_price")
	private int dedicationPrice;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Lob
	private String remark;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	public SsDiscount() {
	}

	public SsDiscountPK getId() {
		return this.id;
	}

	public void setId(SsDiscountPK id) {
		this.id = id;
	}

	public int getDedicationPrice() {
		return this.dedicationPrice;
	}

	public void setDedicationPrice(int dedicationPrice) {
		this.dedicationPrice = dedicationPrice;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
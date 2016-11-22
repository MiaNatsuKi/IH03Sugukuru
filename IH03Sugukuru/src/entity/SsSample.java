package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_sample database table.
 * 
 */
@Entity
@Table(name="ss_sample")
@NamedQuery(name="SsSample.findAll", query="SELECT s FROM SsSample s")
public class SsSample implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsSamplePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Lob
	private String remark;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	public SsSample() {
	}

	public SsSamplePK getId() {
		return this.id;
	}

	public void setId(SsSamplePK id) {
		this.id = id;
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
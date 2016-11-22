package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_delivery_goods database table.
 * 
 */
@Entity
@Table(name="ss_delivery_goods")
@NamedQuery(name="SsDeliveryGood.findAll", query="SELECT s FROM SsDeliveryGood s")
public class SsDeliveryGood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="delivery_code")
	private String deliveryCode;

	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Column(name="estimation_code")
	private String estimationCode;

	@Column(name="estimation_code1")
	private String estimationCode1;

	@Lob
	private String remark;

	public SsDeliveryGood() {
	}

	public String getDeliveryCode() {
		return this.deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getEstimationCode() {
		return this.estimationCode;
	}

	public void setEstimationCode(String estimationCode) {
		this.estimationCode = estimationCode;
	}

	public String getEstimationCode1() {
		return this.estimationCode1;
	}

	public void setEstimationCode1(String estimationCode1) {
		this.estimationCode1 = estimationCode1;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
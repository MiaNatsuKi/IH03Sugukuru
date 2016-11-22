package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_estimate_particulars database table.
 * 
 */
@Entity
@Table(name="ss_estimate_particulars")
@NamedQuery(name="SsEstimateParticular.findAll", query="SELECT s FROM SsEstimateParticular s")
public class SsEstimateParticular implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsEstimateParticularPK id;

	private int quantity;

	@Column(name="sub_total")
	private int subTotal;

	private String unit;

	public SsEstimateParticular() {
	}

	public SsEstimateParticularPK getId() {
		return this.id;
	}

	public void setId(SsEstimateParticularPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
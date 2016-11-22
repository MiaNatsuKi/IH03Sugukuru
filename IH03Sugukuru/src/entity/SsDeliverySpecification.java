package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_delivery_specification database table.
 * 
 */
@Entity
@Table(name="ss_delivery_specification")
@NamedQuery(name="SsDeliverySpecification.findAll", query="SELECT s FROM SsDeliverySpecification s")
public class SsDeliverySpecification implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsDeliverySpecificationPK id;

	private int quantity;

	@Column(name="sub_total")
	private int subTotal;

	public SsDeliverySpecification() {
	}

	public SsDeliverySpecificationPK getId() {
		return this.id;
	}

	public void setId(SsDeliverySpecificationPK id) {
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

}
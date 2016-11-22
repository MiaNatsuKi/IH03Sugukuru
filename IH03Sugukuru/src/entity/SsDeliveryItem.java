package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_delivery_item database table.
 * 
 */
@Entity
@Table(name="ss_delivery_item")
@NamedQuery(name="SsDeliveryItem.findAll", query="SELECT s FROM SsDeliveryItem s")
public class SsDeliveryItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsDeliveryItemPK id;

	private int quantity;

	@Column(name="sub_total")
	private int subTotal;

	public SsDeliveryItem() {
	}

	public SsDeliveryItemPK getId() {
		return this.id;
	}

	public void setId(SsDeliveryItemPK id) {
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
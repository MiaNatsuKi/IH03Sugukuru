package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_order_details database table.
 * 
 */
@Entity
@Table(name="ss_order_details")
@NamedQuery(name="SsOrderDetail.findAll", query="SELECT s FROM SsOrderDetail s")
public class SsOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsOrderDetailPK id;

	private int quantity;

	@Column(name="sub_total")
	private int subTotal;

	public SsOrderDetail() {
	}

	public SsOrderDetailPK getId() {
		return this.id;
	}

	public void setId(SsOrderDetailPK id) {
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
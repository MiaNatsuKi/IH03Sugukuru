package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_order_details database table.
 * 
 */
@Embeddable
public class SsOrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="order_code")
	private String orderCode;

	@Column(name="products_code")
	private String productsCode;

	public SsOrderDetailPK() {
	}
	public String getOrderCode() {
		return this.orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getProductsCode() {
		return this.productsCode;
	}
	public void setProductsCode(String productsCode) {
		this.productsCode = productsCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SsOrderDetailPK)) {
			return false;
		}
		SsOrderDetailPK castOther = (SsOrderDetailPK)other;
		return 
			this.orderCode.equals(castOther.orderCode)
			&& this.productsCode.equals(castOther.productsCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderCode.hashCode();
		hash = hash * prime + this.productsCode.hashCode();
		
		return hash;
	}
}
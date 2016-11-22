package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_delivery_specification database table.
 * 
 */
@Embeddable
public class SsDeliverySpecificationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="`delivery _code`")
	private String delivery_Code;

	@Column(name="products_code")
	private String productsCode;

	public SsDeliverySpecificationPK() {
	}
	public String getDelivery_Code() {
		return this.delivery_Code;
	}
	public void setDelivery_Code(String delivery_Code) {
		this.delivery_Code = delivery_Code;
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
		if (!(other instanceof SsDeliverySpecificationPK)) {
			return false;
		}
		SsDeliverySpecificationPK castOther = (SsDeliverySpecificationPK)other;
		return 
			this.delivery_Code.equals(castOther.delivery_Code)
			&& this.productsCode.equals(castOther.productsCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.delivery_Code.hashCode();
		hash = hash * prime + this.productsCode.hashCode();
		
		return hash;
	}
}
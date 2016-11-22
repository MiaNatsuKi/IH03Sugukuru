package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_sample database table.
 * 
 */
@Embeddable
public class SsSamplePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="product_code")
	private String productCode;

	@Column(name="client_code")
	private String clientCode;

	public SsSamplePK() {
	}
	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getClientCode() {
		return this.clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SsSamplePK)) {
			return false;
		}
		SsSamplePK castOther = (SsSamplePK)other;
		return 
			this.productCode.equals(castOther.productCode)
			&& this.clientCode.equals(castOther.clientCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productCode.hashCode();
		hash = hash * prime + this.clientCode.hashCode();
		
		return hash;
	}
}
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_estimate_particulars database table.
 * 
 */
@Embeddable
public class SsEstimateParticularPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="estimate_code")
	private String estimateCode;

	@Column(name="product_code")
	private String productCode;

	public SsEstimateParticularPK() {
	}
	public String getEstimateCode() {
		return this.estimateCode;
	}
	public void setEstimateCode(String estimateCode) {
		this.estimateCode = estimateCode;
	}
	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SsEstimateParticularPK)) {
			return false;
		}
		SsEstimateParticularPK castOther = (SsEstimateParticularPK)other;
		return 
			this.estimateCode.equals(castOther.estimateCode)
			&& this.productCode.equals(castOther.productCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.estimateCode.hashCode();
		hash = hash * prime + this.productCode.hashCode();
		
		return hash;
	}
}
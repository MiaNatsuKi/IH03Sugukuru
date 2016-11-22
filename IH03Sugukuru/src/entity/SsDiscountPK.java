package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_discount database table.
 * 
 */
@Embeddable
public class SsDiscountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="client_code")
	private String clientCode;

	@Column(name="product_code")
	private String productCode;

	@Column(name="line_no")
	private int lineNo;

	public SsDiscountPK() {
	}
	public String getClientCode() {
		return this.clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getLineNo() {
		return this.lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SsDiscountPK)) {
			return false;
		}
		SsDiscountPK castOther = (SsDiscountPK)other;
		return 
			this.clientCode.equals(castOther.clientCode)
			&& this.productCode.equals(castOther.productCode)
			&& (this.lineNo == castOther.lineNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientCode.hashCode();
		hash = hash * prime + this.productCode.hashCode();
		hash = hash * prime + this.lineNo;
		
		return hash;
	}
}
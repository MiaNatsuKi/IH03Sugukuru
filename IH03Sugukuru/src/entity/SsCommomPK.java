package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_commom database table.
 * 
 */
@Embeddable
public class SsCommomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="consumption_tax")
	private float consumptionTax;

	@Column(name="company_name")
	private String companyName;

	public SsCommomPK() {
	}
	public float getConsumptionTax() {
		return this.consumptionTax;
	}
	public void setConsumptionTax(float consumptionTax) {
		this.consumptionTax = consumptionTax;
	}
	public String getCompanyName() {
		return this.companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SsCommomPK)) {
			return false;
		}
		SsCommomPK castOther = (SsCommomPK)other;
		return 
			(this.consumptionTax == castOther.consumptionTax)
			&& this.companyName.equals(castOther.companyName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + java.lang.Float.floatToIntBits(this.consumptionTax);
		hash = hash * prime + this.companyName.hashCode();
		
		return hash;
	}
}
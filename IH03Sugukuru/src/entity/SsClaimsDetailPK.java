package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ss_claims_detail database table.
 * 
 */
@Embeddable
public class SsClaimsDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="claim_code")
	private String claimCode;

	@Column(name="line_number")
	private String lineNumber;

	public SsClaimsDetailPK() {
	}
	public String getClaimCode() {
		return this.claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getLineNumber() {
		return this.lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SsClaimsDetailPK)) {
			return false;
		}
		SsClaimsDetailPK castOther = (SsClaimsDetailPK)other;
		return 
			this.claimCode.equals(castOther.claimCode)
			&& this.lineNumber.equals(castOther.lineNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.claimCode.hashCode();
		hash = hash * prime + this.lineNumber.hashCode();
		
		return hash;
	}
}
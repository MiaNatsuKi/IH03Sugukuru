package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_return_product database table.
 * 
 */
@Entity
@Table(name="ss_return_product")
@NamedQuery(name="SsReturnProduct.findAll", query="SELECT s FROM SsReturnProduct s")
public class SsReturnProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="return_code")
	private int returnCode;

	@Column(name="client_code")
	private String clientCode;

	@Column(name="member_code")
	private String memberCode;

	@Column(name="product_code")
	private String productCode;

	@Temporal(TemporalType.DATE)
	@Column(name="return_date")
	private Date returnDate;

	@Lob
	@Column(name="return_reason")
	private String returnReason;

	public SsReturnProduct() {
	}

	public int getReturnCode() {
		return this.returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getMemberCode() {
		return this.memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnReason() {
		return this.returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

}
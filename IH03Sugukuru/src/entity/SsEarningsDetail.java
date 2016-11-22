package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_earnings_detail database table.
 * 
 */
@Entity
@Table(name="ss_earnings_detail")
@NamedQuery(name="SsEarningsDetail.findAll", query="SELECT s FROM SsEarningsDetail s")
public class SsEarningsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="earning_code")
	private String earningCode;

	@Column(name="line_number")
	private String lineNumber;

	@Column(name="products_code")
	private String productsCode;

	private int quentify;

	private String summary;

	@Column(name="unit_price")
	private int unitPrice;

	public SsEarningsDetail() {
	}

	public String getEarningCode() {
		return this.earningCode;
	}

	public void setEarningCode(String earningCode) {
		this.earningCode = earningCode;
	}

	public String getLineNumber() {
		return this.lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getProductsCode() {
		return this.productsCode;
	}

	public void setProductsCode(String productsCode) {
		this.productsCode = productsCode;
	}

	public int getQuentify() {
		return this.quentify;
	}

	public void setQuentify(int quentify) {
		this.quentify = quentify;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

}
package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_claims_detail database table.
 * 
 */
@Entity
@Table(name="ss_claims_detail")
@NamedQuery(name="SsClaimsDetail.findAll", query="SELECT s FROM SsClaimsDetail s")
public class SsClaimsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsClaimsDetailPK id;

	@Column(name="products_name")
	private String productsName;

	private int quentify;

	private String summary;

	@Column(name="unit_price")
	private int unitPrice;

	public SsClaimsDetail() {
	}

	public SsClaimsDetailPK getId() {
		return this.id;
	}

	public void setId(SsClaimsDetailPK id) {
		this.id = id;
	}

	public String getProductsName() {
		return this.productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
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
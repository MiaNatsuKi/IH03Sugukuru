package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_products database table.
 * 
 */
@Entity
@Table(name="ss_products")
@NamedQuery(name="SsProduct.findAll", query="SELECT s FROM SsProduct s")
public class SsProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="products_code")
	private String productsCode;

	@Column(name="maker_name")
	private String makerName;

	@Column(name="prime_cost")
	private int primeCost;

	@Lob
	@Column(name="product_explanation")
	private String productExplanation;

	@Lob
	@Column(name="product_specifications")
	private String productSpecifications;

	@Column(name="products_name")
	private String productsName;

	@Column(name="release_flg")
	private int releaseFlg;

	@Lob
	private String remark;

	@Column(name="sample_stock")
	private int sampleStock;

	@Column(name="sell_price")
	private int sellPrice;

	@Column(name="stock_num")
	private int stockNum;

	public SsProduct() {
	}

	public String getProductsCode() {
		return this.productsCode;
	}

	public void setProductsCode(String productsCode) {
		this.productsCode = productsCode;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public int getPrimeCost() {
		return this.primeCost;
	}

	public void setPrimeCost(int primeCost) {
		this.primeCost = primeCost;
	}

	public String getProductExplanation() {
		return this.productExplanation;
	}

	public void setProductExplanation(String productExplanation) {
		this.productExplanation = productExplanation;
	}

	public String getProductSpecifications() {
		return this.productSpecifications;
	}

	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public String getProductsName() {
		return this.productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public int getReleaseFlg() {
		return this.releaseFlg;
	}

	public void setReleaseFlg(int releaseFlg) {
		this.releaseFlg = releaseFlg;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSampleStock() {
		return this.sampleStock;
	}

	public void setSampleStock(int sampleStock) {
		this.sampleStock = sampleStock;
	}

	public int getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getStockNum() {
		return this.stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

}
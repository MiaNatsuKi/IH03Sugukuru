package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_images database table.
 * 
 */
@Entity
@Table(name="ss_images")
@NamedQuery(name="SsImage.findAll", query="SELECT s FROM SsImage s")
public class SsImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="image_id")
	private String imageId;

	@Column(name="image_code")
	private String imageCode;

	@Column(name="products_code")
	private String productsCode;

	public SsImage() {
	}

	public String getImageId() {
		return this.imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageCode() {
		return this.imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public String getProductsCode() {
		return this.productsCode;
	}

	public void setProductsCode(String productsCode) {
		this.productsCode = productsCode;
	}

}
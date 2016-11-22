package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_category database table.
 * 
 */
@Entity
@Table(name="ss_category")
@NamedQuery(name="SsCategory.findAll", query="SELECT s FROM SsCategory s")
public class SsCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private String categoryId;

	@Column(name="category_name")
	private String categoryName;

	public SsCategory() {
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
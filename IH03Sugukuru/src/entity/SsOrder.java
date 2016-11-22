package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_order database table.
 * 
 */
@Entity
@Table(name="ss_order")
@NamedQuery(name="SsOrder.findAll", query="SELECT s FROM SsOrder s")
public class SsOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_code")
	private String orderCode;

	@Column(name="client_code")
	private String clientCode;

	@Column(name="estimated_code")
	private String estimatedCode;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	@Lob
	private String remark;

	public SsOrder() {
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getEstimatedCode() {
		return this.estimatedCode;
	}

	public void setEstimatedCode(String estimatedCode) {
		this.estimatedCode = estimatedCode;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
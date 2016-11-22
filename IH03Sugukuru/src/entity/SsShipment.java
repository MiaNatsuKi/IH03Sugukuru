package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_shipment database table.
 * 
 */
@Entity
@Table(name="ss_shipment")
@NamedQuery(name="SsShipment.findAll", query="SELECT s FROM SsShipment s")
public class SsShipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="shipment_code")
	private String shipmentCode;

	@Column(name="client_code")
	private String clientCode;

	@Column(name="estimated_code")
	private String estimatedCode;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_shipping_date")
	private Date expectedShippingDate;

	public SsShipment() {
	}

	public String getShipmentCode() {
		return this.shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
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

	public Date getExpectedShippingDate() {
		return this.expectedShippingDate;
	}

	public void setExpectedShippingDate(Date expectedShippingDate) {
		this.expectedShippingDate = expectedShippingDate;
	}

}
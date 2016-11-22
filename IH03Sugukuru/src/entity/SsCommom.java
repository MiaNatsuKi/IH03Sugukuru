package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ss_commom database table.
 * 
 */
@Entity
@Table(name="ss_commom")
@NamedQuery(name="SsCommom.findAll", query="SELECT s FROM SsCommom s")
public class SsCommom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SsCommomPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="`company_name_ end`")
	private Date companyName_end;

	@Temporal(TemporalType.DATE)
	@Column(name="`company_name_ start`")
	private Date companyName_start;

	@Temporal(TemporalType.DATE)
	@Column(name="consumption_tax_end")
	private Date consumptionTaxEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="consumption_tax_start")
	private Date consumptionTaxStart;

	public SsCommom() {
	}

	public SsCommomPK getId() {
		return this.id;
	}

	public void setId(SsCommomPK id) {
		this.id = id;
	}

	public Date getCompanyName_end() {
		return this.companyName_end;
	}

	public void setCompanyName_end(Date companyName_end) {
		this.companyName_end = companyName_end;
	}

	public Date getCompanyName_start() {
		return this.companyName_start;
	}

	public void setCompanyName_start(Date companyName_start) {
		this.companyName_start = companyName_start;
	}

	public Date getConsumptionTaxEnd() {
		return this.consumptionTaxEnd;
	}

	public void setConsumptionTaxEnd(Date consumptionTaxEnd) {
		this.consumptionTaxEnd = consumptionTaxEnd;
	}

	public Date getConsumptionTaxStart() {
		return this.consumptionTaxStart;
	}

	public void setConsumptionTaxStart(Date consumptionTaxStart) {
		this.consumptionTaxStart = consumptionTaxStart;
	}

}
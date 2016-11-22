package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ss_prefecture database table.
 * 
 */
@Entity
@Table(name="ss_prefecture")
@NamedQuery(name="SsPrefecture.findAll", query="SELECT s FROM SsPrefecture s")
public class SsPrefecture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prefecture_id")
	private String prefectureId;

	@Column(name="prefecture_name")
	private String prefectureName;

	public SsPrefecture() {
	}

	public String getPrefectureId() {
		return this.prefectureId;
	}

	public void setPrefectureId(String prefectureId) {
		this.prefectureId = prefectureId;
	}

	public String getPrefectureName() {
		return this.prefectureName;
	}

	public void setPrefectureName(String prefectureName) {
		this.prefectureName = prefectureName;
	}

}
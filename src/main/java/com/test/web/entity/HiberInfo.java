package com.test.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "hi")
@Table(name = "hiber_info")
public class HiberInfo {
	@Id
	@SequenceGenerator(name="seqHiNum", sequenceName = "seq_hi_num" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqHiNum")
	@Column(name = "hi_num")
	private int hiNum;
	
	@Column(name = "hi_name")
	private String hiName;

	@Column(name = "hi_id")
	private String hiId;
	
	public String getHiId() {
		return hiId;
	}

	public void setHiId(String hiId) {
		this.hiId = hiId;
	}

	public int getHiNum() {
		return hiNum;
	}

	public void setHiNum(int hiNum) {
		this.hiNum = hiNum;
	}

	public String getHiName() {
		return hiName;
	}

	public void setHiName(String hiName) {
		this.hiName = hiName;
	}

	@Override
	public String toString() {
		return "HiberInfo [hiNum=" + hiNum + ", hiName=" + hiName + ", hiId=" + hiId + "]";
	}

	
}

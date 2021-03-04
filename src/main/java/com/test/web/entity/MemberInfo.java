package com.test.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="member_info")
public class MemberInfo {

	@Id
	@SequenceGenerator(name = "seqMeiNum", sequenceName = "seq_mei_num", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqMeiNum")
	@Column(name="mi_num", nullable = false, unique = true)
	private Integer miNum;
	
	@Column(name="mi_id", nullable = false, unique = true)
	private String miId;
	
	@Column(name="mi_pwd", nullable = false)
	private String miPwd;
	
	@Column(name="mi_name", nullable = false)
	private String miName;
	
	@Column(name="mi_age")
	private Integer miAge;
	
	@Column(name="mi_info")
	private String miInfo;

	public Integer getMiNum() {
		return miNum;
	}

	public void setMiNum(Integer miNum) {
		this.miNum = miNum;
	}

	public String getMiId() {
		return miId;
	}

	public void setMiId(String miId) {
		this.miId = miId;
	}

	public String getMiPwd() {
		return miPwd;
	}

	public void setMiPwd(String miPwd) {
		this.miPwd = miPwd;
	}

	public String getMiName() {
		return miName;
	}

	public void setMiName(String miName) {
		this.miName = miName;
	}

	public Integer getMiAge() {
		return miAge;
	}

	public void setMiAge(Integer miAge) {
		this.miAge = miAge;
	}

	public String getMiInfo() {
		return miInfo;
	}

	public void setMiInfo(String miInfo) {
		this.miInfo = miInfo;
	}

	@Override
	public String toString() {
		return "MemberInfo [miNum=" + miNum + ", miId=" + miId + ", miPwd=" + miPwd + ", miName=" + miName + ", miAge="
				+ miAge + ", miInfo=" + miInfo + "]";
	}

	
}

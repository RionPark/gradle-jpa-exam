package test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "computer_info")
public class ComputerInfo {
	@Id
	@Column(name = "ci_num")
	private Long ciNum;
	
	@Column(name = "ci_cpu")
	private String ciCpu;
	
	@Column(name = "ci_desc")
	private String ciDesc;
	
	@Column(name = "ci_ram")
	private Integer ciRam;
	
	@Column(name = "ci_sdd")
	private Integer ciSdd;
	
	@Column(name = "ci_hdd")
	private Integer ciHdd;

	public Long getCiNum() {
		return ciNum;
	}

	public void setCiNum(Long ciNum) {
		this.ciNum = ciNum;
	}

	public String getCiCpu() {
		return ciCpu;
	}

	public void setCiCpu(String ciCpu) {
		this.ciCpu = ciCpu;
	}

	public String getCiDesc() {
		return ciDesc;
	}

	public void setCiDesc(String ciDesc) {
		this.ciDesc = ciDesc;
	}

	public Integer getCiRam() {
		return ciRam;
	}

	public void setCiRam(Integer ciRam) {
		this.ciRam = ciRam;
	}

	public Integer getCiSdd() {
		return ciSdd;
	}

	public void setCiSdd(Integer ciSdd) {
		this.ciSdd = ciSdd;
	}

	public Integer getCiHdd() {
		return ciHdd;
	}

	public void setCiHdd(Integer ciHdd) {
		this.ciHdd = ciHdd;
	}

	@Override
	public String toString() {
		return "ComputerInfo [ciNum=" + ciNum + ", ciCpu=" + ciCpu + ", ciDesc=" + ciDesc + ", ciRam=" + ciRam
				+ ", ciSdd=" + ciSdd + ", ciHdd=" + ciHdd + "]";
	}
	
	
}

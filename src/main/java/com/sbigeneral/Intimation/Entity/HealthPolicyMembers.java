package com.sbigeneral.Intimation.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HEALTHPOLICY_MEMBERS")
public class HealthPolicyMembers {

	@Id
	@Column(name = "MEMBERID")
	private Long memberId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "POLICYNO")
	private String policyNo;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	@Override
	public String toString() {
		return "HealthPolicyMembers [memberId=" + memberId + ", name=" + name + ", policyNo=" + policyNo + "]";
	}
	
	
}

package com.sbigeneral.Intimation.model;

public class PolicyIntimationInfo2 {
	private int intimationAmount;
	
	private String intimationDate;
	
	private String policyNo;
	
	private String intimationNo;
	
	private String lob;

    private String claimStatus;


    public int getIntimationAmount() {
        return intimationAmount;
    }

    public void setIntimationAmount(int intimationAmount) {
        this.intimationAmount = intimationAmount;
    }

    public String getIntimationDate() {
        return intimationDate;
    }

    public void setIntimationDate(String intimationDate) {
        this.intimationDate = intimationDate;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getIntimationNo() {
        return intimationNo;
    }

    public void setIntimationNo(String intimationNo) {
        this.intimationNo = intimationNo;
    }

    public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

	@Override
	public String toString() {
		return "PolicyIntimationInfo2 [intimationAmount=" + intimationAmount + ", intimationDate=" + intimationDate
				+ ", policyNo=" + policyNo + ", intimationNo=" + intimationNo + ", lob=" + lob + ", claimStatus="
				+ claimStatus + "]";
	}

   

}

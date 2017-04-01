package query.service.entity;

import java.io.Serializable;
import java.util.Date;

public class IhubAuth implements Serializable {
	
	private String transactionType;
	private Double transactionAmount;
	private Date transactionDate;
	private Date batchCloseDate;
	private String paymentType;
	private String batchType;
	private Double dispositionStatus;
	private Boolean mLinkSuccessfullyProcessed;
	private Boolean isBatchClosed;
	
	public IhubAuth(String transactionType, Double transactionAmount, Date transactionDate, Date batchCloseDate,
			String paymentType, String batchType, Double dispositionStatus, Boolean mLinkSuccessfullyProcessed,
			Boolean isBatchClosed) {
		super();
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.batchCloseDate = batchCloseDate;
		this.paymentType = paymentType;
		this.batchType = batchType;
		this.dispositionStatus = dispositionStatus;
		this.mLinkSuccessfullyProcessed = mLinkSuccessfullyProcessed;
		this.isBatchClosed = isBatchClosed;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getBatchCloseDate() {
		return batchCloseDate;
	}

	public void setBatchCloseDate(Date batchCloseDate) {
		this.batchCloseDate = batchCloseDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public Double getDispositionStatus() {
		return dispositionStatus;
	}

	public void setDispositionStatus(Double dispositionStatus) {
		this.dispositionStatus = dispositionStatus;
	}

	public Boolean getmLinkSuccessfullyProcessed() {
		return mLinkSuccessfullyProcessed;
	}

	public void setmLinkSuccessfullyProcessed(Boolean mLinkSuccessfullyProcessed) {
		this.mLinkSuccessfullyProcessed = mLinkSuccessfullyProcessed;
	}

	public Boolean getIsBatchClosed() {
		return isBatchClosed;
	}

	public void setIsBatchClosed(Boolean isBatchClosed) {
		this.isBatchClosed = isBatchClosed;
	}

	@Override
	public String toString() {
		return "IhubAuth [transactionType=" + transactionType + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + ", batchCloseDate=" + batchCloseDate + ", paymentType="
				+ paymentType + ", batchType=" + batchType + ", dispositionStatus=" + dispositionStatus
				+ ", mLinkSuccessfullyProcessed=" + mLinkSuccessfullyProcessed + ", isBatchClosed=" + isBatchClosed
				+ "]";
	}
	
}

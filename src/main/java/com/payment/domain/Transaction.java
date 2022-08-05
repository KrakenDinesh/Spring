package com.payment.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private String customerId, currencyCode, senderBIC, receiverBIC;
	private String receiverAccountHolderNumber, receiverAccountHolderName;
	private String transferTypeCode, messageCode;
	private double currencyAmount, transferFees, inrAmount;
	private Date trasferDate;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(String customerId, String currencyCode, String senderBIC, String receiverBIC,
			String receiverAccountHolderNumber, String receiverAccountHolderName, String transferTypeCode,
			String messageCode, double currencyAmount, double transferFees, double inrAmount, Date trasferDate) {
		super();
		this.customerId = customerId;
		this.currencyCode = currencyCode;
		this.senderBIC = senderBIC;
		this.receiverBIC = receiverBIC;
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
		this.receiverAccountHolderName = receiverAccountHolderName;
		this.transferTypeCode = transferTypeCode;
		this.messageCode = messageCode;
		this.currencyAmount = currencyAmount;
		this.transferFees = transferFees;
		this.inrAmount = inrAmount;
		this.trasferDate = trasferDate;
	}
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getSenderBIC() {
		return senderBIC;
	}

	public void setSenderBIC(String senderBIC) {
		this.senderBIC = senderBIC;
	}

	public String getReceiverBIC() {
		return receiverBIC;
	}

	public void setReceiverBIC(String receiverBIC) {
		this.receiverBIC = receiverBIC;
	}

	public String getReceiverAccountHolderNumber() {
		return receiverAccountHolderNumber;
	}

	public void setReceiverAccountHolderNumber(String receiverAccountHolderNumber) {
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
	}

	public String getReceiverAccountHolderName() {
		return receiverAccountHolderName;
	}

	public void setReceiverAccountHolderName(String receiverAccountHolderName) {
		this.receiverAccountHolderName = receiverAccountHolderName;
	}

	public String getTransferTypeCode() {
		return transferTypeCode;
	}

	public void setTransferTypeCode(String transferTypeCode) {
		this.transferTypeCode = transferTypeCode;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public double getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(double currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	public double getTransferFees() {
		return transferFees;
	}

	public void setTransferFees(double transferFees) {
		this.transferFees = transferFees;
	}

	public double getInrAmount() {
		return inrAmount;
	}

	public void setInrAmount(double inrAmount) {
		this.inrAmount = inrAmount;
	}

	public Date getTrasferDate() {
		return trasferDate;
	}

	public void setTrasferDate(Date trasferDate) {
		this.trasferDate = trasferDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currencyAmount, currencyCode, customerId, inrAmount, messageCode, receiverAccountHolderName,
				receiverAccountHolderNumber, receiverBIC, senderBIC, transactionId, transferFees, transferTypeCode,
				trasferDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(currencyAmount) == Double.doubleToLongBits(other.currencyAmount)
				&& Objects.equals(currencyCode, other.currencyCode) && Objects.equals(customerId, other.customerId)
				&& Double.doubleToLongBits(inrAmount) == Double.doubleToLongBits(other.inrAmount)
				&& Objects.equals(messageCode, other.messageCode)
				&& Objects.equals(receiverAccountHolderName, other.receiverAccountHolderName)
				&& Objects.equals(receiverAccountHolderNumber, other.receiverAccountHolderNumber)
				&& Objects.equals(receiverBIC, other.receiverBIC) && Objects.equals(senderBIC, other.senderBIC)
				&& transactionId == other.transactionId
				&& Double.doubleToLongBits(transferFees) == Double.doubleToLongBits(other.transferFees)
				&& Objects.equals(transferTypeCode, other.transferTypeCode)
				&& Objects.equals(trasferDate, other.trasferDate);
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", currencyCode="
				+ currencyCode + ", senderBIC=" + senderBIC + ", receiverBIC=" + receiverBIC
				+ ", receiverAccountHolderNumber=" + receiverAccountHolderNumber + ", receiverAccountHolderName="
				+ receiverAccountHolderName + ", transferTypeCode=" + transferTypeCode + ", messageCode=" + messageCode
				+ ", currencyAmount=" + currencyAmount + ", transferFees=" + transferFees + ", inrAmount=" + inrAmount
				+ ", trasferDate=" + trasferDate + "]";
	}

}

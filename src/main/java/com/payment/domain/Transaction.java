package com.payment.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private String receiverBIC;
	private String receiverAccountHolderNumber, receiverAccountHolderName;
	private double currencyAmount, transferFees, inrAmount;
	private Date trasferDate;

	@ManyToOne(targetEntity = Customers.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customertransactionid")
	private Customers customer;

	@OneToOne(targetEntity = MessageCode.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionmessage")
	private MessageCode messagecode;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String receiverBIC, String receiverAccountHolderNumber, String receiverAccountHolderName,
			double currencyAmount, double transferFees, double inrAmount, Date trasferDate) {
		super();
		this.receiverBIC = receiverBIC;
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
		this.receiverAccountHolderName = receiverAccountHolderName;
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

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public MessageCode getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(MessageCode messagecode) {
		this.messagecode = messagecode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currencyAmount, customer, inrAmount, receiverAccountHolderName, receiverAccountHolderNumber,
				receiverBIC, transactionId, transferFees, trasferDate);
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
				&& Objects.equals(customer, other.customer)
				&& Double.doubleToLongBits(inrAmount) == Double.doubleToLongBits(other.inrAmount)
				&& Objects.equals(receiverAccountHolderName, other.receiverAccountHolderName)
				&& Objects.equals(receiverAccountHolderNumber, other.receiverAccountHolderNumber)
				&& Objects.equals(receiverBIC, other.receiverBIC) && Objects.equals(transactionId, other.transactionId)
				&& Double.doubleToLongBits(transferFees) == Double.doubleToLongBits(other.transferFees)
				&& Objects.equals(trasferDate, other.trasferDate);
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", receiverBIC=" + receiverBIC
				+ ", receiverAccountHolderNumber=" + receiverAccountHolderNumber + ", receiverAccountHolderName="
				+ receiverAccountHolderName + ", currencyAmount=" + currencyAmount + ", transferFees=" + transferFees
				+ ", inrAmount=" + inrAmount + ", trasferDate=" + trasferDate + ", customer=" + customer + "]";
	}

}

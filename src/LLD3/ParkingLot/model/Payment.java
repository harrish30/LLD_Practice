package LLD3.ParkingLot.model;

import LLD3.ParkingLot.model.constant.PaymentMode;
import LLD3.ParkingLot.model.constant.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private double amount;
    private String transactionRefNumber;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Bill bill;
    private LocalDateTime paymentTime;

    public Payment() {
    }

    public Payment(double amount, String transactionRefNumber, PaymentMode paymentMode, PaymentStatus paymentStatus, Bill bill, LocalDateTime paymentTime) {
        this.amount = amount;
        this.transactionRefNumber = transactionRefNumber;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.bill = bill;
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionRefNumber() {
        return transactionRefNumber;
    }

    public void setTransactionRefNumber(String transactionRefNumber) {
        this.transactionRefNumber = transactionRefNumber;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}

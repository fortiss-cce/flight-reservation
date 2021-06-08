package flight.reservation.payment;

import flight.reservation.order.FlightOrder;

import java.util.Date;

public abstract class Payment {
    protected double amount;

    public Payment() {
        this.amount = 0;
    }

    public abstract boolean pay(FlightOrder flightOrder, double amount) throws IllegalStateException;

    public abstract boolean processOrder(FlightOrder flightOrder) throws IllegalStateException;


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
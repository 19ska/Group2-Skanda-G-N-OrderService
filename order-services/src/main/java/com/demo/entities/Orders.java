package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//Order entity
@Entity
public class Orders {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderId;

	    @OneToOne
	    @JoinColumn
	    private Cart cart;

	    private double totalPrice;

	    private String paymentStatus;

	    private String orderStatus;

public Orders() {
	super();
}





public Long getOrderId() {
	return orderId;
}





public void setOrderId(Long orderId) {
	this.orderId = orderId;
}





public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public String getPaymentStatus() {
	return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

public String getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

 // Constructors, getters, setters
}

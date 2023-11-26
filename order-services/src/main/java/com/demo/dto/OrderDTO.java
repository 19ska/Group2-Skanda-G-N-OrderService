package com.demo.dto;

import com.demo.entities.Cart;

public class OrderDTO {
     private Long cartId;
    private double totalPrice;
    private String paymentStatus;
    private String orderStatus;
    private Long customerId;
	public OrderDTO() {
		super();
	}
	
	
	


	public Long getCartId() {
		return cartId;
	}





	public void setCartId(Long cartId) {
		this.cartId = cartId;
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





	public Long getCustomerId() {
		return customerId;
	}





	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	

    
    
}

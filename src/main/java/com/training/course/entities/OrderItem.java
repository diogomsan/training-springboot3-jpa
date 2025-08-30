package com.training.course.entities;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.course.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK oItemPK = new OrderItemPK();

	private Integer quantity;
	private Double price;

	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		oItemPK.setOrder(order);
		oItemPK.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return oItemPK.getOrder();
	}

	public void setOrder(Order order) {
		oItemPK.setOrder(order);
	}

	public Product getProduct() {
		return oItemPK.getProduct();
	}

	public void setProduct(Product product) {
		oItemPK.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return price * quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oItemPK == null) ? 0 : oItemPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (oItemPK == null) {
			if (other.oItemPK != null)
				return false;
		} else if (!oItemPK.equals(other.oItemPK))
			return false;
		return true;
	}
}

package com.training.course.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ODER")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    
    
    public Order() {
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public Instant getMoment() {
        return moment;
    }


    public void setMoment(Instant moment) {
        this.moment = moment;
    }


    public Integer getOrderStatus() {
        return orderStatus;
    }


    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    

}

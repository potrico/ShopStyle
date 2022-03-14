package com.ms.checkout.entity;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    private Long payment_id;

    private double discount;

    private boolean status;

}

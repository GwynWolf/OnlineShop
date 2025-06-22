package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "delivery_price", nullable = false)
    private BigDecimal deliveryPrice;

    @Column(name = "payment_method_id")
    private Integer paymentMethodId;

    @Column(nullable = false)
    private Boolean paid;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private Boolean closed;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String address;

    private String phone;

    @Column(name = "phone_to_delete", nullable = false)
    private String phoneToDelete;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String comment;

    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    private String url;

    @Column(name = "payment_details", columnDefinition = "mediumtext")
    private String paymentDetails;

    private String ip;

    @Column(name = "undiscounted_total_price", nullable = false)
    private BigDecimal undiscountedTotalPrice;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private String note;

    @Column(name = "separate_delivery")
    private Boolean separateDelivery;

    @Column(nullable = false)
    private Timestamp modified;

    @Column(name = "lang_id", nullable = false)
    private Integer langId;

    @Column(name = "referer_channel")
    @Enumerated(EnumType.STRING)
    private RefererChannel refererChannel;

    @Column(name = "referer_source")
    private String refererSource;

    // Enum для referer_channel
    public enum RefererChannel {
        email, search, social, referral, unknown
    }
}

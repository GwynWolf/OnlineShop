package com.onlineshop.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
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

    // --- Геттеры и сеттеры ---

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getDeliveryId() { return deliveryId; }

    public void setDeliveryId(Integer deliveryId) { this.deliveryId = deliveryId; }

    public BigDecimal getDeliveryPrice() { return deliveryPrice; }

    public void setDeliveryPrice(BigDecimal deliveryPrice) { this.deliveryPrice = deliveryPrice; }

    public Integer getPaymentMethodId() { return paymentMethodId; }

    public void setPaymentMethodId(Integer paymentMethodId) { this.paymentMethodId = paymentMethodId; }

    public Boolean getPaid() { return paid; }

    public void setPaid(Boolean paid) { this.paid = paid; }

    public LocalDateTime getPaymentDate() { return paymentDate; }

    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public Boolean getClosed() { return closed; }

    public void setClosed(Boolean closed) { this.closed = closed; }

    public LocalDateTime getDate() { return date; }

    public void setDate(LocalDateTime date) { this.date = date; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getPhoneToDelete() { return phoneToDelete; }

    public void setPhoneToDelete(String phoneToDelete) { this.phoneToDelete = phoneToDelete; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public Integer getStatusId() { return statusId; }

    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getPaymentDetails() { return paymentDetails; }

    public void setPaymentDetails(String paymentDetails) { this.paymentDetails = paymentDetails; }

    public String getIp() { return ip; }

    public void setIp(String ip) { this.ip = ip; }

    public BigDecimal getUndiscountedTotalPrice() { return undiscountedTotalPrice; }

    public void setUndiscountedTotalPrice(BigDecimal undiscountedTotalPrice) { this.undiscountedTotalPrice = undiscountedTotalPrice; }

    public BigDecimal getTotalPrice() { return totalPrice; }

    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public Boolean getSeparateDelivery() { return separateDelivery; }

    public void setSeparateDelivery(Boolean separateDelivery) { this.separateDelivery = separateDelivery; }

    public Timestamp getModified() { return modified; }

    public void setModified(Timestamp modified) { this.modified = modified; }

    public Integer getLangId() { return langId; }

    public void setLangId(Integer langId) { this.langId = langId; }

    public RefererChannel getRefererChannel() { return refererChannel; }

    public void setRefererChannel(RefererChannel refererChannel) { this.refererChannel = refererChannel; }

    public String getRefererSource() { return refererSource; }

    public void setRefererSource(String refererSource) { this.refererSource = refererSource; }
}

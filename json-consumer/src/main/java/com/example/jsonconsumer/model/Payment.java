package com.example.jsonconsumer.model;

import java.io.Serializable;

public class Payment implements Serializable {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

}

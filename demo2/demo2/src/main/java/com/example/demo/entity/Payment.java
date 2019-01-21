package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Table(name ="Payment")
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล

public class Payment {
    @SequenceGenerator(name="Payment_seq",sequenceName="Payment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Payment_seq")
    @Column(name="Payment_ID")
    @Id private @NonNull Long Payment_id;
    private  int Payment_total;






    public Long getPayment_id() {
        return Payment_id;
    }

    public void setPayment_id(Long Payment_id) {
        this.Payment_id = Payment_id;
    }


    public int getPayment_total() {
        return Payment_total;
    }
    public void setPayment_total(int Payment_total) {
        this.Payment_total = Payment_total;
    }



    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Reservation.class)
    @JoinColumn(name = "Reservation_ID", insertable = true)
    private  Reservation reservation;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Employee_ID", insertable = true)
    private Member member;

    public void setCard(Card card) {
        this.card = card;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Card.class)
    @JoinColumn(name = "Card_ID", insertable = true)
    private  Card card;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Cardtype.class)
    @JoinColumn(name = "Cardtype", insertable = true)
    private  Cardtype cardtype;

    public Cardbank getCardbank() {
        return cardbank;
    }

    public void setCardbank(Cardbank cardbank) {
        this.cardbank = cardbank;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Cardbank.class)
    @JoinColumn(name = "Cardbank", insertable = true)
    private  Cardbank cardbank;



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Cardtype getCardtype() {
        return cardtype;
    }

    public void setCardtype(Cardtype cardtype) {
        this.cardtype = cardtype;
    }





    public Payment() {
    }
    public Payment(int Payment_total, Member member, Card card, Reservation reservation, Cardtype cardtype, Cardbank cardbank)
    {  //constructor

        this.Payment_total = Payment_total;
        this.member = member;
        this.card = card;
        this.reservation = reservation;
        this.cardtype = cardtype;
        this.cardbank = cardbank;
    }
}

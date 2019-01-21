package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Card")
public class Card {
    @Id
    @SequenceGenerator(name="card_seq",sequenceName="card_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="card_seq")
    @Column(name="id",unique = true, nullable = false)
    private @NonNull Long id;
    private  String card_id;
    private   Integer Card_cvv;
    private   String Card_exp;
    private   String Card_name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public void setCard_exp(String card_exp) {
        this.Card_exp = card_exp;
    }

    public Integer getCard_cvv() {
        return Card_cvv;
    }

    public void setCard_cvv(Integer Card_cvv) {
        this.Card_cvv = Card_cvv;
    }

    public String getCard_exp() {
        return Card_exp;
    }

    public void setPrice(String Card_exp) {
        this.Card_exp = Card_exp;
    }

    public String getCard_name() {
        return Card_name;
    }

    public void setCard_name(String Card_name) {
        this.Card_name = Card_name;
    }

    //@OneToMany(
           // fetch = FetchType.EAGER,
            //mappedBy = "card",
           // cascade = CascadeType.ALL)
   // @Fetch(value = FetchMode.SUBSELECT)
   // private List<Payment> payment = new ArrayList<>();


    public Card(){}
    public Card(String card_id, Integer Card_cvv,String Card_exp, String Card_name ) {  //constructor
        this.card_id = card_id;
        this.Card_cvv = Card_cvv;
        this.Card_exp = Card_exp;
        this.Card_name = Card_name;


    }
}

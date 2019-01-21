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
@Table(name ="Reservation")
public class Reservation {
    public Long getReservation_id() {
        return Reservation_id;
    }

    //@Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Reservation_seq",sequenceName="Reservation_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Reservation_seq")
    @Column(name = "Reservation_ID")
    @Id private @NonNull Long Reservation_id;



    public Long Reservation_id() {
        return Reservation_id;
    }

    public void Reservation_id(Long Reservation_id) {
        this.Reservation_id = Reservation_id;
    }


    public Reservation(){}


}

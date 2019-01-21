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
@Table(name ="Member" +
        "")
public class Member {
    //@Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Employee_seq",sequenceName="Employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Employee_seq")
    @Column(name = "Employee_ID")
    @Id private @NonNull Long Employee_id;
    private String Employee_name;


    public Long Employee_id() {
        return Employee_id;
    }

    public void Employee_id(Long Employee_id) {
        this.Employee_id = Employee_id;
    }

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String Employee_name) {
        this.Employee_name = Employee_name;
    }







    public Member(){}
    public Member(String Employee_name) {  //constructor
        this.Employee_name = Employee_name;

    }


}

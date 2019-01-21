package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class controllerall {
    @Autowired private Cardrepository cardrepository;
    @Autowired private Memberrepository memberrepository;
    @Autowired private Paymentrepository paymentrepository;
    @Autowired private Reservationrepository reservationrepository;
    @Autowired private Cardtyperepository cardtyperepository;
    @Autowired private Cardbankrepository cardbankrepository;


    @GetMapping(path = "/Card")
    public Collection<Card> cardrepository() {
        return cardrepository.findAll().stream().collect(Collectors.toList());

    }
    @GetMapping(path = "/Reservation")
    public Collection<Reservation> reservationrepository() {
        return reservationrepository.findAll().stream().collect(Collectors.toList());


    }@GetMapping(path = "/Employees")
    public Collection<Member> employeerepository() {
        return memberrepository.findAll().stream().collect(Collectors.toList());


    }@GetMapping(path = "/Payment")
    public Collection<Payment> paymentrepository() {
        return paymentrepository.findAll().stream().collect(Collectors.toList());


    }@GetMapping(path = "/Cardtype")
    public Collection<Cardtype> cardtyperepository() {
        return cardtyperepository.findAll().stream().collect(Collectors.toList());

    }

    @GetMapping(path = "/Cardbank")
    public Collection<Cardbank> cardbankrepository() {
    return cardbankrepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/payment/{card_cvv}/{card_exp}/{card_name}/{card_id}/{payment_total}/{emp}/{rent}/{cardbank}/{card_type}")
    public Payment payment(@PathVariable int card_cvv ,@PathVariable String card_exp ,@PathVariable String card_name
            ,@PathVariable long card_type,@PathVariable String card_id,@PathVariable int payment_total,
                           @PathVariable Long emp,@PathVariable Long rent,@PathVariable Long cardbank ){


        Card card = new Card();
        card.setCard_cvv(card_cvv);
        card.setCard_exp(card_exp);
        card.setCard_name(card_name);
        card.setCard_id(card_id);
        cardrepository.save(card);


        Cardtype cardtype = cardtyperepository.findById(card_type).get();
        Cardbank cardbank1 = cardbankrepository.findById(cardbank).get();
        Member member1 = memberrepository.findById(emp).get();
        Reservation rent1 = reservationrepository.findById(rent).get();


        Payment payment = new Payment();
        payment.setPayment_total(payment_total);
        payment.setMember(member1);
        payment.setReservation(rent1);
        payment.setCardtype(cardtype);
        payment.setCard(card);
        payment.setCardbank(cardbank1);
        paymentrepository.save(payment);

        return  payment;
    }

}

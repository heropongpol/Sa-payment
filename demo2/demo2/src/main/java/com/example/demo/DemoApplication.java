package com.example.demo;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(Cardrepository cardrepository, Memberrepository memberrepository,
                           Reservationrepository reservationrepository, Paymentrepository paymentrepository ,Cardtyperepository cardtyperepository ,Cardbankrepository cardbankrepository) {
        return args -> {
          Card c1 = new Card();
           cardrepository.save(c1);


            Reservation r1 = new Reservation();
            reservationrepository.save(r1);

            Member e1 = new Member();
            memberrepository.save(e1);

            Cardtype ct1 = new Cardtype("Visa");
            Cardtype ct2 = new Cardtype("Mastercard");
            Cardtype ct3 = new Cardtype("JCB");
            Cardtype ct4 = new Cardtype("UnionPay");
            cardtyperepository.save(ct1);
            cardtyperepository.save(ct2);
            cardtyperepository.save(ct3);
            cardtyperepository.save(ct4);


            Cardbank cb1 = new Cardbank("กรุงไทย");
            Cardbank cb2 = new Cardbank("ไทยพาณิชย์");
            Cardbank cb3 = new Cardbank("กรุงเทพ");
            Cardbank cb4 = new Cardbank("กสิกรไทย");
            Cardbank cb5 = new Cardbank("กรุงศรีอยุธยา");
            cardbankrepository.save(cb1);
            cardbankrepository.save(cb2);
            cardbankrepository.save(cb3);
            cardbankrepository.save(cb4);
            cardbankrepository.save(cb5);

            Payment p1 = new Payment();
            paymentrepository.save(p1);




        };
    }
}
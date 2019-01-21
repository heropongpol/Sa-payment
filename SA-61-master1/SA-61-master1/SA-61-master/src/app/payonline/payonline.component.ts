import { Component, OnInit } from '@angular/core';
import { Controllerall } from '../controller/controllerall';

import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-payonline',
  templateUrl: './payonline.component.html',
  styleUrls: ['./payonline.component.css']
})
export class PayonlineComponent implements OnInit {

private card_id:string;
private card_cvv:number;
private card_exp:string;
private card_name:string;
private card_bank:string;
private payment_total:number;
  cardtypes: Array<any>;
  rents: Array<any>;
  emps: Array<any>;
  cbs: Array<any>;
  rentSelect = '';
  cardSelect = '';
  cardbankSelect ='';
  empSelect = '';

  constructor(private controller: Controllerall,
 private httpClient: HttpClient


  ) { }

  ngOnInit() {
  this.controller.getReservation_id().subscribe(data => {
        this.rents = data;
        console.log(this.rents);
      })
this.controller.getEmployee().subscribe(data => {
        this.emps = data;
        console.log(this.emps);
      })
this.controller.getCardtype().subscribe(data => {
        this.cardtypes = data;
        console.log(this.cardtypes);
      })
this.controller.getCardbank().subscribe(data => {
        this.cbs = data;
        console.log(this.cbs);
      })
      ;


            }
           insert() {

       if (this.card_cvv == null || this.card_exp == null|| this.card_name == null|| this.cardbankSelect == null ||
        this.cardSelect == null || this.card_id == null|| this.card_exp == null|| this.rentSelect == null|| this.empSelect == null) {
              alert('กรุณากรอกข้อมูลให้ครบ');

        }
        else{
           this.httpClient.post('http://localhost:3000/payment/'+this.card_cvv +'/'+this.card_exp +'/'+this.card_name+'/'+this.card_id+'/'+this.payment_total+'/'+this.empSelect+'/'+this.rentSelect+'/'+this.cardbankSelect+'/'+this.cardSelect  ,{})
           .subscribe(

              data => {
                console.log('PUT Request is successful', data);
              },
              error => {
                console.log('Error', error);
              }

           );
                  alert('สำเร็จ');
        }
      }






}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Controllerall {
  public API = '//localhost:3020';

  constructor(private http: HttpClient) { }

  getReservation_id(): Observable<any> {
      return this.http.get(this.API + '/Reservation');
    }
getEmployee(): Observable<any> {
      return this.http.get(this.API + '/Employees');
    }

getCardtype(): Observable<any> {
      return this.http.get(this.API + '/Cardtype');
    }

getCardbank(): Observable<any> {
      return this.http.get(this.API + '/Cardbank');
    }


}

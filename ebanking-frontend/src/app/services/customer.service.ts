import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, BehaviorSubject } from "rxjs";
import { tap } from "rxjs/operators";
import { Customer } from "../model/customer.model";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customersSubject = new BehaviorSubject<Customer[]>([]);
  public customers$ = this.customersSubject.asObservable();

  constructor(private http: HttpClient) { 
    this.loadCustomers(); // load initial list
  }

  public loadCustomers() {
    this.http.get<Customer[]>(environment.backendHost + "/customers")
      .subscribe(data => this.customersSubject.next(data));
  }

  public searchCustomers(keyword: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(environment.backendHost + "/customers/search?keyword=" + keyword)
      .pipe(
        tap(data => this.customersSubject.next(data)) // update the list after search
      );
  }

  public saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(environment.backendHost + "/customers", customer)
      .pipe(
        tap(() => this.loadCustomers()) // refresh list after adding
      );
  }

  public deleteCustomer(id: number) {
    return this.http.delete(environment.backendHost + "/customers/" + id)
      .pipe(
        tap(() => this.loadCustomers()) // refresh list after deleting
      );
  }
}

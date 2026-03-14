import { Component, OnInit } from '@angular/core';
import { CustomerService } from "../services/customer.service";
import { catchError, Observable, throwError } from "rxjs";
import { Customer } from "../model/customer.model";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers!: Observable<Customer[]>;  // use observable from service
  errorMessage!: string;
  searchFormGroup!: FormGroup;

  constructor(
    private customerService: CustomerService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control("")
    });

    // subscribe to the BehaviorSubject from service
    this.customers = this.customerService.customers$;
  }

  handleSearchCustomers() {
    const kw = this.searchFormGroup.value.keyword;
    if (!kw) {
      this.customerService.loadCustomers(); // if keyword empty, load all
      return;
    }
    this.customerService.searchCustomers(kw).subscribe({
      error: err => this.errorMessage = err.message
    });
  }

  handleDeleteCustomer(c: Customer) {
    if (!confirm("Are you sure?")) return;
    this.customerService.deleteCustomer(c.id).subscribe({
      error: err => console.error(err)
    });
  }

  handleCustomerAccounts(customer: Customer) {
    this.router.navigateByUrl("/customer-accounts/" + customer.id, { state: customer });
  }
}

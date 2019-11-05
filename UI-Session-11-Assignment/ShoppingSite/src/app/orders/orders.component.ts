import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { OrderDetails } from '../order-details';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(private service : ShoppingService ) {}

  orders : OrderDetails[] = [];
  orderDate : Date;

  ngOnInit() {
    this.orders = this.service.getAllOrder();
  }

}

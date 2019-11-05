import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { Item } from '../item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartCount : number;
  itemsArr : Item[] = [];
  constructor(private service : ShoppingService, private router : Router) { }

  ngOnInit() {
    this.itemsArr = this.service.getAllItems();
    this.cartCount = this.service.cartCount;
  }

  /**
   * To clear the cart.
   */
  reset() {
    this.service.reset();
    this.cartCount = this.service.cartCount;
  }

  /**
   * To decrement count of an item in cart.
   * @param itemId 
   */
  decrementItem(itemId) {
    this.service.decrementItem(itemId);
    this.cartCount = this.service.cartCount;

  }

  /**
   * To increment count of an item in cart.
   * @param itemId 
   */
  incrementItem(itemId) {
    this.service.incrementItem(itemId);
    this.cartCount = this.service.cartCount;
  }

  /**
   * To navigate to checkout
   */
  goToCheckOut() {
    this.router.navigate(['/checkOut']);
  }

}

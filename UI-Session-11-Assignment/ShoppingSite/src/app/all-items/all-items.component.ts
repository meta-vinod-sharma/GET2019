import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ShoppingService } from '../shopping.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NavComponent } from '../nav/nav.component';

@Component({
  selector: 'app-all-items',
  templateUrl: './all-items.component.html',
  styleUrls: ['./all-items.component.css']
})
export class AllItemsComponent implements OnInit {

  itemsArr : Item[];
  cartCount : number;
  obj : any;

  constructor(private service : ShoppingService, private router : Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
  
    var category = this.activatedRoute.snapshot.paramMap.get("category");
    this.itemsArr = this.service.getAllItems();
    
    if (category == "All") {
        return;
    }  
     this.itemsArr = this.itemsArr.filter(item => item.category == category);
   
  }

  /**
   * To get items of particular category. 
   * @param category 
   */
  getItems(category) {
    this.itemsArr = this.service.getAllItems();
    if (category == "All") {
      return this.itemsArr;
    }  
    this.itemsArr = this.itemsArr.filter(item => item.category == category);
    return this.itemsArr;
  }

  /**
   * To add an item to cart.
   * @param itemId 
   */
  AddToCart(itemId) {
    this.cartCount = this.service.addToCart(itemId);
    
  }

  /**
   * To increment count of an item in cart.
   * @param itemId 
   */
  incrementItem(itemId) {
    this.cartCount = this.service.incrementItem(itemId);

  }

  /**
   * To decrement count of an item in cart.
   * @param itemId 
   */
  decrementItem(itemId) {
    this.cartCount = this.service.decrementItem(itemId);
  }

}

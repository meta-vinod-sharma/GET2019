  import { Component, OnInit } from '@angular/core';
import { ShoppingService } from '../shopping.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  cartCount : number;
  constructor(private service : ShoppingService, private router : Router) { }

  ngOnInit() {
  this.router.navigate(['/all-items', 'All']);
  this.cartCount = this.service.cartCount;
  }

  goToCart() {
    this.router.navigate(['/cart']);
    this.cartCount = this.service.cartCount;

  }
}

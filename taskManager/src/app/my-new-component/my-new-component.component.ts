import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-new-component',
  templateUrl: './my-new-component.component.html',
  styleUrls: ['./my-new-component.component.css']
})
export class MyNewComponentComponent implements OnInit {


  constructor(private router:Router) { }

  ngOnInit() {
  }
   gotoAddTask(){
    this.router.navigate(['/add-task']); 
   }
   gotoViewTask(){
     this.router.navigate(['/task-Tracker']);
   }
}

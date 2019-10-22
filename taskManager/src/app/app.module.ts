import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{Routes, RouterModule} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MyNewComponentComponent } from './my-new-component/my-new-component.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { TaskTrackerComponent } from './task-tracker/task-tracker.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TaskModelComponent } from './task-model/task-model.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { TaskDetailsComponent } from './task-details/task-details.component';


@NgModule({
  declarations: [
    AppComponent,
    MyNewComponentComponent,
    AddTaskComponent,
    TaskTrackerComponent,
    TaskModelComponent,
    EditTaskComponent,
    TaskDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

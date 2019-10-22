import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyNewComponentComponent } from './my-new-component/my-new-component.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { AppComponent } from './app.component';
import { TaskTrackerComponent } from './task-tracker/task-tracker.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { TaskDetailsComponent } from './task-details/task-details.component';

const routes: Routes = [
  { path: 'add-task', component: AddTaskComponent },
  { path: 'app-component', component: AppComponent },
  {path:'my-new-component',component:MyNewComponentComponent},
  { path: 'task-Tracker', component: TaskTrackerComponent },
{path:'edit-task/:date',component: EditTaskComponent},
{path:'task-details/:date',component:TaskDetailsComponent} ];
  
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

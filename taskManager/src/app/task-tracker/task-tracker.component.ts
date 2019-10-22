import { Component, OnInit } from '@angular/core';
import { TaskModelService } from '../task-model/task-model.service';

@Component({
  selector: 'app-task-tracker',
  templateUrl: './task-tracker.component.html',
  styleUrls: ['./task-tracker.component.css']
})
export class TaskTrackerComponent implements OnInit {
  taskList:any;
  constructor(private taskService: TaskModelService) { }

  ngOnInit() {
    this.taskList = this.taskService.getAllTasks();
  }

}

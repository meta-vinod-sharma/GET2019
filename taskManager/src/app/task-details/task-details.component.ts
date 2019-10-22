import { Component, OnInit } from '@angular/core';
import { Task } from '../task-model/task-model';
import { TaskModelService } from '../task-model/task-model.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  tempTask: Task;
  cd: Date;
  compD: Date;


  constructor(private taskService: TaskModelService,
    private router: Router, private activatedRoute: ActivatedRoute) {

  }

  deleteTask() {
    this.taskService.deleteTask(this.tempTask);
    this.router.navigate(['/task-Tracker'])
  }

  ngOnInit() {
    this.taskService.taskList.forEach((t: Task) => {
      if (String(t.taskCreationDate) == (this.activatedRoute.snapshot.paramMap.get("date"))) {
        this.tempTask = t;
        this.cd = new Date(Number(this.tempTask.taskCreationDate));
        if (this.tempTask.taskCompleteDate == null) {

        }
        else {
          this.compD = new Date(Number(this.tempTask.taskCompleteDate));
        }

      }
    });

  }

}

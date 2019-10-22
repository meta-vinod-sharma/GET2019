import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Task } from '../task-model/task-model';
import { TaskModelService } from '../task-model/task-model.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
  taskEditForm: FormGroup;
  submitted = false;
  taskModel: Task;
  toEditTask: Task;
  taskCompleteDate: any;
  constructor(private fb: FormBuilder, private taskService: TaskModelService, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    var date = this.activatedRoute.snapshot.paramMap.get("date");
    var task = this.taskService.taskList;
    for (var i = 0; i < task.length; i++) {
      if (String(task[i].taskCreationDate) == date) {
        this.toEditTask = task[i];
      }
    }
    this.taskEditForm = this.fb.group({
      taskTitle: ['', Validators.required],
      taskDescription: ['', Validators.required],
      taskPriority: [''],
      taskStatus: ['']
    });
  }

  get fval() {
    return this.taskEditForm.controls;
  }

  save() {
    this.taskService.updateTask(this.taskModel);
  }

  signup() {
    this.submitted = true;
    if (this.taskEditForm.invalid) {
      return;
    }

    if (this.taskEditForm.value.taskStatus == "Completed") {
      this.taskCompleteDate = Date.now();
    }

    this.taskModel = new Task(this.taskEditForm.value.taskTitle,
      this.taskEditForm.value.taskDescription,
      this.taskEditForm.value.taskPriority,
      this.taskEditForm.value.taskStatus,
      this.toEditTask.taskCreationDate,
      this.taskCompleteDate);
    this.save();
    this.router.navigate(['/task-Tracker'])
  }

  deleteTask() {
    this.taskService.deleteTask(this.toEditTask);
    this.router.navigate(['/task-Tracker'])
  }
}

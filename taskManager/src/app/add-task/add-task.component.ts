import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskModelService } from '../task-model/task-model.service';
import { Task } from '../task-model/task-model';
import { from } from 'rxjs';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {
  taskForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private taskService: TaskModelService) { }
  ngOnInit() {
    this.taskForm = this.formBuilder.group({
      taskTitle: ['', Validators.required],
      taskDescription: ['', Validators.required],
      taskPriority: ['', Validators.required]
    });
  }
  get fval() {
    return this.taskForm.controls;
  }
  save(taskModel) {
    this.taskService.createTask(taskModel);
  }


  submitForm() {
    this.submitted = true;
    if (this.taskForm.invalid) {
      return;
    }
    var taskModel = new Task(this.taskForm.value.taskTitle,
      this.taskForm.value.taskDescription,
      this.taskForm.value.taskPriority,
      "New", Date.now(), null);
    this.save(taskModel);
    this.router.navigate(['/task-Tracker']);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Task } from './task-model';

@Injectable({
    providedIn: 'root'
})
export class TaskModelService {

    taskList: Task[] = [];
    task1: Task;

    constructor() { }

    getAllTasks() {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                console.log(key, localStorage.getItem(String(key)));
                this.taskList.push(this.stringToTask(localStorage.getItem(String(key))));
            }
        }
       return this.taskList;
    }

    stringToTask(str: string) {
        var tempStr = str.split(",");
        if (tempStr[5] == "null") {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], null);
        }
        else {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], tempStr[5]);
        }
        return this.task1;
    }

    taskToString(task: Task) {
        var tTs = task.taskTitle + ','
            + task.taskDescription + ',' + task.taskPriority
            + ',' + task.taskStatus + ',' + task.taskCreationDate
            + ',' + task.taskCompleteDate;

        return tTs;
    }

    //Create Task
    createTask(task: Task) {
        alert("create task");
        var taskIntoString = this.taskToString(task);
        localStorage.setItem(String(task.taskCreationDate), taskIntoString);
        console.log(task.taskCreationDate);
    }

    //Update task
    updateTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (key == String(task.taskCreationDate)) {
                    console.log(task.taskStatus);
                    localStorage.setItem(String(key), this.taskToString(task));
                }
            }
        }
    }
    //Delete task	
    deleteTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (key == String(task.taskCreationDate)) {
                    localStorage.removeItem(String(key));
                }
            }
        }
    }
    private handleError(error: any) {
        console.error(error);
        return throwError(error);
    }
} 
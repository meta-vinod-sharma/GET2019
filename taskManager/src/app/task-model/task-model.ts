export class Task {
    taskTitle: string;
    taskDescription: string;
    taskPriority: string;
    taskStatus: string;
    taskCreationDate: Date;
    taskCompleteDate: Date;
    
    constructor(taskTitle, taskDescription, taskPriority, taskStatus, taskCreationDate, taskCompleteDate){
    this.taskTitle = taskTitle;
    this.taskDescription = taskDescription;
    this.taskPriority = taskPriority;
    this.taskStatus = taskStatus;
    this.taskCreationDate = taskCreationDate;
    this.taskCompleteDate = taskCompleteDate;
    }
    }
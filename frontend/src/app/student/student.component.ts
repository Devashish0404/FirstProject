import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [FormsModule, HttpClientModule, ReactiveFormsModule, CommonModule],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css',
  inputs: ['ngModel'],
})
export class StudentComponent {
  StudentArray: any[] = [];
  studentname: string = '';
  studentaddress: string = '';
  mobile: number = 0;
  currentStudentID = '';

  constructor(private http: HttpClient) {
    this.getAll();
  }

  register() {
    let bodyData = {
      studentname: this.studentname,
      studentaddress: this.studentaddress,
      mobile: this.mobile,
    };
    this.http
      .post('http://localhost:8089/api/v1/student/save', bodyData, {
        responseType: 'text',
      })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('Student Registered Successfully');
        this.getAll();
        this.studentname = '';
        this.studentaddress = '';
        this.mobile = 0;
      });
  }

  getAll() {
    this.http
      .get('http://localhost:8089/api/v1/student/getall')
      .subscribe((resultData: any) => {
        console.log(resultData);
        this.StudentArray = resultData;
      });
  }

  setUpdate(data: any) {
    this.studentname = data.studentname;
    this.studentaddress = data.studentaddress;
    this.mobile = data.mobile;
    this.currentStudentID = data._id;
    alert(data._id);
  }

  UpdateRecords() {
    let bodyData = {
      studentname: this.studentname,
      studentaddress: this.studentaddress,
      mobile: this.mobile,
    };

    this.http
      .put(
        'http://localhost:8089/api/v1/student/edit' +
          '/' +
          this.currentStudentID,
        bodyData,
        { responseType: 'text' }
      )
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('Student Registered Updated');
        this.getAll();

        this.studentname = '';
        this.studentaddress = '';
        this.mobile = 0;
      });
  }

  save() {
    if (this.currentStudentID == '') {
      this.register();
    } else {
      this.UpdateRecords();
    }
  }

  setDelete(data: any) {
    this.http
      .delete('http://localhost:8089/api/v1/student/delete' + '/' + data._id, {
        responseType: 'text',
      })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('Student Deletedddd');
        this.getAll();

        this.studentname = '';
        this.studentaddress = '';
        this.mobile = 0;
      });
  }
}

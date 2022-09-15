import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  primerapellido : string;
  primernombre : string;

  constructor() {
    let obj = JSON.parse(localStorage.getItem('user') || '{}');
    this.primerapellido = obj.primerApellido;
    this.primernombre = obj.primerNombre;
    
   }

  ngOnInit(): void {
    
  }

}

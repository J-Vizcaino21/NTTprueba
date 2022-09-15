import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators, FormControl, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/services/user-service.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  
  form: FormGroup = new FormGroup({
    tipodoc: new FormControl(''),
    doc: new FormControl('')
  });
  submitted = false;

  constructor(private fb: FormBuilder, private rest: UserServiceService, private router: Router) { 
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {
        type: ['', Validators.required],
        document: [
          '',
          Validators.compose([
            Validators.required,
            Validators.min(10000000),
            Validators.max(99999999999),
          ])
        ]
      }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }
    this.rest.getConfig(this.form.value)
      .subscribe(response => {
        if(response!= null && response != undefined){
          localStorage.setItem('user',JSON.stringify(response))
          this.router.navigateByUrl('user')
        }else{
          swal.fire("Ups!", "User no encontrado", "error");
        }
        
      }
    );
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }

}

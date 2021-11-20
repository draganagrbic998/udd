import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { FormConfig } from 'src/app/utils/form-config';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  constructor(
    private formService: FormService
  ) { }

  form: FormGroup;
  @Input() title: string;
  @Input() config: FormConfig;
  @Input() pending: boolean;
  @Output() submit = new EventEmitter();

  get controls() {
    return Object.keys(this.config);
  }

  capitalize(text: string) {
    return text[0].toUpperCase() + text.substr(1);
  }

  type(control: string) {
    return this.config[control].type;
  }

  handleSubmit() {
    if (!this.form.valid) {
      return;
    }
    this.submit.emit(this.form.value);
  }

  ngOnInit() {
    this.form = this.formService.build(this.config);
  }

}

import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { FormConfig } from 'src/app/utils/form-config';

@Component({
  selector: 'app-query-search',
  templateUrl: './query-search.component.html'
})
export class QuerySearchComponent implements OnInit {

  constructor(
    private formService: FormService
  ) { }

  @Input() pending: boolean;
  @Input() second: boolean;
  form: FormGroup;
  config: FormConfig = {
    field: {
      validation: 'required'
    },
    value: {
      validation: 'required'
    },
  }

  ngOnInit() {
    if (this.second) {
      this.config.operation = {
        validation: 'required'
      }
    }
    this.form = this.formService.build(this.config);
  }

}
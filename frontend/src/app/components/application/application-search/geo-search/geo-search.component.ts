import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ApplicationGeoSearch } from 'src/app/models/application';
import { FormConfig } from 'src/app/utils/form-config';

@Component({
  selector: 'app-geo-search',
  template: `<app-form title="Geo Search" [config]="config" [pending]="pending" (submit)="search.emit($event)"></app-form>`
})
export class GeoSearchComponent {

  @Input() pending: boolean;
  config: FormConfig = {
    location: {
      type: 'location',
      validation: 'required'
    },
    distance: {
      type: 'text',
      validation: 'required'
    },
    unit: {
      type: 'text',
      validation: 'required'
    }
  }
  @Output() search = new EventEmitter<ApplicationGeoSearch>();

}

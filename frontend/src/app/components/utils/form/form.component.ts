import { AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { FormConfig } from 'src/app/utils/form-config';
import places, { PlacesInstance } from 'places.js';
import { ALGOLIA_API_ID, ALGOLIA_API_KEY } from 'src/app/utils/algolia';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit, AfterViewInit {

  constructor(
    private formService: FormService
  ) { }

  form: FormGroup;
  @Input() title: string;
  @Input() config: FormConfig;
  @Input() pending: boolean;
  @Output() submit = new EventEmitter();

  @ViewChild('locationInput') locationInput: ElementRef<HTMLInputElement>;
  locationAutocomplete: PlacesInstance;
  location: { lat: number, lng: number };

  get controls() {
    return Object.keys(this.config).filter(control => this.config[control].type !== 'file')
  }

  get fileControls() {
    return Object.keys(this.config).filter(control => this.config[control].type === 'file')
  }

  capitalize(text: string) {
    return text[0].toUpperCase() + text.substr(1);
  }

  type(control: string) {
    return this.config[control].type;
  }

  fileStatus(control: string) {
    if (this.form.value[control]) {
      return `${this.capitalize(control)} file provided`
    }
    return `No ${this.capitalize(control)} file provided`
  }

  handleSubmit() {
    // ne radi mi validacija
    if (this.form.invalid) {
      return;
    }
    this.submit.emit({ ...this.form.value, lat: this.location?.lat, lng: this.location?.lng });
  }

  updateFile(control: string, file: Blob) {
    this.form.get(control).setValue(file);
  }

  ngOnInit() {
    this.form = this.formService.build(this.config);
  }

  ngAfterViewInit() {
    if (!this.locationInput) {
      return;
    }
    this.locationAutocomplete = places({
      container: this.locationInput.nativeElement,
      appId: ALGOLIA_API_ID,
      apiKey: ALGOLIA_API_KEY
    });

    this.locationAutocomplete.on('change', event => {
      this.location = event.suggestion.latlng;
      /*this.geolocation.lat = event.suggestion.latlng.lat;
      this.geolocation.lng = event.suggestion.latlng.lng;
      this.culturalForm.get('location').setValue(event.suggestion.value);
      this.culturalForm.get('location').updateValueAndValidity();*/
      console.log(event.suggestion.latlng);
    });
  }

}

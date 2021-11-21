import { AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { FormConfig, FormStyle } from 'src/app/utils/form';
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

  @Input() title: string;
  @Input() config: FormConfig;
  @Input() pending: boolean;
  @Input() style: FormStyle;
  @Output() submit = new EventEmitter();
  form: FormGroup;

  @ViewChild('locationInput') locationInput: ElementRef<HTMLInputElement>;
  locationAutocomplete: PlacesInstance;
  location: { lat: number, lng: number };

  get controls() {
    return Object.keys(this.config).filter(control => this.config[control].type !== 'file')
  }

  get fileControls() {
    return Object.keys(this.config).filter(control => this.config[control].type === 'file')
  }

  ngOnInit() {
    this.form = this.formService.build(this.config);
  }

  ngAfterViewInit() {
    if (this.locationInput) {
      this.locationAutocomplete = places({
        container: this.locationInput.nativeElement,
        apiKey: ALGOLIA_API_KEY,
        appId: ALGOLIA_API_ID
      });

      this.locationAutocomplete.on('change', event => this.location = event.suggestion.latlng);
    }
  }

  type(control: string) {
    return this.config[control].type || 'text'
  }

  options(control: string) {
    return this.config[control].options || []
  }

  handleSubmit() {
    if (this.form.invalid) {
      this.form.markAsTouched();
      return;
    }
    this.submit.emit({ ...this.form.value, lat: this.location?.lat, lng: this.location?.lng });
  }

  capitalize(text: string) {
    text = text.replace(/([a-z])([A-Z])/g, '$1 $2');
    return text[0].toUpperCase() + text.substr(1).toLowerCase();
  }

  updateFile(control: string, file: Blob) {
    this.form.get(control).setValue(file);
  }

}

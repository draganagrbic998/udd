import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplicationUpload } from 'src/app/models/application';
import { ApplicationService } from 'src/app/services/application.service';
import { FormConfig } from 'src/app/utils/form-config';
import { SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_CONFIG, SNACKBAR_ERROR_TEXT, SNACKBAR_SUCCESS_CONFIG, SNACKBAR_SUCCESS_TEXT } from 'src/app/utils/popup';
import { Routes } from 'src/app/utils/routes';

@Component({
  selector: 'app-application-upload',
  template: `<app-form title="Upload Application" [config]="config" [pending]="pending" (submit)="upload($event)"></app-form>`
})
export class ApplicationUploadComponent {

  constructor(
    private applicationService: ApplicationService,
    private router: Router,
    private route: ActivatedRoute,
    private snackbar: MatSnackBar,
  ) { }

  pending = false;
  config: FormConfig = {
    firstName: {
      type: 'text',
      validation: 'required'
    },
    lastName: {
      type: 'text',
      validation: 'required'
    },
    email: {
      type: 'text',
      validation: 'required'
    },
    address: {
      type: 'location',
      validation: 'required'
    },
    education: {
      type: 'text',
      validation: 'required'
    },
    cvFile: {
      type: 'file',
      validation: 'required'
    },
    letterFile: {
      type: 'file',
      validation: 'required'
    }
  }

  async upload(upload: ApplicationUpload) {
    upload.advertisementId = +this.route.snapshot.params.advertisementId
    this.pending = true;
    try {
      await this.applicationService.upload(upload).toPromise();
      this.pending = false;
      this.snackbar.open(SNACKBAR_SUCCESS_TEXT, SNACKBAR_CLOSE_BUTTON, SNACKBAR_SUCCESS_CONFIG);
      this.router.navigate([Routes.ADVERTISEMENTS]);
    }
    catch {
      this.pending = false;
      this.snackbar.open(SNACKBAR_ERROR_TEXT, SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_CONFIG);
    }
  }

}

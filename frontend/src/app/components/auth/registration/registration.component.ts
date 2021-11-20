import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Auth } from 'src/app/models/auth';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';
import { FormConfig } from 'src/app/utils/form-config';
import { SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_CONFIG, SNACKBAR_ERROR_TEXT } from 'src/app/utils/popup';
import { Routes } from 'src/app/utils/routes';

@Component({
  selector: 'app-registration',
  template: `<app-form title="Registration" [config]="config" [pending]="pending" (submit)="register($event)"></app-form>`
})
export class RegistrationComponent {

  constructor(
    private authService: AuthService,
    private storageService: StorageService,
    private router: Router,
    private snackbar: MatSnackBar,
  ) { }

  pending = false;
  config: FormConfig = {
    email: {
      type: 'text',
      validation: 'required'
    },
    password: {
      type: 'text',
      validation: 'required'
    }
  }

  async register(auth: Auth) {
    this.pending = true;

    try {
      const res = await this.authService.register(auth).toPromise();
      this.pending = false;
      this.storageService.setAuth(res);
      this.router.navigate([Routes.ADVERTISEMENTS])
    }
    catch {
      this.pending = false;
      this.snackbar.open(SNACKBAR_ERROR_TEXT, SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_CONFIG);
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Auth } from 'src/app/models/auth';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';
import { FormConfig } from 'src/app/utils/form-config';
import { SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_TEXT, SNACKBAR_ERROR_CONFIG } from 'src/app/utils/popup';
import { Routes } from 'src/app/utils/routes';

@Component({
  selector: 'app-login',
  template: `<app-form title="Log In" [config]="config" [pending]="pending" (submit)="login($event)"></app-form>`
})
export class LoginComponent implements OnInit {

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

  ngOnInit() {
    this.storageService.removeAuth();
  }

  async login(auth: Auth) {
    this.pending = true;

    try {
      const res = await this.authService.login(auth).toPromise();
      this.pending = false;
      this.storageService.setAuth(res);
      if (res.role === 'kandidat') {
        this.router.navigate([Routes.ADVERTISEMENTS])
      } else {
        this.router.navigate([Routes.APPLICATION_SEARCH])
      }
    }
    catch {
      this.pending = false;
      this.snackbar.open(SNACKBAR_ERROR_TEXT, SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_CONFIG);
    }
  }

}

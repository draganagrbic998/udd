import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { FormService } from 'src/app/services/form.service';
import { StorageService } from 'src/app/services/storage.service';
import { SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_TEXT, SNACKBAR_ERROR_CONFIG } from 'src/app/utils/popup';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private formService: FormService,
    private storageService: StorageService,
    private router: Router,
    private snackbar: MatSnackBar,
  ) { }

  pending = false;
  form = this.formService.build({
    email: 'required',
    password: 'required',
  })

  ngOnInit() {
    this.storageService.removeAuth();
  }

  async login() {
    if (!this.form.valid) {
      return;
    }

    this.pending = true;

    try {
      const res = await this.authService.login(this.form.value).toPromise();
      this.pending = false;
      this.storageService.setAuth(res);
      alert(res.role);
    }
    catch {
      this.pending = false;
      this.snackbar.open(SNACKBAR_ERROR_TEXT, SNACKBAR_CLOSE_BUTTON, SNACKBAR_ERROR_CONFIG);
    }
  }

}

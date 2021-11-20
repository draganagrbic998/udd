import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/services/storage.service';
import { Routes } from 'src/app/utils/routes';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  constructor(
    private storageService: StorageService,
    private router: Router
  ) { }

  get auth() {
    return this.router.url.includes(Routes.LOGIN) || this.router.url.includes(Routes.REGISTRATION)
  }

  logout() {
    this.storageService.removeAuth();
    this.router.navigate([Routes.LOGIN]);
  }

}

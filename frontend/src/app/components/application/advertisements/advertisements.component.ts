import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Advertisement } from 'src/app/models/advertisement';
import { AdvertisementsService } from 'src/app/services/advertisements.service';
import { Routes } from 'src/app/utils/routes';

@Component({
  selector: 'app-advertisements',
  templateUrl: './advertisements.component.html',
  styleUrls: ['./advertisements.component.scss']
})
export class AdvertisementsComponent implements OnInit {

  constructor(
    private advertisementsService: AdvertisementsService,
    private router: Router
  ) { }

  advertisements: Advertisement[];

  ngOnInit() {
    this.read();
  }

  uploadApplication(advertisement: Advertisement) {
    this.router.navigate([`${Routes.APPLICATION_UPLOAD}/${advertisement.id}`])
  }

  private async read() {
    this.advertisements = await this.advertisementsService.read().toPromise();
  }

}

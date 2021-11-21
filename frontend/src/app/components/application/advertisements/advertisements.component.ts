import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Advertisement } from 'src/app/models/advertisement';
import { AdvertisementsService } from 'src/app/services/advertisements.service';
import { Route } from 'src/app/utils/route';

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
    this.router.navigate([`${Route.APPLICATION_UPLOAD}/${advertisement.id}`])
  }

  private async read() {
    this.advertisements = await this.advertisementsService.read().toPromise();
  }

}

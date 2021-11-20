import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Advertisement } from '../models/advertisement';

@Injectable({
  providedIn: 'root'
})
export class AdvertisementsService {

  constructor(
    private http: HttpClient
  ) { }

  private readonly ADVERTISEMENTS_API = `${environment.apiUrl}/advertisements`;

  read() {
    return this.http.get<Advertisement[]>(this.ADVERTISEMENTS_API);
  }

}

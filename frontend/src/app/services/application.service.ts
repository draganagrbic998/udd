import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Application, ApplicationUpload } from '../models/application';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(
    private http: HttpClient
  ) { }

  private readonly APPLICATIONS_API = `${environment.apiUrl}/applications`;

  upload(upload: ApplicationUpload) {
    const data = new FormData();
    for (const field in upload) {
      data.append(field, typeof upload[field] !== 'number' ? upload[field] : upload[field] + '');
    }
    return this.http.post<Application>(this.APPLICATIONS_API, data);
  }

}

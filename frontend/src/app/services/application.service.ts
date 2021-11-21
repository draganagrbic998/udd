import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Application, ApplicationGeoSearch, ApplicationSearch, ApplicationSearchResult, ApplicationUpload } from '../models/application';

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

  downloadFile(cv: boolean, fileName: string) {
    return this.http.get<Blob>(`${this.APPLICATIONS_API}/${cv ? 'cv' : 'letter'}/${fileName}`, { responseType: 'blob' as 'json' });
  }

  search(search: ApplicationSearch) {
    return this.http.post<ApplicationSearchResult[]>(`${this.APPLICATIONS_API}/search`, search);
  }

  geoSearch(search: ApplicationGeoSearch) {
    return this.http.post<ApplicationSearchResult[]>(`${this.APPLICATIONS_API}/geo_search`, search);
  }

}

import { Component, ViewChild } from '@angular/core';
import { QuerySearchComponent } from './query-search/query-search.component';
import { ApplicationService } from 'src/app/services/application.service';
import { ApplicationSearch, ApplicationSearchResult } from 'src/app/models/application';

@Component({
  selector: 'app-application-search',
  templateUrl: './application-search.component.html',
  styleUrls: ['./application-search.component.scss']
})
export class ApplicationSearchComponent {

  constructor(
    private applicationService: ApplicationService
  ) { }

  @ViewChild('query1') query1: QuerySearchComponent;
  @ViewChild('query2') query2: QuerySearchComponent;

  pending = false;
  searchResults: ApplicationSearchResult[];

  async search() {
    if (this.query1.form.invalid) {
      return;
    }
    const search: ApplicationSearch = {
      query1: this.query1.form.value
    }
    if (this.query2.form.valid) {
      search.operation = this.query2.form.value.operation;
      search.query2 = this.query2.form.value;
    }

    this.pending = true;
    try {
      this.searchResults = await this.applicationService.search(search).toPromise();
      this.pending = false;
    } catch {
      this.pending = false;
    }
  }

  async downloadFile(cv: boolean, fileName: string) {
    const res = await this.applicationService.downloadFile(cv, fileName).toPromise();

    const url = window.URL.createObjectURL(res)
    const a = document.createElement('a')
    document.body.appendChild(a)
    a.setAttribute('style', 'display: none')
    a.href = url
    a.download = fileName
    a.click()
    window.URL.revokeObjectURL(url)
    a.remove()
  }

}

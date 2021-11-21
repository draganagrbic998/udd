import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdvertisementsComponent } from './components/application/advertisements/advertisements.component';
import { ApplicationSearchComponent } from './components/application/application-search/application-search.component';
import { ApplicationUploadComponent } from './components/application/application-upload/application-upload.component';
import { LoginComponent } from './components/auth/login/login.component';
import { Routes as RoutesConfig } from './utils/routes';

const routes: Routes = [
  {
    path: RoutesConfig.LOGIN,
    component: LoginComponent
  },
  {
    path: RoutesConfig.ADVERTISEMENTS,
    component: AdvertisementsComponent
  },
  {
    path: `${RoutesConfig.APPLICATION_UPLOAD}/:advertisementId`,
    component: ApplicationUploadComponent
  },
  {
    path: RoutesConfig.APPLICATION_SEARCH,
    component: ApplicationSearchComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

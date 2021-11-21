import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdvertisementsComponent } from './components/application/advertisements/advertisements.component';
import { ApplicationSearchComponent } from './components/application/application-search/application-search.component';
import { ApplicationUploadComponent } from './components/application/application-upload/application-upload.component';
import { LoginComponent } from './components/auth/login/login.component';
import { Role } from './models/auth';
import { AuthGuard } from './utils/auth.guard';
import { Routes as RoutesConfig } from './utils/routes';

const routes: Routes = [
  {
    path: RoutesConfig.LOGIN,
    component: LoginComponent
  },
  {
    path: RoutesConfig.ADVERTISEMENTS,
    component: AdvertisementsComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.KANDIDAT] }
  },
  {
    path: `${RoutesConfig.APPLICATION_UPLOAD}/:advertisementId`,
    component: ApplicationUploadComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.KANDIDAT] }
  },
  {
    path: RoutesConfig.APPLICATION_SEARCH,
    component: ApplicationSearchComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.TEHNICKO_LICE, Role.HR_LICE, Role.ZAPOSLENI_U_SLUZBI_NABAVKE, Role.DOBAVLJAC] }
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: RoutesConfig.LOGIN
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

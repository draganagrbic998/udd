import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdvertisementsComponent } from './components/application/advertisements/advertisements.component';
import { ApplicationSearchComponent } from './components/application/application-search/application-search.component';
import { ApplicationUploadComponent } from './components/application/application-upload/application-upload.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RoleAuth } from './models/auth';
import { AuthGuard } from './utils/auth.guard';
import { Route } from './utils/route';

const routes: Routes = [
  {
    path: Route.LOGIN,
    component: LoginComponent
  },
  {
    path: Route.ADVERTISEMENTS,
    component: AdvertisementsComponent,
    canActivate: [AuthGuard],
    data: { roles: [RoleAuth.KANDIDAT] }
  },
  {
    path: `${Route.APPLICATION_UPLOAD}/:advertisementId`,
    component: ApplicationUploadComponent,
    canActivate: [AuthGuard],
    data: { roles: [RoleAuth.KANDIDAT] }
  },
  {
    path: Route.APPLICATION_SEARCH,
    component: ApplicationSearchComponent,
    canActivate: [AuthGuard],
    data: { roles: [RoleAuth.TEHNICKO_LICE, RoleAuth.HR_LICE, RoleAuth.ZAPOSLENI_U_SLUZBI_NABAVKE, RoleAuth.DOBAVLJAC] }
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: Route.LOGIN
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { Routes as RoutesConfig } from './utils/routes';

const routes: Routes = [
  {
    path: RoutesConfig.LOGIN,
    component: LoginComponent
  },
  {
    path: RoutesConfig.REGISTRATION,
    component: RegistrationComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

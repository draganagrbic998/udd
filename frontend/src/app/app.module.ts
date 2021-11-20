import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/auth/login/login.component';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { SpinnerComponent } from './components/utils/spinner/spinner.component';
import { MaterialModule } from './material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ToolbarComponent } from './components/utils/toolbar/toolbar.component';
import { AdvertisementsComponent } from './components/application/advertisements/advertisements.component';
import { ApplicationUploadComponent } from './components/application/application-upload/application-upload.component';
import { ApplicationSearchComponent } from './components/application/application-search/application-search.component';
import { FormComponent } from './components/utils/form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    SpinnerComponent,
    ToolbarComponent,
    AdvertisementsComponent,
    ApplicationUploadComponent,
    ApplicationSearchComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

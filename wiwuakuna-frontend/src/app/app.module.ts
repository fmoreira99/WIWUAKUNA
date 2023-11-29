import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import {MatBottomSheetModule} from '@angular/material/bottom-sheet';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { FormsModule } from '@angular/forms'
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { authInterceptorProviders } from './service/AuthInterceptor';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { IndexComponent } from './pages/index/index.component';
import { ResultComponent } from './pages/result/result.component';
import { TanimalComponent } from './pages/user/tanimal/tanimal.component';
import { TgestacionComponent } from './pages/user/tgestacion/tgestacion.component';
import { FormanimalComponent } from './pages/user/formanimal/formanimal.component';

@NgModule({
  declarations: [
    AppComponent, 
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    UserDashboardComponent,
    IndexComponent,
    ResultComponent,
    TanimalComponent,
    TgestacionComponent,
    FormanimalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
     MatBottomSheetModule,
     MatFormFieldModule,
     MatInputModule, MatIconModule, FormsModule, HttpClientModule,MatSnackBarModule,
     MatToolbarModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

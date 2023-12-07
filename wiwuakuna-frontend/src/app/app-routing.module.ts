import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { TiendaComponent } from './pages/tienda/tienda.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { IndexComponent } from './pages/index/index.component';
import { NormalGuard } from './service/normal.guard';
import { AdminGuard } from './service/admin.guard';
import { ResultComponent } from './pages/result/result.component';

const routes: Routes = [
  {
    path:'result',
    component:ResultComponent,
    pathMatch : 'full'
  },
  {
    path:'',
    component:HomeComponent,
    pathMatch : 'full'
  },{
    path : 'signup',
    component : SignupComponent,
    pathMatch : 'full'
  },
  {
    path : 'login',
    component : LoginComponent,
    pathMatch : 'full'
  },
  {
    path : 'admin',
    component : DashboardComponent,
    pathMatch : 'full',
    canActivate:[AdminGuard]
  },
  {
    path : 'index',
    component : IndexComponent,
    pathMatch : 'full',
    
  },
  {
    path:'user-dashboard',
    component : UserDashboardComponent,
    pathMatch : 'full',
    canActivate:[NormalGuard]
  },
  {
    path:'tienda',
    component : TiendaComponent,
    pathMatch : 'full'    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

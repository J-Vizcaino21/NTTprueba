import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InfoComponent } from './components/info/info.component';
import { SearchComponent } from './components/search/search.component';

const routes: Routes = [
  {path:'', component:SearchComponent},
  {path:'inicio', component:SearchComponent},
  {path:'user',component:InfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
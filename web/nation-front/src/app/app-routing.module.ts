import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CountriesComponent } from './countries/countries.component';
import { GdpComponent } from './gdp/gdp.component';
import { SearchFilterComponent } from './search-filter/search-filter.component';
import { CountryLanguagesComponent } from './country-languages/country-languages.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'countries', component: CountriesComponent },
  { path: 'gdp', component: GdpComponent },
  { path: 'search-filter', component: SearchFilterComponent },
  { path: 'countries/:countryCode2/languages', component: CountryLanguagesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { NationsService } from '../services/nations.service';
import { Country } from '../interfaces/country.interface';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.scss']
})
export class CountriesComponent implements OnInit {

  countries: Country[] = [];
  displayedColumns: string[] = ['name', 'area', 'country_code2'];

  constructor(private nationsService:NationsService, private router:Router) { }

  ngOnInit(): void {
    this.getCountries();
  }

  navigateToCountryLanguages(countryCode2: string) {
    this.router.navigate(['/countries', countryCode2, 'languages']);
  }

  getCountries(){
    this.nationsService.getCountries().subscribe(countries => {
      this.countries = countries;
    })
  }

}

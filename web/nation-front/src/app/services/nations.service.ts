import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { CountriesFilterStats } from '../interfaces/countriesFilterStats.interface';
import { CountriesStats } from '../interfaces/countriesStats.interface';
import { Country } from '../interfaces/country.interface';
import { Language } from '../interfaces/language.interface';
import { Region } from '../interfaces/region.interface';

@Injectable({
  providedIn: 'root',
})
export class NationsService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.baseUrl}/countries/info`);
  }

  getLanguagesByCountry(countryCode2: string): Observable<Language[]> {
    return this.http.get<Language[]>(
      `${this.baseUrl}/countries/${countryCode2}/languages`
    );
  }

  getAllCountryStats(): Observable<CountriesStats[]> {
    return this.http
      .get<CountriesStats[]>(
        `${this.baseUrl}/country-stats/max-gdp-per-population`
      )
      .pipe(map((data) => this.mapToCountriesStats(data)));
  }

  private mapToCountriesStats(data: any[]): CountriesStats[] {
    return data.map((item) => ({
      name: item.country.name,
      country_code3: item.country.countryCode3,
      year: item.year,
      population: item.population,
      gdp: item.gdp,
    }));
  }

  getAllStatsForFilterView(): Observable<CountriesFilterStats[]> {
    return this.http.get<CountriesFilterStats[]>(
      `${this.baseUrl}/country-stats/country-region-continent`
    );
  }

  getAllRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(`${this.baseUrl}/regions`);
  }
}

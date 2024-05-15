import { Component, OnInit } from '@angular/core';
import { NationsService } from '../services/nations.service';
import { CountriesStats } from '../interfaces/countriesStats.interface';

@Component({
  selector: 'app-gdp',
  templateUrl: './gdp.component.html',
  styleUrls: ['./gdp.component.scss']
})
export class GdpComponent implements OnInit {

  countriesStats: CountriesStats[] = [];
  displayedColumns: string[] = ['name', 'country_code3', 'year', 'population', 'gdp'];

  constructor(private nationsService: NationsService) { }

  ngOnInit(): void {
    this.nationsService.getAllCountryStats().subscribe(stats => {
      this.countriesStats = stats;
    });
  }

  }

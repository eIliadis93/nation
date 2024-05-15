import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NationsService } from '../services/nations.service';
import { CountriesFilterStats } from '../interfaces/countriesFilterStats.interface';
import { Region } from '../interfaces/region.interface';

@Component({
  selector: 'app-search-filter',
  templateUrl: './search-filter.component.html',
  styleUrls: ['./search-filter.component.scss']
})
export class SearchFilterComponent implements OnInit {
  displayedColumns: string[] = ['continentName', 'regionName', 'countryName', 'year', 'population', 'gdp'];
  dataSource: MatTableDataSource<CountriesFilterStats> = new MatTableDataSource<CountriesFilterStats>();
  resultsLength = 0;
  isLoadingResults = true;
  allRegions: Region[] = [];
  yearFrom: number | undefined;
  yearTo: number | undefined;

  @ViewChild(MatPaginator) paginator: MatPaginator | null = null;
  @ViewChild(MatSort) sort: MatSort | null = null;

  constructor(private nationsService: NationsService) {}

  ngOnInit(): void {
    this.loadData();
    this.loadRegions();
  }

  ngAfterViewInit() {
    if (this.paginator) {
      this.dataSource.paginator = this.paginator;
    }
    if (this.sort) {
      this.dataSource.sort = this.sort;
    }
  }

  loadData() {
    this.isLoadingResults = true;
    this.nationsService.getAllStatsForFilterView().subscribe({
      next: (data) => {
        this.isLoadingResults = false;
        this.resultsLength = data.length;
        this.dataSource.data = data;
      },
      error: () => {
        this.isLoadingResults = false;
      }
    });
  }

  loadRegions() {
    this.nationsService.getAllRegions().subscribe(regions => {
      this.allRegions = regions;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  applyRegionFilter(selectedRegion: string) {
    this.dataSource.filter = selectedRegion.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  applyYearFilter() {
    if (this.yearFrom === undefined || this.yearTo === undefined) {
      return;
    }

    const fromYear = +this.yearFrom;
    const toYear = +this.yearTo;

    this.dataSource.filterPredicate = (data: CountriesFilterStats, filter: string) => {
      const year = data.year;
      return year >= fromYear && year <= toYear;
    };

    this.dataSource.filter = 'custom';
  }
}

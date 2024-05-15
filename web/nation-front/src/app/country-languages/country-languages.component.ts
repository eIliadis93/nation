import { Component, OnInit } from '@angular/core';
import { Language } from '../interfaces/language.interface';
import { ActivatedRoute } from '@angular/router';
import { NationsService } from '../services/nations.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-country-languages',
  templateUrl: './country-languages.component.html',
  styleUrls: ['./country-languages.component.scss']
})
export class CountryLanguagesComponent implements OnInit {

  countryLanguages: Language[] = [];
  isLoading: boolean = false;
  error: string = '';
  displayedColumns: string[] = ['language'];
  private subscriptions: Subscription[] = [];

  constructor(private route: ActivatedRoute, private nationsService: NationsService) { }

  ngOnInit(): void {
    this.getLanguagesByCountry();
  }

  getLanguagesByCountry(){
    const countryCode2 = this.route.snapshot.paramMap.get('countryCode2');
    if(countryCode2?.length){
      this.nationsService.getLanguagesByCountry(countryCode2).subscribe(languages => {
        this.countryLanguages = languages;
      });
    }
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }
}

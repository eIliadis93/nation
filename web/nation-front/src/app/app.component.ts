import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'nation-front';

  @ViewChild('header') header!: ElementRef;
  @ViewChild('footer') footer!: ElementRef;

  ngOnInit() {
  }
}

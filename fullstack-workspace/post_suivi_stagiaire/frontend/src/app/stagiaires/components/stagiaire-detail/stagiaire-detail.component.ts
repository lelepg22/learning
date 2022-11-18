
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Stagiaire } from 'src/app/core/models/stagiaire';


@Component({
  selector: 'app-stagiaire-detail',
  templateUrl: './stagiaire-detail.component.html',
  styleUrls: ['./stagiaire-detail.component.scss']
})
export class StagiaireDetailComponent implements OnInit {

  @Input() public stagiaire : Stagiaire | null = new Stagiaire();
//or @Input public stagiaire!: Stagiaire; and on parent component <app-... [stagiare]="stagiaire!">

  @Output() public visibility: EventEmitter<boolean | null> = new EventEmitter<boolean | null>();

  constructor() { }

  ngOnInit(): void {
  }

  public closeCard() {

    this.visibility.emit(true);

  }

}

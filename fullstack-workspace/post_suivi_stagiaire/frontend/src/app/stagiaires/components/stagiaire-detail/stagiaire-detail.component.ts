
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Stagiaire } from 'src/app/core/models/stagiaire';
import { HandleDetailService } from 'src/app/shared/directives/handle-detail.service';


@Component({
  selector: 'app-stagiaire-detail',
  templateUrl: './stagiaire-detail.component.html',
  styleUrls: ['./stagiaire-detail.component.scss']
})
export class StagiaireDetailComponent implements OnInit {

  public bubbleConfig: any = {
    height: '3em',
    width: '3em',
    lineHeight: '3em', // equiv css : line-height
    backgroundColor: 'rgba(200, 20, 20, .5)',
    borderColor: 'darken(rgba(200, 20, 20, .5)), 25%)',
    borderStyle: 'solid',
    color: '#fff',
    fontFamily: 'Arial, Helvetica, sans-serif',
  }

  @Input() public stagiaire : Stagiaire | null = new Stagiaire();
//or @Input public stagiaire!: Stagiaire; and on parent component <app-... [stagiare]="stagiaire!">


  constructor(
    private handleDetailService : HandleDetailService
  ) { }

  ngOnInit(): void {
  }

  public closeCard() {

    this.handleDetailService.setIsDetailHidden(true);

  }

}

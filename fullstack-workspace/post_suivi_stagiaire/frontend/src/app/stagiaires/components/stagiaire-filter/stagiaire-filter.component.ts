import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-stagiaire-filter',
  templateUrl: './stagiaire-filter.component.html',
  styleUrls: ['./stagiaire-filter.component.scss']
})
export class StagiaireFilterComponent implements OnInit {

  @Input() public filterDate: Date | null = null;
  @Output() public onChangeFilter: EventEmitter<Date | null> = new EventEmitter<Date | null>();

  private buttonMap: Map<string, boolean> = new Map<string, boolean>();

  constructor() { }

  ngOnInit(): void {
    this.buttonMap.set('btnAll', true);
    this.buttonMap.set('btnLT1977', false);
    this.buttonMap.set('btnGT1977', false);

    if(this.filterDate === null){
      this.changeButtonStateKey('btnAll')
    }

    else{
      if(this.filterDate.getDate() === 31){
        this.changeButtonStateKey('btnGT1977')
      }
      else{
        this.changeButtonStateKey('btnLT1977')
      }
    }
   
  }



  public getButtonState(key: string): boolean{
    return this.buttonMap.get(key)!;
  }

  public changeButtonStateKey(button : string): void {
    // Have to change the value of key to true, others to false

    this.buttonMap.forEach((value: boolean, key:string) => {
      if(key === button){
        this.buttonMap.set(key,true);
      }
      else{
        this.buttonMap.set(key, false);
      }
    }
    )
    if(button === 'btnAll'){
      this.onChangeFilter.emit(null)
    }
    else if(button === 'btnGT1977'){
      this.onChangeFilter.emit(new Date(1977,11,31))
    }
    else{
      this.onChangeFilter.emit(new Date(1977,0,1))
    }

  }
}

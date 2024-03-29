import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HandleDetailService {
    // $ dolar por signaler un observable ,  est un convention 
  private _isDetailHidden$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(true);
  constructor() { }

  public get isDetailHidden() : BehaviorSubject<boolean> {

    return this._isDetailHidden$;

  }

  public setIsDetailHidden(state: boolean): void {

    this._isDetailHidden$.next(state);

  }
}

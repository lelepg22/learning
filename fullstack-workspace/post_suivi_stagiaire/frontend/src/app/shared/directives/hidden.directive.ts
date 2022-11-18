import { Directive, ElementRef, Input } from '@angular/core';

@Directive({
  selector: '[appHidden]'
})
export class HiddenDirective {  
  
  @Input() public appHidden : boolean  = false;
  
  private toggler(condition: boolean){
    (condition === false) ? this.el.nativeElement.style.display='none' : this.el.nativeElement.style.display='block';
  }
  

  constructor(private el: ElementRef) { 
    console.log(this.appHidden);
    this.toggler(this.appHidden || false)
  }

}

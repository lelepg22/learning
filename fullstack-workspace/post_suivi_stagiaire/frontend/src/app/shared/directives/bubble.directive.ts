import { Directive, ElementRef, HostListener, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBubble]'
})
export class BubbleDirective implements OnInit {

  private _defaultConfig : any = {
    height: '2em',          
    width: '2em',
    lineHeight: '2em',
    backgroundColor:'rgba(20, 20, 150, .7)', //when manipulating css instead of - use camelCase like background-color
    borderRadius: '50%',
    fontWeight: 'bold',
    verticalAlign: 'middle',
    textAlign: 'center',
    display: 'inline-block'
  }

 // Object that merge default and config passed as @Input()
  private _config: any = {};
  

  @Input() public set config(inputConfig: any) {
    // your logic goes here

    for (const property in this._defaultConfig) {
      
      if(inputConfig.hasOwnProperty(property)){ // or if(property in inputConfig)

        this._config[property] = inputConfig[property]

      }
      else{ 

        this._config[property] = this._defaultConfig[property];

      }

      for(const property in inputConfig) {

         if(!this._defaultConfig.hasOwnProperty(property)){

          this._config[property] = inputConfig[property]

         }
      }
    } 
  }

  constructor( 
    private elementRef: ElementRef, 
    private renderer: Renderer2
   ){}

  ngOnInit(): void {
    
    let nativeElement: HTMLElement = this.elementRef.nativeElement;
    // nativeElement.style.fontWeight = 'bold'; pas bonne partique manipuler le dom a la place de ANGULAR

    for(const property in this._config){
      this.renderer.setStyle(nativeElement, property, this._config[property]);
    }
   
  }
  @HostListener('click') public onClick() {

    const nativeElement : HTMLElement = this.elementRef.nativeElement;

    this.renderer.addClass(nativeElement,'zoom-in');

    setTimeout(() => {
      this.renderer.removeClass(nativeElement, 'zoom-in')}, 1000
    )
    

  }

}

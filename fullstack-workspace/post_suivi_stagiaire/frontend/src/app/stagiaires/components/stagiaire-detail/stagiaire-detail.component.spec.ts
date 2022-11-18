import { ComponentFixture, TestBed } from '@angular/core/testing';
import { InitialsPipe } from 'src/app/shared/pipes/initials.pipe';

import { StagiaireDetailComponent } from './stagiaire-detail.component';

describe('StagiaireDetailComponent', () => {
  let component: StagiaireDetailComponent;
  let fixture: ComponentFixture<StagiaireDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StagiaireDetailComponent, InitialsPipe ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StagiaireDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

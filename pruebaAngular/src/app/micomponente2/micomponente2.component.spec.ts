import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Micomponente2Component } from './micomponente2.component';

describe('Micomponente2Component', () => {
  let component: Micomponente2Component;
  let fixture: ComponentFixture<Micomponente2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Micomponente2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Micomponente2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioResponsableComponent } from './formulario-responsable.component';

describe('FormularioResponsableComponent', () => {
  let component: FormularioResponsableComponent;
  let fixture: ComponentFixture<FormularioResponsableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormularioResponsableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioResponsableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

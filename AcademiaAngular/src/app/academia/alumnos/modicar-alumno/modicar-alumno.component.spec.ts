import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModicarAlumnoComponent } from './modicar-alumno.component';

describe('ModicarAlumnoComponent', () => {
  let component: ModicarAlumnoComponent;
  let fixture: ComponentFixture<ModicarAlumnoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModicarAlumnoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModicarAlumnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

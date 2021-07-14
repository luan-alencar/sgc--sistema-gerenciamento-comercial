import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeFormularioComponent } from './home-formulario.component';

describe('HomeFormularioComponent', () => {
  let component: HomeFormularioComponent;
  let fixture: ComponentFixture<HomeFormularioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeFormularioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeFormularioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

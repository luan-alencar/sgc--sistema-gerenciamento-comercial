import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeListagemComponent } from './home-listagem.component';

describe('HomeListagemComponent', () => {
  let component: HomeListagemComponent;
  let fixture: ComponentFixture<HomeListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

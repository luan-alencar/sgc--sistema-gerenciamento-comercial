import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriasRoutingModule } from './categorias-routing.module';
import { CategoriaListagemComponent } from './categoria-listagem/categoria-listagem.component';


@NgModule({
  declarations: [
  
    CategoriaListagemComponent
  ],
  imports: [
    CommonModule,
    CategoriasRoutingModule
  ]
})
export class CategoriasModule { }

import { Categoria } from "./categoria";
import { SituacaoProduto } from "./situacao-produto";

export class Produto {

    id?: number;
    nome?: string;
    quantidadeMinima?: number;
    valor?: number;
    idSituacao?: SituacaoProduto;
    categorias?: Categoria[] = [];

    constructor(){}
}

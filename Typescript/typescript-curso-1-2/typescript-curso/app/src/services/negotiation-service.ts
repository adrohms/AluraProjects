import { DataImport } from "../interfaces/data-import.js";
import { Negociacao } from "../models/negociacao.js";
import { Negociacoes } from "../models/negociacoes.js";

export class NegotiationService {

    //private negociacoes = new Negociacoes();

    public importNegociations(): Promise<Array<Negociacao>> {
        return fetch('http://localhost:8080/dados')
        .then( res => res.json())
        .then((data: Array<DataImport>) => {
            return data.map( item => {
                return new Negociacao(new Date(), item.montante, item.vezes);
            });
        })

        
    }
}
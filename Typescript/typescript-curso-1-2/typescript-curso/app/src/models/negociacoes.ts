import { Model } from '../interfaces/model.js';
import { Negociacao } from './negociacao.js';

export class Negociacoes implements Model<Negociacoes> {

    constructor(){}

    private negociacoes: Array<Negociacao> = [];

    public adiciona(negociacao: Negociacao) {
        this.negociacoes.push(negociacao);
    }

    public lista(): ReadonlyArray<Negociacao> {
        return this.negociacoes;
    }

    public toString(): string {
        return `
            Lista de negociações:
            ${this.negociacoes}
        `;
    }

    public isEqual(negociacoes: Negociacoes): boolean {
        return JSON.stringify(this.negociacoes) === JSON.stringify(negociacoes.lista());
    }
}

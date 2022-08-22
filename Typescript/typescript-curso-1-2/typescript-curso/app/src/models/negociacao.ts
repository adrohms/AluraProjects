import { Model } from "../interfaces/model.js";

export class Negociacao implements Model<Negociacao> {
    constructor(
        private _data: Date, 
        public readonly quantidade: number, 
        public readonly valor: number
    ) {}

    public static createFrom(dateString: string, qtdString: string, valorString: string){
        const exp = /-/g;
        const date = new Date(dateString.replace(exp,','));
        const quantidade = parseInt(qtdString);
        const valor = parseFloat(valorString);
        return new Negociacao(date, quantidade, valor);
    }

    get volume(): number {
        return this.quantidade * this.valor;
    }

    get data(): Date {
        const data = new Date(this._data.getTime());
        return data;
    }

    public toString(): string {
        return `
            ${this._data},
            ${this.quantidade},
            ${this.valor}
        `;
    }

    public isEqual(negociacao: Negociacao){
        return this.data.getDate() === negociacao.data.getDate();
    }
}
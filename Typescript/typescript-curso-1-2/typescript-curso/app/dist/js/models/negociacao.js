export class Negociacao {
    constructor(_data, quantidade, valor) {
        this._data = _data;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    static createFrom(dateString, qtdString, valorString) {
        const exp = /-/g;
        const date = new Date(dateString.replace(exp, ','));
        const quantidade = parseInt(qtdString);
        const valor = parseFloat(valorString);
        return new Negociacao(date, quantidade, valor);
    }
    get volume() {
        return this.quantidade * this.valor;
    }
    get data() {
        const data = new Date(this._data.getTime());
        return data;
    }
    toString() {
        return `
            ${this._data},
            ${this.quantidade},
            ${this.valor}
        `;
    }
    isEqual(negociacao) {
        return this.data.getDate() === negociacao.data.getDate();
    }
}
//# sourceMappingURL=negociacao.js.map
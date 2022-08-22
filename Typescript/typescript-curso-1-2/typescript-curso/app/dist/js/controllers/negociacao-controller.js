var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { DiasDaSemana } from '../enums/dias-da-semana.js';
import { Negociacao } from '../models/negociacao.js';
import { Negociacoes } from '../models/negociacoes.js';
import { MensagemView } from '../views/mensagem-view.js';
import { NegociacoesView } from '../views/negociacoes-view.js';
import { RunTimeCalculator } from '../decorators/run-time-calculator.js';
import { Inspect } from '../decorators/inspect.js';
import { DomInjector } from '../decorators/dom-injector.js';
import { NegotiationService } from '../services/negotiation-service.js';
export class NegociacaoController {
    constructor() {
        this.negociacoes = new Negociacoes();
        this.negotiationsService = new NegotiationService();
        this.negociacoesView = new NegociacoesView('#negociacoesView');
        this.mensageView = new MensagemView('#mensagemView');
        this.negociacoesView.update(this.negociacoes);
    }
    adiciona() {
        const negociacaoTemp = Negociacao.createFrom(this.inputData.value, this.inputQuantidade.value, this.inputValor.value);
        if (!this.isDateUtil(negociacaoTemp.data)) {
            return this.mensageView.update("Não são aceitas negociações em dias não úteis!");
        }
        this.negociacoes.adiciona(negociacaoTemp);
        console.log(this.negociacoes.lista());
        this.negociacoesView.update(this.negociacoes);
        this.mensageView.update("Negociação adicionada com sucesso!");
        this.limparFormulario();
    }
    dataImport() {
        this.negotiationsService.importNegociations()
            .then(importedNegotiations => {
            return importedNegotiations.filter(negociation => {
                return !this.negociacoes
                    .lista()
                    .some(eachNegociation => eachNegociation.isEqual(negociation));
            });
        })
            .then(importedNegotiations => {
            console.log("É AQUI??? " + importedNegotiations);
            for (let negociation of importedNegotiations) {
                console.log("É AQUI ????  ??? " + negociation);
                this.negociacoes.adiciona(negociation);
            }
            this.negociacoesView.update(this.negociacoes);
            this.mensageView.update("Negociações importadas com sucesso!");
        });
    }
    limparFormulario() {
        this.inputData.value = '';
        this.inputQuantidade.value = '';
        this.inputValor.value = '';
        this.inputData.focus();
    }
    isDateUtil(date) {
        if (date.getDay() > DiasDaSemana.DOMINGO && date.getDay() < DiasDaSemana.SABADO) {
            return true;
        }
        return false;
    }
}
__decorate([
    DomInjector('#data')
], NegociacaoController.prototype, "inputData", void 0);
__decorate([
    DomInjector('#quantidade')
], NegociacaoController.prototype, "inputQuantidade", void 0);
__decorate([
    DomInjector('#valor')
], NegociacaoController.prototype, "inputValor", void 0);
__decorate([
    RunTimeCalculator('seconds'),
    Inspect()
], NegociacaoController.prototype, "adiciona", null);
//# sourceMappingURL=negociacao-controller.js.map
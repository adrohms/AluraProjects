import { DiasDaSemana } from '../enums/dias-da-semana.js';
import { Negociacao } from '../models/negociacao.js';
import { Negociacoes } from '../models/negociacoes.js';
import { MensagemView } from '../views/mensagem-view.js';
import { NegociacoesView } from '../views/negociacoes-view.js';
import { RunTimeCalculator } from '../decorators/run-time-calculator.js';
import { Inspect } from '../decorators/inspect.js';
import { DomInjector } from '../decorators/dom-injector.js';
import { NegotiationService } from '../services/negotiation-service.js';
import { printfy } from '../utils/printfy.js';

export class NegociacaoController {

    @DomInjector('#data')
    private inputData: HTMLInputElement;
    @DomInjector('#quantidade')
    private inputQuantidade: HTMLInputElement;
    @DomInjector('#valor')
    private inputValor: HTMLInputElement;

    private negociacoes = new Negociacoes();
    private negotiationsService = new NegotiationService();

    private negociacoesView = new NegociacoesView('#negociacoesView');
    private mensageView = new MensagemView('#mensagemView');

    constructor() {
        this.negociacoesView.update(this.negociacoes);
    }

    @RunTimeCalculator('seconds')
    @Inspect()
    public adiciona(): void {

        const negociacaoTemp = Negociacao.createFrom(
            this.inputData.value,
            this.inputQuantidade.value,
            this.inputValor.value
        );

        if(!this.isDateUtil(negociacaoTemp.data)){
            return this.mensageView.update("Não são aceitas negociações em dias não úteis!");
        }
        this.negociacoes.adiciona(negociacaoTemp);
        console.log(this.negociacoes.lista());
        this.negociacoesView.update(this.negociacoes);
        this.mensageView.update("Negociação adicionada com sucesso!");
        //printfy(this.negociacoes, negociacaoTemp);
        this.limparFormulario();
    }

    public dataImport(): void {
        this.negotiationsService.importNegociations()
        .then(importedNegotiations => {
            return importedNegotiations.filter( negociation => {
                return !this.negociacoes
                    .lista()
                    .some( eachNegociation => eachNegociation.isEqual(negociation));
            })
        })
        .then(importedNegotiations => {
            console.log("É AQUI??? " + importedNegotiations);
            for(let negociation of importedNegotiations){
                console.log("É AQUI ????  ??? " + negociation);
                this.negociacoes.adiciona(negociation);
            }
            this.negociacoesView.update(this.negociacoes);
            this.mensageView.update("Negociações importadas com sucesso!");
        })   
    }

    public limparFormulario(): void {
        this.inputData.value = '';
        this.inputQuantidade.value = '';
        this.inputValor.value = '';
        this.inputData.focus(); 
    }

    private isDateUtil(date: Date): boolean{
        if(date.getDay() > DiasDaSemana.DOMINGO && date.getDay() < DiasDaSemana.SABADO){
            return true;
        }
        return false;
    }
}

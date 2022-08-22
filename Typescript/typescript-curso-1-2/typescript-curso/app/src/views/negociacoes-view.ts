import { Escape } from "../decorators/escape.js";
import { Negociacoes } from "../models/negociacoes.js";
import { View } from "./view.js";

export class NegociacoesView extends View<Negociacoes> {
    
    // Return a HTML embedded with the necessary data;
    @Escape()
    protected template(model: Negociacoes): string {
        return `
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th> DATA </th>
                    <th> QUANTIDADE </th>
                    <th> VALOR </th>
                </tr>
            </thead>
            <tbody>
                ${
                    model.lista().map(negociacao => {
                        return`
                        <tr>
                            <td> ${this.formatDate(negociacao.data)} </td>
                            <td> ${negociacao.quantidade} </td>
                            <td> ${negociacao.valor} </td>
                        </tr>
                        `
                    })
                } 
            </tbody>
        </table>
        `
    }

    private formatDate(date: Date): string{
        return new Intl.DateTimeFormat().format(date);
    }

}
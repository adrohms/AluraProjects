import { Negociacao } from "../models/negociacao.js";
export class NegotiationService {
    importNegociations() {
        return fetch('http://localhost:8080/dados')
            .then(res => res.json())
            .then((data) => {
            return data.map(item => {
                return new Negociacao(new Date(), item.montante, item.vezes);
            });
        });
    }
}
//# sourceMappingURL=negotiation-service.js.map
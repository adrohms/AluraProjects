export class View {
    constructor(idSelector, alert) {
        this.alert = false;
        const elemento = document.querySelector(idSelector);
        if (elemento) {
            this.selectedElement = elemento;
        }
        else {
            throw Error(` Seletor ${idSelector} não existe no DOM! `);
        }
    }
    update(model) {
        let template = this.template(model);
        this.selectedElement.innerHTML = template;
    }
}
//# sourceMappingURL=view.js.map
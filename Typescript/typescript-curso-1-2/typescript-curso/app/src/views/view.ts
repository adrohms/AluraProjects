export abstract class View<G> {

    protected selectedElement: HTMLElement;
    private alert = false;

    constructor(idSelector: string, alert?: boolean){
        const elemento = document.querySelector(idSelector)
        if(elemento){
            this.selectedElement = <HTMLElement> elemento;
        } else {
            throw Error(` Seletor ${idSelector} não existe no DOM! `);
        }
    }

    public update(model: G): void {
        let template = this.template(model);
        this.selectedElement.innerHTML = template;
    }

    protected abstract template(model: G): string;
}
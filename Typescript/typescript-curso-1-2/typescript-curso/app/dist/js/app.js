import { NegociacaoController } from './controllers/negociacao-controller.js';
const controller = new NegociacaoController();
const form = document.querySelector('.form');
if (form) {
    form.addEventListener('submit', event => {
        event.preventDefault();
        controller.adiciona();
    });
}
else {
    throw Error(` Form dosn't exists! `);
}
const importBtn = document.querySelector('#import-btn');
if (importBtn) {
    importBtn.addEventListener('click', () => {
        controller.dataImport();
    });
}
else {
    throw Error('Button not finded! ');
}
//# sourceMappingURL=app.js.map
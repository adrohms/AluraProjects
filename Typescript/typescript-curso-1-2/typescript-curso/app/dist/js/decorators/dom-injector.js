export function DomInjector(selector) {
    return function (target, propertKey) {
        console.log(`
        Modifyng prototype ${target.constructor.name}
         to add a getter to the property ${propertKey}.
        `);
        let element;
        const getter = function () {
            if (!element) {
                console.log(`
                Searching DOM element with the selector ${selector} to 
                 inject in ${propertKey}.
                `);
                element = document.querySelector(selector);
            }
            console.log(` Element already inserted! `);
            return element;
        };
        Object.defineProperty(target, propertKey, {
            get: getter
        });
    };
}
//# sourceMappingURL=dom-injector.js.map
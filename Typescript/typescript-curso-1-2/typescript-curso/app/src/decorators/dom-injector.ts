 export function DomInjector(selector: string) {
    return function (
        target: any,
        propertKey: string
    ) {
        console.log(`
        Modifyng prototype ${target.constructor.name}
         to add a getter to the property ${propertKey}.
        `);

        let element: HTMLElement;
        const getter = function() {
            if(!element){
                console.log(`
                Searching DOM element with the selector ${selector} to 
                 inject in ${propertKey}.
                `);

                element = <HTMLInputElement> document.querySelector(selector);
            }

            console.log(` Element already inserted! `);
            return element;
        }

        Object.defineProperty(
            target,
            propertKey,
            {
                get: getter
            }
        );
    }
        
 }
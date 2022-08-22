export function RunTimeCalculator(unityOfTime: string = 'miliseconds') {
    return function(
        target: any,
        propertyKey: string,
        descriptor: PropertyDescriptor // Nos dá acesso a implementação do método decorado através de descriptor.value
    ){
        const metodoOriginal = descriptor.value;
        descriptor.value = function(...args: Array<any>) {
            let divider = 1;
            if(unityOfTime === 'seconds'){
                divider = 1000;
            }
            const t1 = performance.now();
            console.log(`This is this of the run time: ${JSON.stringify(this)}`);
            const retorno = metodoOriginal.apply(this, args);
            const t2 = performance.now();
            console.log(`${propertyKey}, run time: ${(t2 - t1)/divider} ${unityOfTime}.`);
            retorno;
        };
        return descriptor;
    }
}
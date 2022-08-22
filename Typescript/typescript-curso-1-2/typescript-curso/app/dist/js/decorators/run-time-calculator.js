export function RunTimeCalculator(unityOfTime = 'miliseconds') {
    return function (target, propertyKey, descriptor) {
        const metodoOriginal = descriptor.value;
        descriptor.value = function (...args) {
            let divider = 1;
            if (unityOfTime === 'seconds') {
                divider = 1000;
            }
            const t1 = performance.now();
            console.log(`This is this of the run time: ${JSON.stringify(this)}`);
            const retorno = metodoOriginal.apply(this, args);
            const t2 = performance.now();
            console.log(`${propertyKey}, run time: ${(t2 - t1) / divider} ${unityOfTime}.`);
            retorno;
        };
        return descriptor;
    };
}
//# sourceMappingURL=run-time-calculator.js.map
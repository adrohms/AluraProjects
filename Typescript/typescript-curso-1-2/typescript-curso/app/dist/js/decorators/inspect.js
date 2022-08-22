export function Inspect() {
    return function (target, propertyKey, descriptor) {
        const originalMethod = descriptor.value;
        descriptor.value = function (...args) {
            console.log(` ---> Target ${JSON.stringify(target)}`);
            console.log(` ---> Method ${propertyKey}`);
            console.log(`This is this of the inspect: ${JSON.stringify(this)}`);
            const retorno = originalMethod.apply(this, args);
            console.log(` ---> Return ${JSON.stringify(retorno)}`);
            return retorno;
        };
        return descriptor;
    };
}
//# sourceMappingURL=inspect.js.map
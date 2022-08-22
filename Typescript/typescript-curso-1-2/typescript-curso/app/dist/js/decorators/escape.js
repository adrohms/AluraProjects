export function Escape() {
    return function (target, propertyKey, descriptor) {
        const originalMethod = descriptor.value;
        descriptor.value = function (...args) {
            let retorno = originalMethod.apply(this, args);
            if (typeof retorno === 'string') {
                console.log(`@escape() in action on the class ${this.constructor.name} for the method ${propertyKey}`);
                retorno = retorno.replace(/<script>[\s\S]*?<\/script>/gm, '');
            }
            return retorno;
        };
        return descriptor;
    };
}
//# sourceMappingURL=escape.js.map
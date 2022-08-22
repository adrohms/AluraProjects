export function Inspect() {
    return function(
        /*  
            If in a static method the target is the constructor function,
            In a stanciable method the target is the prototype,
        */
        target: any, 
        propertyKey: string,
        descriptor: PropertyDescriptor
    ){
        const originalMethod = descriptor.value;
        descriptor.value = function(...args: Array<any>) {

            console.log(` ---> Target ${JSON.stringify(target)}`);
            console.log(` ---> Method ${propertyKey}`);
            console.log(`This is this of the inspect: ${JSON.stringify(this)}`);
            /*
                this: context of this new function added in the value. 
                That's why we can't use arrow function, because the this wont change, will be a lexical this:
                The value of this in an arrow function is inherited from the enclosing (lexical) scope.
                Functions have a special variable this that refers to the object via which the method was invoked. 
                As the value of this is dynamically given based on the function invocation, it is sometimes called dynamic this.

                const person = {
                fullName: function() {
                    return this.firstName + " " + this.lastName;
                }
                }

                const person1 = {
                firstName: "Mary",
                lastName: "Doe"
                }

                // This will return "Mary Doe":
                person.fullName.apply(person1);
            */
            const retorno = originalMethod.apply(this, args);

            console.log(` ---> Return ${JSON.stringify(retorno)}`);

            return retorno;
        }

        return descriptor;
    }
}

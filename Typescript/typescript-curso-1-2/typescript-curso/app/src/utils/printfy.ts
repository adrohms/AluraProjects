import { Printable } from "../interfaces/printable.js";

export function printfy(...objs: Array<Printable>):void {
    console.log("-----------------------------------------------")
    for(let obj of objs) {
        console.log(obj.toString());
    }
    console.log("-----------------------------------------------")
}
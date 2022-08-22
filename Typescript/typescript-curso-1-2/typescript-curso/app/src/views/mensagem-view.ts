import { Escape } from "../decorators/escape.js";
import { View } from "./view.js";


export class MensagemView extends View<string> {

    @Escape()
    protected template(model: string): string {
        return `
            <div class="alert alert-success" role="alert">
                ${model}
            </div>
        `;
    }
}
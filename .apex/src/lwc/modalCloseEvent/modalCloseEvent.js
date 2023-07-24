// modalCloseEvent.js
import { LightningElement } from 'lwc';

export default class ModalCloseEvent extends LightningElement {
    connectedCallback() {
        // Fire the custom event to close the modal
        this.dispatchEvent(new CustomEvent('close'));
    }
}

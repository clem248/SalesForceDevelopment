import { LightningElement, api } from 'lwc';

export default class CartModal extends LightningElement {
    @api cart;

    closeModal() {
        const closeModalEvent = new CustomEvent('close');
        this.dispatchEvent(closeModalEvent);
    }
}

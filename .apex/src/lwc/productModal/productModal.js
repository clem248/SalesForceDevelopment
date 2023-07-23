import { LightningElement, api } from 'lwc';

export default class ProductModal extends LightningElement {
    @api product;

    closeModal() {
        const closeModalEvent = new CustomEvent('close');
        this.dispatchEvent(closeModalEvent);
    }
}

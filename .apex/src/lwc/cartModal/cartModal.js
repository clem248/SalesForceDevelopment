
import { LightningElement, api } from 'lwc';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';
import checkoutCart from '@salesforce/apex/OrderController.checkoutCart';
import { NavigationMixin } from 'lightning/navigation';


export default class CartModal extends NavigationMixin(LightningElement) {
    @api cart;
    @api isModalOpen = false;

// Method to close the modal
    closeModal() {
        this.isModalOpen = false;
    }

    // Event handler for "Checkout" button click
    // Event handler for "Checkout" button click
        handleCheckoutClick() {
            const productIds = this.cart.map((product) => product.Id);
            checkoutCart({ productIds })
                .then((orderId) => {
                    this.dispatchEvent(
                        new ShowToastEvent({
                            title: 'Success',
                            message: 'Order created successfully',
                            variant: 'success'
                        })
                    );

                    // Redirect to the standard Order layout to see the created Order and Order Items
                    this[NavigationMixin.Navigate]({
                        type: 'standard__recordPage',
                        attributes: {
                            recordId: orderId,
                            objectApiName: 'Order__c',
                            actionName: 'view'
                        }
                    });
                })
                .catch((error) => {
                    this.dispatchEvent(
                        new ShowToastEvent({
                            title: 'Error',
                            message: error.body.message,
                            variant: 'error'
                        })
                    );
                });
        }
}

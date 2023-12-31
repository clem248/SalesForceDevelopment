import { LightningElement, track } from 'lwc';
import createProduct from '@salesforce/apex/CreateProductModalController.createProduct';

export default class CreateProductModal extends LightningElement {
    @track isModalOpen = false;
    @track name = '';
    @track description = '';
    @track type = '';
    @track family = '';
    @track image = '';
    @track price = '';

    openModal() {
        this.isModalOpen = true;
    }

    closeModal() {
        this.isModalOpen = false;
    }

    typeOptions = [
        { label: '2-rooms', value: '2-rooms' },
        { label: '3-rooms', value: '3-rooms' },
        { label: '4-rooms', value: '4-rooms' },
        { label: '5-rooms', value: '5-rooms' },
        // Add more options as needed
    ];

    familyOptions = [
            { label: 'Catty', value: 'Catty' },
            { label: 'House', value: 'House' },
            { label: 'Flat', value: 'Flat' },
            { label: 'Mansion', value: 'Mansion' },
            // Add more options as needed
        ];

    handleInputChange(event) {
        const fieldName = event.target.name;
        this[fieldName] = event.target.value;
    }


    handleSave() {
        // Perform validation checks if required
        // Call the Apex method to create the product
        createProduct({
            name: this.name,
            description: this.description,
            type: this.type,
            family: this.family,
            image: this.image,
            price: this.price
        })
        .then(result => {
            // Handle the result after the product is saved
            this.closeModal(); // Close the modal after successful save
        })
        .catch(error => {
            // Handle any errors that occur during the save process
            console.error('Error creating product:', error);
        });
    }
}
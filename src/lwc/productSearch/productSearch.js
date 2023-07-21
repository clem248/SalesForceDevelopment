import { LightningElement, wire } from 'lwc';
import getProducts from '@salesforce/apex/ProductController.getProducts';

export default class ProductSearch extends LightningElement {
    products;
    searchResults;
    noResults;
    searchText = '';
    selectedType = '';
    selectedFamily = '';


    typeOptions = [
        { label: '2-rooms', value: '2-rooms' },
        { label: '3-rooms', value: '3-rooms' },
        { label: '4-rooms', value: '4-rooms' },
        { label: '5-rooms', value: '5-rooms' },
        // Add more options as needed
    ];

    familyOptions = [
        { label: 'Catty', value: 'Catty' }, // Replace with your actual picklist values
        { label: 'Flat', value: 'Flat' },
        { label: 'House', value: 'House' },
        { label: 'Mansion', value: 'Mansion' },
        // Add more options as needed
    ];


    @wire(getProducts)
    wiredProducts({ data, error }) {
        if (data) {
            this.products = data;
            this.applyFilters(); // Apply filters after getting the initial product list
        } else if (error) {
            console.error('Error fetching products:', error);
        }
    }
    handleSearchChange(event) {
        this.searchText = event.target.value;
    }

    handleSearchClick() {
        if (this.searchText) {
            this.searchResults = this.products.filter(
                (product) =>
                    product.Name__c.toLowerCase().includes(this.searchText.toLowerCase()) ||
                    product.Description__c.toLowerCase().includes(this.searchText.toLowerCase())
            );
            this.noResults = this.searchResults.length === 0;
        } else {
            // If the search text is empty, reset the search results
            this.searchResults = null;
            this.noResults = false;
        }
    }
    handleTypeChange(event) {
            this.selectedType = event.detail.value;
            this.applyFilters();
        }

        handleFamilyChange(event) {
            this.selectedFamily = event.detail.value;
            this.applyFilters();
        }
        applyFilters() {
                if (!this.products) return; // Make sure products are available

                this.noResults = this.products.length === 0;
            }


}



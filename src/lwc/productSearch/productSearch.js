import { LightningElement, track } from 'lwc';
import searchProducts from '@salesforce/apex/ProductController.searchProducts';

export default class ProductSearch extends LightningElement {
    @track searchText = '';
    @track searchResults;
    @track noResults = false;

    handleSearchChange(event) {
        this.searchText = event.target.value;
    }

    async handleSearchClick() {
        try {
            this.noResults = false;
            this.searchResults = await searchProducts({ searchText: this.searchText });
            if (!this.searchResults || this.searchResults.length === 0) {
                this.noResults = true;
            }
        } catch (error) {
            // Handle any errors here
            console.error('Error performing search:', error);
        }
    }
}

import { LightningElement, wire } from 'lwc';
import getProducts from '@salesforce/apex/ProductController.getProducts'; // Replace YourApexController with your Apex controller name
import { ShowToastEvent } from 'lightning/platformShowToastEvent';
import ProductModal from 'c/productModal'; // Check if the import path is correct
import CartModal from 'c/cartModal'; // Import the CartModal component
import productSearchCSS from './productSearch.css'; // Import the CSS file
import { LightningIcon } from 'lightning/icon'; // Import the Lightning Icon component

export default class YourComponent extends LightningElement {
  searchText = '';
  selectedType = '';
  selectedFamily = '';
  searchResults = [];
  products = [];
  noResults = false;
  isModalOpen = false;
  isModalOpen2 = false;
  selectedProduct = {};
  cart = [];




typeOptions = [
  { label: '2-rooms', value: '2-rooms' },
  { label: '3-rooms', value: '3-rooms' },
  { label: '4-rooms', value: '4-rooms' },
  { label: '5-rooms', value: '5-rooms' },
];

// Options for the Family picklist
familyOptions = [
  { label: 'Catty', value: 'Catty' },
  { label: 'Flat', value: 'Flat' },
  { label: 'House', value: 'House' },
  { label: 'Mansion', value: 'Mansion' },
];
  // Wire to the Apex method to get all products initially
  @wire(getProducts)
    wiredProducts({ data, error }) {
      if (data) {
        this.products = data;
        this.searchResults = [...data]; // Initialize searchResults with all products
        this.noResults = this.searchResults.length === 0;
      } else if (error) {
        console.error('Error fetching products:', error);
      }
    }

  // Event handler for search text input change
  handleSearchTextChange(event) {
    this.searchText = event.target.value;
    this.applyFilters();
  }

  // Event handler for type picklist change
  handleTypeChange(event) {
    this.selectedType = event.target.value;
    this.applyFilters();
  }

  // Event handler for family picklist change
  handleFamilyChange(event) {
    this.selectedFamily = event.target.value;
    this.applyFilters();
  }



  // Apply filters based on search text, selected type, and selected family
  applyFilters() {
    this.searchResults = this.products.filter((product) => {
      const nameMatch = !this.searchText || product.Name__c.toLowerCase().includes(this.searchText.toLowerCase());
      const descriptionMatch = !this.searchText || product.Description__c.toLowerCase().includes(this.searchText.toLowerCase());
      const typeMatch = !this.selectedType || product.Type__c.toLowerCase() === this.selectedType.toLowerCase();
      const familyMatch = !this.selectedFamily || product.Family__c.toLowerCase() === this.selectedFamily.toLowerCase();

      return (nameMatch || descriptionMatch) && (typeMatch && familyMatch);
    });

    this.noResults = this.searchResults.length === 0;
  }





   handleDetailsClick(event) {
       // Get the product Id from the data attribute of the button
       const productId = event.target.dataset.productId;

       // Find the selected product in the list of products
       this.selectedProduct = this.products.find((product) => product.Id === productId);
        this.isModalOpen2 = true;

     }

   closeModal() {
           this.isModalOpen = false;
           this.isModalOpen2 = false;
       }





    handleShowCartClick() {
        this.isModalOpen = true;
    }
    handleAddToCart(event) {
          const productId = event.target.dataset.productId;
          const productToAdd = this.searchResults.find((product) => product.Id === productId);

          // Add the selected product to the cart
          this.cart.push(productToAdd);

          // Show a toast message to indicate the product is added to the cart
          const toastEvent = new ShowToastEvent({
              title: 'Success',
              message: 'Product added to cart',
              variant: 'success',
    });
          this.dispatchEvent(toastEvent);
    }
}


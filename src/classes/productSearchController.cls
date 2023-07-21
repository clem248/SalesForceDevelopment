public with sharing class productSearchController {
	// Method to perform product search based on Name and Description fields
	public static List<Product__c> searchProducts(String searchText) {
		try {
			// Perform SOQL query to search for products based on Name and Description fields
			// Replace "Product__c" with the actual API name of your custom object for products
			String searchQuery = 'SELECT Id, Name, Description FROM Product__c WHERE Name LIKE :searchText OR Description LIKE :searchText';
			List<Product__c> searchResults = Database.query(searchQuery);

			return searchResults;
		} catch (Exception ex) {
			// Handle any exceptions and errors here
			// You can log the error, display a custom error message, or take other actions as needed
			System.debug('Error performing search: ' + ex.getMessage());
			return new List<Product__c>(); // Return an empty list in case of any error
		}
	}
}
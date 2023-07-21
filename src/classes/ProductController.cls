public with sharing class ProductController {
	@AuraEnabled
	// Method to perform product search based on Name and Description fields
	public static List<Product__c> searchProducts(String searchText) {
		try {
			// Perform SOQL query to search for products based on Name and Description fields
			// Replace "Product__c" with the actual API name of your custom object for products
			String searchQuery = 'SELECT Name__c, Description__c FROM Product__c WHERE Name__c LIKE :searchText OR Description__c LIKE :searchText';
			List<Product__c> searchResults = Database.query(searchQuery);

			return searchResults;
		} catch (Exception ex) {
			// Handle any exceptions and errors here
			// You can log the error, display a custom error message, or take other actions as needed
			System.debug('Error performing search: ' + ex.getMessage());
			return new List<Product__c>(); // Return an empty list in case of any error
		}
	}
	@AuraEnabled(cacheable=true)
	public static List<Product__c> getProducts() {
		return [SELECT Name__c, Description__c, Type__c, Family__c, Image__c, Price__c FROM Product__c];
	}

	@AuraEnabled
	public static List<Product__c> getFilters(String selectedType, String selectedFamily) {
		String soqlQuery = 'SELECT Name__c, Description__c, Type__c, Family__c, Image__c, Price__c FROM Product__c';
		if (!String.isEmpty(selectedType) && !String.isEmpty(selectedFamily)) {
			soqlQuery += ' WHERE Type__c = :selectedType AND Family__c = :selectedFamily';
		} else if (!String.isEmpty(selectedType)) {
			soqlQuery += ' WHERE Type__c = :selectedType';
		} else if (!String.isEmpty(selectedFamily)) {
			soqlQuery += ' WHERE Family__c = :selectedFamily';
		}
		return Database.query(soqlQuery);
	}

}

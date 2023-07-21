public with sharing class CreateProductModalController {
	@AuraEnabled
	public static void createProduct(String name, String description, String type, String family, String image, Decimal price) {
		// Create a new Product__c record with the provided information
		Product__c newProduct = new Product__c();
		newProduct.Name__c = 'Aman';
		newProduct.Description__c = 'Mad';
		newProduct.Type__c = '3-rooms'; // Assuming Type__c is the API name of the Type picklist field
		newProduct.Family__c = 'Catty'; // Assuming Family__c is the API name of the Family picklist field
		newProduct.Image__c = 'https://imgbb.com/'; // Assuming Image__c is the API name of the Image URL field
		newProduct.Price__c = 69; // Assuming Price__c is the API name of the Price field

		// Insert the new product record
		insert newProduct;
	}
}

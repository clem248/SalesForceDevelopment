public with sharing class CreateProductModalController {
	@AuraEnabled
	public static void createProduct(String name, String description, String type, String family, String image, Decimal price) {
		// Create a new Product__c record with the provided information
		Product__c newProduct = new Product__c();
		newProduct.Name__c = name;
		newProduct.Description__c = description;
		newProduct.Type__c = type; // Assuming Type__c is the API name of the Type picklist field
		newProduct.Family__c = family; // Assuming Family__c is the API name of the Family picklist field
		newProduct.Image__c = image; // Assuming Image__c is the API name of the Image URL field
		newProduct.Price__c = price; // Assuming Price__c is the API name of the Price field

		// Insert the new product record
		insert newProduct;
	}
}

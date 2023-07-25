@IsTest
private class CreateProductModalControllerTest {
	@isTest
	static void testCreateProduct() {
		// Test data
		String testName = 'Test Product';
		String testDescription = 'This is a test product';
		String testType = '2-rooms';
		String testFamily = 'Catty';
		String testImage = 'https://example.com/image.jpg';
		Integer testPrice = 99;

		// Call the method under test
		Test.startTest();
		CreateProductModalController.createProduct(testName, testDescription, testType, testFamily, testImage, testPrice);
		Test.stopTest();

		// Verify the new product record was created
		List<Product__c> products = [SELECT Name__c, Description__c, Type__c, Family__c, Image__c, Price__c
		FROM Product__c
		WHERE Name__c = :testName];
		System.assertEquals(1, products.size());
		Product__c newProduct = products[0];

		// Verify the field values of the new product
		System.assertEquals(testName, newProduct.Name__c);
		System.assertEquals(testDescription, newProduct.Description__c);
		System.assertEquals(testType, newProduct.Type__c);
		System.assertEquals(testFamily, newProduct.Family__c);
		System.assertEquals(testImage, newProduct.Image__c);
		System.assertEquals(testPrice, newProduct.Price__c);
	}
}
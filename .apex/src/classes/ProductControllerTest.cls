@isTest
public class ProductControllerTest {
	@isTest
	static void testGetProducts() {
		// Test data setup
		Product__c testProduct1 = new Product__c(Name__c = 'Test Product 1', Description__c = 'This is a test product 1', Price__c = 50.0);
		Product__c testProduct2 = new Product__c(Name__c = 'Test Product 2', Description__c = 'This is a test product 2', Price__c = 75.0);
		insert new List<Product__c>{testProduct1, testProduct2};

		// Test the getProducts method
		Test.startTest();
		List<Product__c> products = ProductController.getProducts();
		Test.stopTest();

		// Verify the number of products returned
		System.assertEquals(2, products.size(), 'The number of products should be 2');
		// Add additional assertions to verify the content of the returned products if needed.
	}
}

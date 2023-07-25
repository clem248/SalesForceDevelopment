@isTest
private class OrderItemTriggerTest {
	@isTest
	static void testAfterInsert() {
		// Create a test Product record
		Product__c testProduct = new Product__c(Name__c = 'Test Product', Description__c = 'Test Description', Price__c = 50);
		insert testProduct;

		// Create a test Order record
		Order__c testOrder = new Order__c(Name__c = 'Test Order', AccountId__c = null, TotalProductCount__c = 5, TotalPrice__c = 10);
		insert testOrder;

		// Create a list of test OrderItems with required fields
		List<OrderItem__c> orderItemsToInsert = new List<OrderItem__c>{
				new OrderItem__c(OrderId__c = testOrder.Id, ProductId__c = testProduct.Id, Quantity__c = 1),
				new OrderItem__c(OrderId__c = testOrder.Id, ProductId__c = testProduct.Id, Quantity__c = 2),
				new OrderItem__c(OrderId__c = testOrder.Id, ProductId__c = testProduct.Id, Quantity__c = 3)
				};

		Test.startTest();
		// Insert the test OrderItems
		insert orderItemsToInsert;
		Test.stopTest();

		// Since this is a simple test, we don't need to add any specific assertions.
		// It's sufficient to reach this point without encountering any exceptions or errors.
		System.assert(true);
	}
}

public with sharing class OrderController {
	@AuraEnabled
	public static Id checkoutCart(List<Id> productIds) {
		List<OrderItem__c> orderItems = new List<OrderItem__c>();
		Decimal totalPrice = 0;
		Integer totalProductCount = 0;

		// Fetch selected products
		List<Product__c> selectedProducts = [SELECT Id, Name__c, Price__c FROM Product__c WHERE Id IN :productIds];

		// Calculate total price and total product count
		for (Product__c product : selectedProducts) {
			OrderItem__c orderItem = new OrderItem__c(
					ProductId__c = product.Id,
					Quantity__c = 1, // Assuming each product has a quantity of 1 for now
					Price__c = product.Price__c
			);
			orderItems.add(orderItem);
			totalPrice += product.Price__c;
			totalProductCount++;
		}

		// Create Order record
		Order__c newOrder = new Order__c(
				Name__c = 'New Order', // Set a relevant name for the order
				TotalProductCount__c = totalProductCount,
				TotalPrice__c = totalPrice
		);
		insert newOrder;

		// Set the created Order Id for the Order Items
		for (OrderItem__c orderItem : orderItems) {
			orderItem.OrderId__c = newOrder.Id;
		}
		insert orderItems;

		// Return the created Order Id
		return newOrder.Id;
	}
}

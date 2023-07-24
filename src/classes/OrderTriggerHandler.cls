public class OrderTriggerHandler {
	public static void calculateOrderTotals(Set<Id> orderIds) {
		List<Order__c> ordersToUpdate = new List<Order__c>();

		// Query the Order and related OrderItem records
		List<Order__c> ordersWithItems = [SELECT Id, (SELECT Id, Quantity__c, Price__c FROM OrderItems__r) FROM Order__c WHERE Id IN :orderIds];

		// Calculate totals for each Order
		for (Order__c order : ordersWithItems) {
			Integer totalProductCount = 0;
			Decimal totalPrice = 0;

			for (OrderItem__c orderItem : order.OrderItems__r) {
				totalProductCount += (Integer)orderItem.Quantity__c;
				totalPrice += orderItem.Quantity__c * orderItem.Price__c;
			}

			ordersToUpdate.add(new Order__c(Id = order.Id, TotalProductCount__c = totalProductCount, TotalPrice__c = totalPrice));
		}

		// Update the Order records with the calculated totals
		update ordersToUpdate;
	}
}

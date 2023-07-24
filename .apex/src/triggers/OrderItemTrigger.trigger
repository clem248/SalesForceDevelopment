trigger OrderItemTrigger on OrderItem__c (after insert, after update, after delete) {
	if (Trigger.isAfter) {
		if (Trigger.isInsert || Trigger.isUpdate) {
			Set<Id> orderIds = new Set<Id>();
			for (OrderItem__c orderItem : Trigger.new) {
				if (orderItem.OrderId__c != null) {
					orderIds.add(orderItem.OrderId__c);
				}
			}
			if (!orderIds.isEmpty()) {
				OrderTriggerHandler.calculateOrderTotals(orderIds);
			}
		} else if (Trigger.isDelete) {
			Set<Id> orderIds = new Set<Id>();
			for (OrderItem__c orderItem : Trigger.old) {
				if (orderItem.OrderId__c != null) {
					orderIds.add(orderItem.OrderId__c);
				}
			}
			if (!orderIds.isEmpty()) {
				OrderTriggerHandler.calculateOrderTotals(orderIds);
			}
		}
	}
}


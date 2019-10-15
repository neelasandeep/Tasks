package com.epam.engx.cleancode.naming.task1;


import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class CollectOrderService implements OrderService {

    private CollectionService collectionService;
    private NotificationManager notificationNManager;

    public void submitOrder(Order order) {
        if (collectionService.isEligibleForCollection(order))
        	notificationNManager.notifyCustomer(Message.READY_FOR_COLLECT, 4); 
        else
        	notificationNManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, 1); 
    }

	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	public void setNotificationNManager(NotificationManager notificationNManager) {
		this.notificationNManager = notificationNManager;
	}

   
}

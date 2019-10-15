package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {
        double orderPrice = 0.0;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (isNotAvailable(product))
                iterator.remove();
        }
        for (Product product : products)
            orderPrice += product.getProductPrice();
        return orderPrice;
    }


	private boolean isNotAvailable(Product product) {
		return !product.isAvailable();
	}


    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

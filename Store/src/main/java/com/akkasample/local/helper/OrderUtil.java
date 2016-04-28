package com.akkasample.local.helper;

import com.akkasample.bean.Order;
/**
 * get Order from the user
 * @author rakeshc
 *
 */
public class OrderUtil {

	public static Order getOrder() {
		
		return new Order("Cheeze Onion Pizza",450.00);
	}

}

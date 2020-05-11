package aop;

import org.springframework.stereotype.Component;

@Component
public class Order {
	  public void placeOrder() {
		  System.out.println("Placing order!");
	  }
	  
	  public void getOrderStatus(int orderid) {
		  System.out.println("Getting order status  for " + orderid);
	  }
	  public void cancelOrder() {
		  System.out.println("Cancelling order!");
	  }
}

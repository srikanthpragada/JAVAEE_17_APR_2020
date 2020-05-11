package aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

@SpringBootApplication 
public class Test  implements CommandLineRunner {
	@Autowired
    private Order order;
	public void run(String... args) throws Exception {
		 System.out.println(order.getClass());  // Proxy, target is Order
	   	 order.placeOrder(); 
	   	 order.cancelOrder();
	   	 order.getOrderStatus(100);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
  
}

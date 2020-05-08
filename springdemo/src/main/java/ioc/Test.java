package ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class Test  { 	
 
	public Test() {
		System.out.println("Test()");
	}
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

  
}

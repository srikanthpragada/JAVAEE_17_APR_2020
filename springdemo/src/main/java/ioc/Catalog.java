package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class Catalog implements CommandLineRunner {
	@Autowired
	@Qualifier("java")  // Inject bean with name java 
	private Books books;

	public Catalog() {
		System.out.println("Catalog()");
	}
	
	@Override
	public void run(String... args) throws Exception {
		for(String b : books.getBooks())
			System.out.println(b);
	}
}

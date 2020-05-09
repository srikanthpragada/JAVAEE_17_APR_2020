package ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component 
public class CatalogScope implements CommandLineRunner {
	@Autowired
	private Books books;
	
	@Autowired
	private Books techBooks;

	public CatalogScope() {
		System.out.println("CatalogScope()");
		System.out.println(books);
		System.out.println(techBooks);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct() in CatalogScope");
		System.out.println(books);
		System.out.println(techBooks);
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("PreDestory() in CatalogScope");
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		for(String b : books.getBooks())
			System.out.println(b);
	}
}

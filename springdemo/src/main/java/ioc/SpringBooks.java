package ioc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value="spring") 
@Lazy
// @Primary
// @Scope(scopeName = "prototype")
public class SpringBooks implements Books {

	public SpringBooks() {
		System.out.println("SpringBooks()");
	}
	
	
	@Override
	public List<String> getBooks() {
         ArrayList<String> books = new ArrayList<>();
         books.add("Spring in Action");
         books.add("Spring Data");
         return books;
	}
}

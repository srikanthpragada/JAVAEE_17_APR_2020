package ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="java")
@Scope(scopeName="prototype")
@Lazy
public class JavaBooks implements Books {

	public JavaBooks() {
		System.out.println("JavaBooks()");
	}
	
	@Override
	public List<String> getBooks() {
		ArrayList<String>  books = new ArrayList<>();
		books.add("Java Comp. Reference");
		books.add("Think in Java");
		return books;
	}
	

}

package restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ShowGitUserDetails implements CommandLineRunner {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ShowGitUserDetails.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = restTemplateBuilder.build();
		try {
			GitUser user = restTemplate.getForObject("https://api.github.com/users/srikanthpragada", GitUser.class);
			System.out.println(user.getName());
			System.out.println(user.getCompany());
			System.out.println(user.getLocation());
		} catch (RestClientException ex) {
            System.out.println(ex.getMessage());
		}

	}
}

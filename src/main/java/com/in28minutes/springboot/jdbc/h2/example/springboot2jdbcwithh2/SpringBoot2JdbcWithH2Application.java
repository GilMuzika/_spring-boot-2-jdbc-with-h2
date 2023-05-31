package com.in28minutes.springboot.jdbc.h2.example.springboot2jdbcwithh2;



import com.in28minutes.springboot.jdbc.h2.example.springboot2jdbcwithh2.student.Student;
import com.in28minutes.springboot.jdbc.h2.example.springboot2jdbcwithh2.student.StudentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


/* Instructions:
https://www.springboottutorial.com/spring-boot-and-spring-jdbc-with-h2
*/

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	/* After enabling H2 Console in "application.properties",
	it can be accessed by the address:
	<root_url_endpoint_of_the_app>/h2-console
	In this case: http://localhost:8081/h2-console
	*/




	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx, StudentJdbcRepository rep) {
		return args -> {
			System.out.println("Congratulations!");

			logger.info("Student id 10001 -> {}", rep.findById(10001L));
			logger.info("All users 1 -> {}", rep.findAll());

			logger.info("Inserting -> {}", rep.insert(new Student(10010L, "John", "A1234657")));
			logger.info("Update 10001 -> {}", rep.update(new Student(10001L, "Name-Updated", "New-Passport")));
			rep.deleteById(10002L);

			logger.info("All users 2 -> {}", rep.findAll());
		};

	}

}

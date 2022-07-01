package codej.codemarket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodemarketApplication {

	private static final Logger logger = LoggerFactory.getLogger(CodemarketApplication.class);

	public static void main(String[] args) {
		logger.info("hello Logback");
		SpringApplication.run(CodemarketApplication.class, args);
	}

}

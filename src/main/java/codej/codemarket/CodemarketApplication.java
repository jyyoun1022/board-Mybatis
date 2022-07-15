package codej.codemarket;

import codej.codemarket.dto.SignupDTO;
import codej.codemarket.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class CodemarketApplication {

	private static final Logger logger = LoggerFactory.getLogger(CodemarketApplication.class);
	private final AuthService authService;

	public static void main(String[] args) {
		logger.info("hello Logback");
		SpringApplication.run(CodemarketApplication.class, args);
	}



}

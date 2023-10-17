package accelerate.alumni.alumnibackend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlumniBackendApplication {
	public static void main(String[] args) {
		String databaseUrl = System.getenv("DATABASE_URL");
		SpringApplication.run(AlumniBackendApplication.class, args);
	}

}

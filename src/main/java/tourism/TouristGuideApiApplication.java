package tourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TouristGuideApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TouristGuideApiApplication.class, args);
    }
}

package freek.paintball.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {
                "freek.paintball.Repo"
        }
)
public class DBconfig {}

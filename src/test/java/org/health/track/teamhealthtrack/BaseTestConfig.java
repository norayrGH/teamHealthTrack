package org.health.track.teamhealthtrack;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = BaseTestConfig.DockerPostgreDataSourceInitializer.class)
@Testcontainers
public abstract class BaseTestConfig {
  public static PostgreSQLContainer<?> postgresDBContainer = new PostgreSQLContainer<>("postgres:latest");
  static {
    postgresDBContainer.start();
  }

  public static class DockerPostgreDataSourceInitializer implements
      ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
          applicationContext,
          "spring.datasource.url=" + postgresDBContainer.getJdbcUrl(),
          "spring.datasource.username=" + postgresDBContainer.getUsername(),
          "spring.datasource.password=" + postgresDBContainer.getPassword()
      );
    }
  }
}
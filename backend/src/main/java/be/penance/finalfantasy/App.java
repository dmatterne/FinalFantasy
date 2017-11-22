package be.penance.finalfantasy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Many Spring Boot developers always have their main class annotated with @Configuration,
// @EnableAutoConfiguration and @ComponentScan.
// Since these annotations are so frequently used together
// (especially if you follow the best practices above),
// Spring Boot provides a convenient @SpringBootApplication alternative.
@SpringBootApplication
public class App {

  @Autowired
  private Environment env;

  private static final Logger log = LoggerFactory.getLogger(App.class);

  /**
   * Spring profiles can be configured with program arguments --spring.profiles.active=your-active-profile
   */
  @PostConstruct
  public void initApplication() throws IOException {
    if (env.getActiveProfiles().length == 0) {
      log.warn("No Spring profile configured, running with default configuration");
    } else {
      log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
    }
  }

  /**
   * Main method, used to run the application.
   */
  public static void main(String[] args) throws UnknownHostException {
    SpringApplication app = new SpringApplication(App.class);

    SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
    addDefaultProfile(app, source);
    Environment env = app.run(args).getEnvironment();
    log.info("Access URLs:\n----------------------------------------------------------\n\t" +
        "Local: \t\thttp://127.0.0.1:{}\n\t" +
        "External: \thttp://{}:{}\n----------------------------------------------------------",
      env.getProperty("server.port"),
      InetAddress.getLocalHost().getHostAddress(),
      env.getProperty("server.port"));

  }



  /**
   * Set a default profile if it has not been set
   */
  private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
    if (!source.containsProperty("spring.profiles.active")) {
      app.setAdditionalProfiles("local");
    }
  }

  @Bean
  public ExecutorService executorService() {
    ExecutorService exService = Executors.newSingleThreadExecutor();
    return exService;
  }

}

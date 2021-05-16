package objectDbCBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App {
  public static void main(String[] args) {
	    Configuracion.init();
        SpringApplication.run(App.class, args);
  }
}
package br.com.boasmat.springboot.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
//@RestController
//@ComponentScan(basePackages = {"br.com.boasmat.springboot"})
public class ApplicationAnnotations {

    //    @Autowired
//    @Qualifier("applicationName")
    @Value("${application.name}")
    private String applicationName;

    @Cachorro
    private Animal animal;

    @Gato
    private Animal animal1;

    @Bean
    public CommandLineRunner executar(){
        return args -> {
          this.animal.fazerBarulho();
          this.animal1.fazerBarulho();
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(ApplicationAnnotations.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;
    }
}

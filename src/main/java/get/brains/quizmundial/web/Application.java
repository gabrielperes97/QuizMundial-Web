package get.brains.quizmundial.web;
/**
 *
 * @author gabriel
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({"get.brains.quizmundial.web"})
public class Application extends SpringBootServletInitializer {
    
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}

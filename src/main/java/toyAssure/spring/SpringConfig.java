package toyAssure.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan("com")
@PropertySources({
        @PropertySource(value = "file:./toyAssure.properties", ignoreResourceNotFound = true)
})
public class SpringConfig {
}
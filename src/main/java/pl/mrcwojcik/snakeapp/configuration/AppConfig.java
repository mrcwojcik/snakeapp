package pl.mrcwojcik.snakeapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = "pl.mrcwojcik.snakeapp")
@EnableSwagger2
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.mrcwojcik.snakeapp.modules.repositories")
public class AppConfig implements WebMvcConfigurer {



}

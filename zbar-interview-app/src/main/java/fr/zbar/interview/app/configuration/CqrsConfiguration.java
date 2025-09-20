package fr.zbar.interview.app.configuration;

import fr.zbar.interview.common.annotation.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
		basePackages = "fr.zbar.interview",
		includeFilters = {
				@ComponentScan.Filter(type = FilterType.ANNOTATION, value = DomainService.class)
		}
)
public class CqrsConfiguration {
}

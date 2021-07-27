package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //ㅈㅏ동으로 스프링빈 등록, 예제상 수동 등록한것 제외, 실무에서는 굳이 하지 않음
public class AutoAppConfig {

}

package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",// 시작 위치 지정 가능
        basePackageClasses = AutoAppConfig.class, //default -> 설정 클래스 현재 위치에서부터 // 권장 : config를 프로젝트 최상단에
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //자동으로 스프링빈 등록, 예제상 수동 등록한것 제외, 실무에서는 굳이 하지 않음
public class AutoAppConfig {

}

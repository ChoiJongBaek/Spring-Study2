package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 탐색할 패키지의 위치 지정
        // 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지(= hello.core)가 시작 위치가 된다.
        basePackages = "hello.core",
        // @Configuration을 ComponentScan 대상에서 제외 -> @Configuration 내부에도 @Component가 선언되어 있다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {



}

package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트 스캔은 별 다른 root directory 를 주지 않으면 현 클래스를 root directory 로 인식한다.
// 즉, 현 클래스부터 하위 directory 의 @Component 어노테이션이 붙은 클래스를 Bean으로 등록한다. (이 클래스도)
@Configuration
@ComponentScan(
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

	// @Bean(name = "memoryMemberRepository")
	// public MemberRepository memberRepository() {
	// 	return new MemoryMemberRepository();
	// }
}

package hello.core.singleton;

import hello.core.config.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

	@DisplayName("스프링 없는 순수 DI 컨테이너")
	@Test
	void pureContainer() {
		AppConfig config = new AppConfig();

		MemberService memberService1 = config.memberService();
		MemberService memberService2 = config.memberService();

		assertThat(memberService1).isNotSameAs(memberService2);
	}

	@DisplayName("싱글톤 패턴을 적용한 사례")
	@Test
	void singletonServiceTest() {
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();

		assertThat(singletonService1).isSameAs(singletonService2);

		singletonService1.logic();
	}

	@DisplayName("스프링 컨테이너와 싱글톤")
	@Test
	void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
		MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);

		assertThat(memberService1).isSameAs(memberService2);
	}
}

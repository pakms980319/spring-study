package hello.core.singleton.stateless;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class StatelessServiceTest {

	static class TestConfig {
		@Bean
		public StatelessService statelessService() {
			return new StatelessService();
		}
	}

	@Test
	void StatefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatelessService statelessService1 = ac.getBean("statelessService", StatelessService.class);
		StatelessService statelessService2 = ac.getBean("statelessService", StatelessService.class);

		int priceA = statelessService1.order("userA", 10000);
		int priceB = statelessService2.order("userB", 20000);

		assertThat(priceA).isNotEqualTo(priceB);
	}
}

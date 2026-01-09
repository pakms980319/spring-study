package hello.core.singleton.stateful;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest {

	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

	@Test
	void StatefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
		StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

		statefulService1.order("userA", 10000);
		statefulService2.order("userB", 20000);

		int priceA = statefulService1.getPrice();
		int priceB = statefulService2.getPrice();

		assertThat(priceA).isEqualTo(priceB);
	}
}

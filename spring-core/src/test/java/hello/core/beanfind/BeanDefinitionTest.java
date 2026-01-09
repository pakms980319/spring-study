package hello.core.beanfind;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	GenericXmlApplicationContext xmlApplicationContext = new GenericXmlApplicationContext("appConfig.xml");

	@Test
	@DisplayName("빈 설정 메타정보 확인 (java)")
	void findAnnotationApplicationBean() {
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
			}
		}
	}

	@Test
	@DisplayName("빈 설정 메타정보 확인 (xml)")
	void findXmlApplicationBean() {
		String[] beanDefinitionNames = xmlApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = xmlApplicationContext.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
			}
		}
	}
}

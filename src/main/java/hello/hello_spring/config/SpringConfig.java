package hello.hello_spring.config;

import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JdbcTemplateMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

	// private final DataSource dataSource;
	// private final JdbcTemplate jdbcTemplate;
	// private final EntityManager em;
	private final MemberRepository memberRepository;

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
}

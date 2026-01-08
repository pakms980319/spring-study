package hello.core.member;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

	MemberService memberService;

	@BeforeEach
	public void beforeEach() {
		AppConfig config = new AppConfig();
		memberService = config.memberService();
	}

	@Test
	void join() {
		Member member = new Member(1L, "memberA", Grade.VIP);

		memberService.join(member);
		Member findMember = memberService.findMember(1L);

		assertThat(member).isEqualTo(findMember);
	}
}
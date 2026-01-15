package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		Member member = new Member("hello", 20);
		System.out.println("member = " + member.getUsername());

		Member saveMember = memberRepository.save(member);

		Member findMember = memberRepository.findById(saveMember.getId());
		assertThat(findMember).isEqualTo(saveMember);
	}

	@Test
	void findAll() {
		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 30);

		memberRepository.save(member1);
		memberRepository.save(member2);

		List<Member> result = memberRepository.findAll();

		System.out.println("result1 = " + result.get(0).getUsername());
		System.out.println("result2 = " + result.get(1).getUsername());

		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(member1, member2);
	}
}
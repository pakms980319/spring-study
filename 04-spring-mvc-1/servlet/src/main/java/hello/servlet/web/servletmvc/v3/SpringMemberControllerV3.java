package hello.servlet.web.servletmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	// 애노테이션 기반 컨트롤러는 ModelAndView를 반환하는것이 가능하고 문자 반환도 가능하다
	@GetMapping("/new-form")
	public String newForm() {
		System.out.println("SpringMemberControllerV3.newForm");

		return "new-form";
	}

	// request, response 를 받을 수 있지만 파라미터를 직업 받을 수 있다.
	@PostMapping("/save")
	public String save(@RequestParam("username") String username,
	                   @RequestParam("age") int age,
	                   Model model) {
		System.out.println("SpringMemberControllerV3.save");

		Member member = new Member(username, age);
		memberRepository.save(member);

		model.addAttribute("member", member);
		return "save-result";
	}

	@GetMapping
	public String members(Model model) {
		System.out.println("SpringMemberControllerV3.members");

		List<Member> members = memberRepository.findAll();

		model.addAttribute("members", members);
		return "members";
	}
}

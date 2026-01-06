package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;

}

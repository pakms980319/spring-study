package hello.login.web.argumentresolver;

import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		log.info("supportsParameter 실행");

		boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
		boolean hasMemberType = Member.class.isAssignableFrom(parameter.getParameterType());

		// hasLoginAnnotation : @Login 애노테이션이 있을 때, true
		// hasMemberType : Member 타입일 때, true

		return hasLoginAnnotation && hasMemberType;
	}

	/**
	 * 컨트롤러 호출 직전에 호출되엇 필요한 파라미터 정보를 생성해 준다.
	 * 여기서는 세션에 있는 로그인 회원 정보인 member 객체를 찾아서 반환해 준다.
	 * 이후 스프링 MVC는 컨트롤러의 메서드를 호출하면서 여기에서 반환된 member 객체를 파라미터에 전달해 준다.
	 */
	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
		log.info("resolveArgument 실행");

		HttpServletRequest request = (HttpServletRequest)nativeWebRequest.getNativeRequest();
		HttpSession session = request.getSession(false);

		if (session == null) {
			return null;
		}

		Object member = session.getAttribute(SessionConst.LOGIN_MEMBER);

		return member;
	}
}

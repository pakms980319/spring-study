package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	// private final ObjectProvider<MyLogger> myLoggerProvider;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestUrl = request.getRequestURI().toString();
		// MyLogger myLogger = myLoggerProvider.getObject();
		System.out.println("myLogger = " + myLogger.getClass());
		myLogger.setRequestURL(requestUrl);

		myLogger.log("Controller Test");
		logDemoService.logic("testId");
		return "OK";
	}
}

package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean support(Object handler) {
		return (handler instanceof ControllerV3);  // V3가 넘어오면 true, 나머지는 false
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
		ControllerV3 controller = (ControllerV3)handler;

		Map<String, String> paramMap = createParamMap(request);
		ModelView mv = controller.process(paramMap);

		return mv;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			System.out.println("name = " + request.getParameter(name));
		}

		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames()
		       .asIterator()
		       .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

		System.out.println("createParamMap paramMap : " + paramMap);

		return paramMap;
	}
}

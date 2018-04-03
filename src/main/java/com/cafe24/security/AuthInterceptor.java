package com.cafe24.security;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("여기 들어오니??");

		// 1. handler 종류 확인
		if (handler instanceof HandlerMethod == false) {
			// 디폴트 핸들러 인 경우
			return true; // 뒤로
		}
		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		// 3. @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

		// 클래스 에서 @Auth 받아오기
		Auth classAuth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);

		System.out.println(auth);

		System.out.println(classAuth);

		// 4. Method에 @Auth가 없는 경우
		if (auth == null && classAuth == null) {
			return true; // 뒤로
		}

		// 5. @Auth 가 붙어 있는 경우 , 인증여부 체크
		HttpSession session = request.getSession();

		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");

		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		// 없는 경우 뒤로
		if (classAuth == null) {
			return true;
		}

		if (classAuth.role() == Auth.Role.ADMIN) {
			Map<?, ?> pathVariables = (HashMap<?, ?>) request
					.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			String blogId = (String) pathVariables.get("id");

			if (!authUser.getId().equals(blogId)) { // 번호가 다르면
				response.sendRedirect(request.getContextPath() + "/" + blogId);
				return false;
			}
		}
		return true;

		// 6. 접근 허가

	}

}

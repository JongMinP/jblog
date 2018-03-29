package com.cafe24.security;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.vo.UserVo;

public class AuthAdminInterceptor extends HandlerInterceptorAdapter {

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

		System.out.println(auth);

		// 4. Method에 @Auth가 없는 경우
		if (auth == null) {
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
		Auth.Role role = auth.role();

		if (role == Auth.Role.ADMIN) {
			Map pathVariables = (LinkedHashMap) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

			if (!authUser.getId().equals(pathVariables.get("id"))) { // 번호가 다르면
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}
		return true;
		
		// 6. 접근 허가

	}

}

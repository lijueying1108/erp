package org.kor.mv.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class PageExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		ex.printStackTrace();
		
		String message = null;
		PageInterviewException pageInterviewException = null;
		if(ex instanceof PageInterviewException) {
			pageInterviewException = (PageInterviewException)ex;
		}else {
			pageInterviewException = new PageInterviewException("관리자와 연락하세요");
		}
		message = pageInterviewException.getMessage();
		request.setAttribute("message", message);
		
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView();
	}

}

package com.donate.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donate.po.User;
/**
 * 前台页面过滤
 * @author Administrator
 *
 */
public class UserFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("开始过滤");

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		HttpServletRequest r = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse)response;
		HttpSession session = r.getSession();
		User attribute = (User) session.getAttribute("backUserSession");
		if (null != attribute) {
			chain.doFilter(request, response);
		} else {
			rs.sendRedirect("/back_page/login");
		}
	}

	public void destroy() {
		System.out.println("结束过滤");

	}

}

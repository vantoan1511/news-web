package com.newsweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsweb.constant.SystemConstant;
import com.newsweb.model.UserModel;
import com.newsweb.utilities.SessionUtility;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String url = request.getRequestURI();
		if (url.contains("/admin")) {
			UserModel model = (UserModel) SessionUtility.getInstance().getValue(request, "USERMODEL");
			if (model != null) {
				if(model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(req, resp);
				} else if(model.getRole().getCode().equals(SystemConstant.USER)) {
					response.sendRedirect(request.getContextPath()
							+ "/login?action=login&message=not_permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/login?action=login&message=not_login&alert=danger");
			}
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
	}
}

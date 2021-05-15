package filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mbeans.LoginBean;

/**
 * Servlet Filter implementation class SecureFolderFilter
 */
@WebFilter("/secure/*")
public class SecureFolderFilter implements Filter {

	@Inject
	private LoginBean loginBean;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Secure folder access detected !!!");

		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;

		// Only admin role accepted
		if (loginBean == null || !loginBean.isLoggedIn() || !loginBean.getRole().equals("Admin")) {
			String page = req.getRequestURI().replace(req.getContextPath(), "");
			page = page.replace("\\.xhtml", "");
			loginBean.setAccessPage(page);
			System.out.println(page);
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
			return;
		}
		chain.doFilter(request, response);
	}
}

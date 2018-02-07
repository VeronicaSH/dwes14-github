package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/ContadorFilter")
public class ContadorFilter implements Filter {

    
    public ContadorFilter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(this.getInitParameter("contador")) {
			
		}
		chain.doFilter(request, response);
	}

	
	private boolean getInitParameter(String string) {
		// TODO Auto-generated method stub
		return false;
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

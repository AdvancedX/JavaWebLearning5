import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/grades.jsp")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取用户会话
        HttpSession session = httpRequest.getSession(false);

        // 检查用户是否已登录
        if (session == null || session.getAttribute("user") == null) {
            // 用户未登录，显示提示消息
            String loginMessage = "用户未登录，请先登录";
            httpRequest.setAttribute("loginMessage", loginMessage);

            try {
                // 线程休眠两秒
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 重定向到登录页面
            httpResponse.sendRedirect("unlogin.jsp");
        } else {
            // 用户已登录，继续处理请求
            chain.doFilter(request, response);
        }
    }


    public void init(FilterConfig fConfig) throws ServletException {
        // 过滤器初始化
    }

    public void destroy() {
        // 过滤器销毁
    }
}

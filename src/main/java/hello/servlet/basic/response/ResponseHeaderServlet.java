package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //status line
        resp.setStatus(HttpServletResponse.SC_OK); //200
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header","hello");

        //header 편의 메서드
        content(resp);
        cookie(resp);
        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException{

        //302 status
        //location : /basic/hello-form.html
        response.sendRedirect("/basic/hello-form.html");
    }
}

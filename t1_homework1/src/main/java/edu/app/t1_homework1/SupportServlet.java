package edu.app.t1_homework1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SupportServlet extends HttpServlet {
    List<String> list = new ArrayList<>();
    public void init() {
        list.add("Все ок!");
        list.add("Все норм!");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println(list.get(new Random().nextInt(list.size())));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String m = req.getParameter("msg");
        if(m != null) {
            resp.getWriter().println("Сообщение добавлено");
            list.add(m);
        }else{
            throw new ServletException();
        }
    }
}

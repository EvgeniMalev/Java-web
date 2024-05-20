package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/volume")
public class VolumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Calculate Volume of a Cube</h1>");
        response.getWriter().println("<form method='post' action='/HelloWorldWebApp/volume'>");
        response.getWriter().println("Side length: <input type='text' name='side'><br>");
        response.getWriter().println("<input type='submit' value='Calculate'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sideStr = request.getParameter("side");
        double side = Double.parseDouble(sideStr);
        double volume = Math.pow(side, 3);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Volume of the Cube</h1>");
        response.getWriter().println("Side length: " + side + "<br>");
        response.getWriter().println("Volume: " + volume + "<br>");
        response.getWriter().println("</body></html>");
    }
}

package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros")
public class GetParametros extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //El tipo de documento que va a devolver el servlet
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));

        //Instanciamos
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet GetParametros </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet GetParametros </h1>");
        out.println("<p> El id del estudiante es " + id);
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");

    }






}

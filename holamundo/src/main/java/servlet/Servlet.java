package servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


//Anotación para acceder al Servlet esta es la key para acceso al servlet
//Tiene q llamarse con la clase
@WebServlet("/holaServlet")
//Servlet
// Es una clase de java extendida de una clase de Java extendida de una clase padre

public class Servlet extends HttpServlet {
    //Sobrescribimos el método que utiliza para hacer la petición
    //recibe dos objetos Request y Response
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //El servidor me va a responder con información de tipo texto o html
        resp.setContentType("text/html");

        //Paso 3
        //Proceso de parametros
        String nombre = req.getParameter("nombre");


        //(4)Dos formas que el servidor puede obtener el parametro
        //Obtenemos el id (el cliente optiene el parametro "string" de nuestro id)
        //String idString = req.getParameter("id");
        //(4.1) Tenemos que trasformar ese tipo de dato castear
        //int numero = Integer.parseInt(idString);

        //(4.1)o simplemente en una linea de código casteamos y obtenemos
        //El servidor me va a responder con el metodo getWriter()
        //Me permite imprimir en pantalla la información
        //int id = Integer.parseInt(req.getParameter("id"));
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            System.out.println("El id no fue ingresado.");
        }




        PrintWriter out = resp.getWriter();
        //El servidor responde con el contenido
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola Saludando desde el servlet</h1>");
        //Imprimoparametro Paso 3
        out.println("<br>");
        out.println("El nombre del estudiante es: " + nombre);
        out.println("<br>");
        //imprimirmos el id de la persona oestudiante
        out.println("El id del estudiante es: " + id);
        out.println("</body>");
        out.println("</html>");



    }
}


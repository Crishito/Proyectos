package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletFormulario")
public class Formulario extends HttpServlet {

    //recibe 2 objetos
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //S1ervidor me va a responder con el formulatio
        resp.setContentType("text/html");
        //obtenemos los parametros
        String usuario = req.getParameter("usuario");
        String clabe = "98765";
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Formulario</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Formulario</h1>");
        out.println("<h2>");

        // Verifica la contraseña y muestra el mensaje correspondiente
        if ("98765".equals(password)) {
            out.println("Bienvenido a mi aplicación " + usuario+".");
        } else {
            out.println("No estás autorizado a ver el contenido.");
        }

        out.println("</h2>");
        out.println("</body>");
        out.println("</html>");


        /*
         * La aplicación debe comparar la contraseña que se ingreso con la que se
         * guado si las contraseñas son iguales tiene que mostrarme un mensaje que diga
         * Bienvenido a mi apliación y me mesuestra el nombre del usuario
         * Caso contrario me muestre un mensaje que diga No estas autorizado a ver el contenido
         * */

        /*
         * Crear una aplicación web donde el usuario mediante un formulario ingrese los siguinetes datos
         * Nombre->Tipo String
         * Apellido->Tipo String
         * Número de cédula -> Tipo String y tamaño de 10
         * Carrera a la que pertenece mediante un un select las carreas que deben estar en el select son las
         * siguientes: Desarrollo de software, Marketing, Multimedia, Veterinaria
         * Fecha de nacimiento:
         * Procesar los datos en un Servlet:
         * 1. Verificar si la cédula ingresada es válida o no
         * 2. Calcular la edad del estudiante y mostrarla en el siguiente formato:
         * años, meses y dias.
         * Entregables: formato de tareas, onde se tendra el código copiado y pegado, salida en pantalla
         * con el enlace de github. En formato pdf*/




    }
}

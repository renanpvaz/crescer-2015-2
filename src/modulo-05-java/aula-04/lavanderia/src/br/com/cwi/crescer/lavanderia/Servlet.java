package br.com.cwi.crescer.lavanderia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet", urlPatterns = { "/servlet" })
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String mensagem = "Esta página é mt tri";

        request.setAttribute("mensagem", mensagem);

        request.getRequestDispatcher("pagina.jsp")
                .forward(request, response);
    }

}

package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import model.DAO;
import model.Usuario;
import model.Venda;

@WebServlet(urlPatterns = {
    "/controller", "/main", "/insert", "/login"
})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DAO dao = new DAO();
    Usuario usuario = new Usuario();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if (action.equals("/main")) {
            usuarios(request, response);
        } else if (action.equals("/insert")) {
            novoUsuario(request, response);
        } else if (action.equals("/login")) {
            request.getRequestDispatcher("login.html").forward(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            login(request, response);
        }
    }

    protected void usuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Usuario> lista = dao.listarUsuarios();
        request.setAttribute("usuarios", lista);
        jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.forward(request, response);
    }

    protected void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        dao.inserirUsuario(usuario);
        response.sendRedirect("main");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean loginValido = dao.verificarLogin(email, senha);
        if (loginValido) {
            HttpSession session = (HttpSession) request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("menu.html");
        } else {
            request.setAttribute("erro",  "Email ou Senha Inválidos");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}

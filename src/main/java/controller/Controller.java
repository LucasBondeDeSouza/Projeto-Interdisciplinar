package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.http.HttpSession;
import model.DAO;
import model.Usuario;
import model.Venda;

@WebServlet(urlPatterns = {
    "/controller", "/main", "/insert", "/login", "/cadastrarVenda"
})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DAO dao = new DAO();
    Usuario usuario = new Usuario();
    Venda venda = new Venda();

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
        } else if (action.equals("/cadastrarVenda")) {
        	novaVenda(request, response);
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
        String senha = request.getParameter("senha");
        usuario.setCargo(request.getParameter("cargo"));
        
        if (senha != null) {
        	usuario.setSenha(senha);
        	dao.inserirUsuario(usuario);
        	response.sendRedirect("main");
        } else {
        	String mensagemErro = "A senha é obrigatória. Preencha todos os campos.";
            request.setAttribute("erro", mensagemErro);
            request.getRequestDispatcher("login.html").forward(request, response);
        }
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
    
    protected void novaVenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	venda.setComprador(request.getParameter("comprador"));
    	venda.setCategoria(request.getParameter("categoria"));
    	venda.setNomeProduto(request.getParameter("nomeProduto"));
    	venda.setDataVenda(request.getParameter("dataVenda"));
    	venda.setQuantidade(request.getParameter("quantidade"));
    	venda.setValorUnitario(request.getParameter("valorUnitario"));
    	
    	dao.inserirVenda(venda);
    	
    	vendas(request, response);
    	response.sendRedirect("cadastrarVenda.html");
    }
    
    protected void vendas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Venda> lista = dao.listarVendas();
        request.setAttribute("vendas", lista);
        jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("cadastrarVenda.html");
        rd.forward(request, response);
    }
}
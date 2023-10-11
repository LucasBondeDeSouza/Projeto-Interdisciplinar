package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    // Parâmetros de Conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/dbvendas?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "bondelucas";

    // Método de Conexão
    private Connection conectar() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void inserirUsuario(Javabeans usuario) {
        String create = "insert into usuarios (nome, email, senha) values (?,?,?)";

        try {
            // Abrir a conexão
            Connection con = conectar();

            // Preparar a Query para execução no Banco de Dados
            PreparedStatement pst = con.prepareStatement(create);

            // Substituir os parametros (?) pelo conteúdo das variáveis Javabeans
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());

            // Executar a Query
            pst.executeUpdate();

            // Encerrar a conexão com o Banco
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Javabeans> listarUsuarios() {
        ArrayList<Javabeans> usuarios = new ArrayList<>();
        String read = "select * from usuarios order by nome";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String iduser = rs.getString(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String senha = rs.getString(4);

                usuarios.add(new Javabeans(iduser, nome, email, senha));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarios;
    }

    public boolean verificarLogin(String email, String senha) {
        String query = "SELECT * FROM usuarios WHERE email=? AND senha=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            boolean loginValido = rs.next();

            con.close();

            return loginValido;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}

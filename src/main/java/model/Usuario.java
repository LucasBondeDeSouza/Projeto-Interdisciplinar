package model;

public class Usuario {

	private String iduser;
	private String nome;
	private String email;
	private String senha;
	
	// Constructors
	public Usuario(String iduser, String nome, String email, String senha) {
		super();
		this.iduser = iduser;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {
		super();
	}
	
	// Getters and Setters
	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
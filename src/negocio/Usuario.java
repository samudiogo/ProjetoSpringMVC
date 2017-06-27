package negocio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private String email;
	
	public Usuario(int id, String nome, String login, String senha, String email) {
		this(nome, email, login, senha);
		this.id = id;
		this.email = email;
	}
	public Usuario(String nome, String email, String login, String senha) {
		this(login,senha);
		this.setNome(nome);
		this.setEmail(email);
	}
	public Usuario(String login, String senha) {
		this.setLogin(login);
		this.setSenha(senha);
	}
	public Usuario(int id, String email){
		this.setId(id);
		this.setEmail(email);
	}
	public Usuario() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

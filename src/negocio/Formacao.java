package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Formacao")
public class Formacao {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private String curso;
	@Column(name="ano", nullable=false)
	private int anoInicio;
	
	
	public Formacao(int id, String curso, int anoInicio) {
		this.setId(id);
		this.setCurso(curso);
		this.setAnoInicio(anoInicio);
	}
	
	public Formacao() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getAnoInicio() {
		return anoInicio;
	}
	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
}

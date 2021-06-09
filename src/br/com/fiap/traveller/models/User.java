package br.com.fiap.traveller.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "TB_USUARIO")
@SequenceGenerator(name = "usuarios", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class User {
	@Id
	@GeneratedValue(generator = "usuarios", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_usuario")
	private Long id;
	
	@Column(name = "nm_usuario", nullable = false, length = 60)
	private String name;
	
	@Column(name = "ds_email", nullable = false, length = 60)
	private String email;
	
	@Column(name = "nr_cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "ds_senha", nullable = false, length = 16)
	private String password;
	
	@OneToMany
	@JoinTable(name = "TB_RESERVA",
			   joinColumns = @JoinColumn(name = "cd_usuario"))
	private List<Reserve> reserves;
	
	@OneToMany
	@JoinTable(name = "TB_AVALIACAO",
			   joinColumns = @JoinColumn(name = "cd_usuario"))
	private List<Rating> comments;
	
	
	public User() {
	}
	
	
	
	public User(Long id, String name, String email, String cpf, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Reserve> getReserves() {
		return reserves;
	}
	public void setReserves(List<Reserve> reserves) {
		this.reserves = reserves;
	}
	

}

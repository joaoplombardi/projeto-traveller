package br.com.fiap.traveller.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "TB_LOCALIZACAO")
@SequenceGenerator(name = "localizacao", sequenceName = "SQ_TB_LOCALIZACAO", allocationSize = 1)
public class Location {
	
	@Id
	@Column(name = "cd_localizacao")
	@GeneratedValue(generator = "localizacao", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nm_logradouro", nullable = false, length = 70)
	private String name;
	
	@Column(name = "nr_logradouro", nullable = false)
	private Integer number;
	
	@Column(name = "ds_maps")
	private String maps;
	
	@OneToOne
	@JoinColumn(name = "cd_hotel", nullable = false)
	private Hotel hotel;
	
	
	
	public Location() {
	}

	public Location(Long id, String name, Integer number, String maps, Hotel hotel) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.maps = maps;
		this.hotel = hotel;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getMaps() {
		return maps;
	}

	public void setMaps(String maps) {
		this.maps = maps;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	
}

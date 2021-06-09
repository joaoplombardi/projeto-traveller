package br.com.fiap.traveller.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "TB_RESERVA")
@SequenceGenerator(name = "reservas", sequenceName = "SQ_TB_RESERVA")
public class Reserve {
	
	@Id
	@Column(name = "cd_reserva")
	@GeneratedValue(generator = "reservas", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_entrada")
	private LocalDate checkIn;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_saida")
	private LocalDate checkOut;
	
	@ManyToOne
	@JoinColumn(name = "cd_user", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "cd_hotel", nullable = false)
	private Hotel hotel;
	
	@Column(name = "vl_total", nullable = false)
	private BigDecimal total;
	
	public Reserve() {
	}

	public Reserve(Long id, LocalDate checkIn, LocalDate checkOut, User user, Hotel hotel, BigDecimal total) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.user = user;
		this.hotel = hotel;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}

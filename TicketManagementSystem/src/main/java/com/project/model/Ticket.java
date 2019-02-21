package com.project.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tickets")

public class Ticket {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "no_of_seats")

	private Integer noOfSeats;
	@ManyToOne
	@JoinColumn(name = "th_srn_shw_id")
	private TheatreScreenShow theatreScreenShows;

	@Column(name = "date")
	private LocalDate date;
	@Column(name = "status")

	private String status;
	@Column(name = "totalcost")

	private Integer totalCost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public TheatreScreenShow getTheatreScreenShows() {
		return theatreScreenShows;
	}

	public void setTheatreScreenShows(TheatreScreenShow theatreScreenShows) {
		this.theatreScreenShows = theatreScreenShows;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(Integer noOfSeats, TheatreScreenShow theatreScreenShows, LocalDate date, String status, Integer totalCost) {
		super();
		this.noOfSeats = noOfSeats;
		this.theatreScreenShows = theatreScreenShows;
		this.date = date;
		this.status = status;
		this.totalCost = totalCost;
	}

}

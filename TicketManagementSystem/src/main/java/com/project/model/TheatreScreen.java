package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="theatre_screen")

public class TheatreScreen {
	@Id
	 @Column(name = "id") 
	private Integer id;
	 @Column(name = "name") 
	private String name;
	 @Column(name = "total_tickets") 
	private Integer totalTickets;

	 @ManyToOne
	 @JoinColumn(name="theatre_id")
	private Theatre theatre;
	 
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(Integer totalTickets) {
		this.totalTickets = totalTickets;
	}

	public TheatreScreen(Integer id, String name, Integer totalTickets) {
		super();
		this.id = id;
		this.name = name;
		this.totalTickets = totalTickets;
	}

	public TheatreScreen() {
		// TODO Auto-generated constructor stub
	}
}

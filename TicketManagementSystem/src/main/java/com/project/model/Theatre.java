package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theatre")

public class Theatre {
	@Id
	 @Column(name = "id") 
	private Integer id;
	 @Column(name = "name") 
	private String name;
	 @Column(name = "no_of_screens") 
	private Integer noOfScreens;
	 @Column(name = "ticket_cost") 
	private Integer ticketCost;

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

	public Integer getNoOfScreens() {
		return noOfScreens;
	}

	public void setNoOfScreens(Integer noOfScreens) {
		this.noOfScreens = noOfScreens;
	}

	public Integer getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Theatre(Integer id, String name, Integer noOfScreens, Integer ticketCost) {
		super();
		this.id = id;
		this.name = name;
		this.noOfScreens = noOfScreens;
		this.ticketCost = ticketCost;
	}

	public Theatre() {
		super();
	}

}

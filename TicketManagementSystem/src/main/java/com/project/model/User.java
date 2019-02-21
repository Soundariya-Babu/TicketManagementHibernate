package com.project.model;

import java.time.LocalDate;

public class User {
	private int id;
	private int noOfSeats;
	private int showId;
	private LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User(int id, int noOfSeats, int showId, LocalDate date) {
		super();
		this.id = id;
		this.noOfSeats = noOfSeats;
		this.showId = showId;
		this.date = date;
	}

	public User() {
	}
}

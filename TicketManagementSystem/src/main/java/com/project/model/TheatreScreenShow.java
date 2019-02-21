package com.project.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="theatre_screen_shows")
@JsonInclude(Include.NON_NULL)

public class TheatreScreenShow {
	@Id
	 @Column(name = "id") 
	private Integer id;
	 @Column(name = "start_time") 
	private LocalTime startTime;
	 @Column(name = "end_time") 
	private LocalTime endTime;
	 
	 @ManyToOne
	 @JoinColumn(name="theatre_screen_id")
	private TheatreScreen theatreScreen;

	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TheatreScreen getTheatreScreen() {
		return theatreScreen;
	}

	public void setTheatreScreen(TheatreScreen theatreScreen) {
		this.theatreScreen = theatreScreen;
	}

	public TheatreScreenShow(LocalTime startTime, LocalTime endTime, TheatreScreen theatreScreen) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.theatreScreen = theatreScreen;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public TheatreScreenShow() {
		// TODO Auto-generated constructor stub
	}

}

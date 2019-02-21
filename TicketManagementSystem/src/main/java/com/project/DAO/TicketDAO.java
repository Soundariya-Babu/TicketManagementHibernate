package com.project.DAO;

import java.time.LocalDate;
import java.util.List;

import com.project.DAO.exception.DataAccessException;
import com.project.model.TheatreScreenShow;
import com.project.model.Ticket;

public interface TicketDAO {
	public Integer bookTicket(Ticket t)throws DataAccessException;
	public Integer selectSeatsByDate(Integer id, LocalDate lc) throws DataAccessException;
	public TheatreScreenShow getTheatreScreenShows(Integer id) throws DataAccessException;
	public void cancelTicket(Ticket t) throws DataAccessException;
	public LocalDate getDate(Integer id) throws DataAccessException;
    public List<Ticket> listTicketsConfirmed(String status,LocalDate date) throws DataAccessException;

	
}

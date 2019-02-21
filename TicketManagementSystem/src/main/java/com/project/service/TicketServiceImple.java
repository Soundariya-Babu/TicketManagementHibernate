package com.project.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.project.DAO.TicketDAO;
import com.project.DAO.exception.DataAccessException;
import com.project.model.TheatreScreenShow;
import com.project.model.Ticket;
import com.project.model.User;
import com.project.service.exception.ServiceErrorException;
import com.project.service.exception.ServiceLayerException;

@Service
public class TicketServiceImple implements TicketService {
	@Autowired
	private TicketDAO ticketDAO;

	@Override
	public String insertTicket(User user) throws ServiceErrorException,ServiceLayerException {
		String successMessage= "";
		TheatreScreenShow theatreScreenShow = new TheatreScreenShow();
		theatreScreenShow.setId(user.getShowId());
		Ticket ticket = new Ticket(user.getNoOfSeats(), theatreScreenShow, user.getDate(), "nil", 0);

		String message = "InternalServiceError";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalTime startTime;
		try {
			TheatreScreenShow theatreScreenShows=ticketDAO.getTheatreScreenShows(ticket.getTheatreScreenShows().getId());

			startTime =theatreScreenShows.getStartTime();
		
		if (currentTime.isAfter(startTime)) {
			message = "Sorry! The specified show is already started";
			throw new ServiceErrorException(message);
		}

		if (ticket.getNoOfSeats() > 10) {
			message = "You can book only 10 tickets ";
			throw new ServiceErrorException(message);
		}
		if (!currentDate.equals(ticket.getDate())) {
			message = "Enter the current date";
			throw new ServiceErrorException(message);
		}
		Integer filledSeats = 0;
		filledSeats = ticketDAO.selectSeatsByDate(ticket.getTheatreScreenShows().getId(), currentDate);
		Integer totalTicketCount = theatreScreenShows.getTheatreScreen().getTotalTickets();
		Integer fillingSeats = filledSeats + ticket.getNoOfSeats();

		if (fillingSeats > totalTicketCount) {
			int ticketsAvailable;
			ticketsAvailable = totalTicketCount - filledSeats;
			if (ticketsAvailable < 1) {
				message = "Tickest not available for the selected show";
			} else {
				if (ticketsAvailable == 1) {
					message = "Only one ticket is available for the selected show";
					throw new ServiceErrorException(message);
				} else {
					message = "Only " + ticketsAvailable + " tickets are available for the selected show";
					throw new ServiceErrorException(message);
				}

			}
		}
		String Status = "Confirmed";
		Integer cost = theatreScreenShows.getTheatreScreen().getTheatre().getTicketCost();
		Integer totalCost = ticket.getNoOfSeats() * cost;
		ticket.setStatus(Status);
		ticket.setTotalCost(totalCost);
		Integer ticketId = ticketDAO.bookTicket(ticket);
		if (ticketId > 0) {

			successMessage = "Your booking is confirmed." + "Your ticket id is " + ticketId + " and total ticket cost is "
					+ totalCost;
			return successMessage;
		}
		return successMessage;
	}
		catch (DataAccessException e) {
			throw new ServiceLayerException(e);
		}
	}
	

	@Override
	public String cancelTicketBooked(Integer id, Integer showId) throws ServiceErrorException,ServiceLayerException {
		String successMessage = "";
		String message = "InternalServiceError";
		LocalTime currentTime = LocalTime.now();
		LocalDate currentDate = LocalDate.now();
		LocalDate bookingDate;
		try {
			
			bookingDate = ticketDAO.getDate(id);
		
		
		if (currentDate.equals(bookingDate)) {
			TheatreScreenShow theatreScreenShows=ticketDAO.getTheatreScreenShows(showId);

			LocalTime startTime =theatreScreenShows.getStartTime();
			if (currentTime.isAfter(startTime)) {
				message = "The show already started you are not allowed to cancel the tickets";
				throw new ServiceErrorException(message);
			}

			else if (currentTime.isBefore(startTime.minusMinutes(10))) {
				String status = "cancelled";
				Integer ticketcost = 0;
				Integer no_of_seats = 0;
				Ticket t = new Ticket();
				t.setId(id);
				t.setNoOfSeats(no_of_seats);
				t.setStatus(status);
				t.setTotalCost(ticketcost);
				ticketDAO.cancelTicket(t);
				successMessage = "Your tickets has been cancelled successfully";
				return successMessage;
			} else {
				message = "Sorry, you cannot cancel this ticket, as the show is going to start in 10 mins";
				throw new ServiceErrorException(message);
			}

		} else {
			message = "The specified show is over";
			throw new ServiceErrorException(message);
		}
		
	} catch (DataAccessException e) {
		throw new ServiceLayerException(e);

	}
	}

	
	
	@Override
	public List<Ticket> listOfTicketsConfirmed() throws ServiceLayerException {
		List<Ticket> ticketList;
		List<Ticket> tlist = new ArrayList<Ticket>();


		try {
			String status="Confirmed";
			LocalDate currentDate= LocalDate.now();
			ticketList=ticketDAO.listTicketsConfirmed(status,currentDate);
			for(Ticket ticket : ticketList)
			{
			Integer id=	ticket.getId();
			Integer noOfSeats=ticket.getNoOfSeats();
			Integer showId=ticket.getTheatreScreenShows().getId();
			TheatreScreenShow tss=new TheatreScreenShow();
			tss.setId(showId);
			Integer totalCost=ticket.getTotalCost();
			LocalDate date1=ticket.getDate();
			Ticket t1=new Ticket();
			t1.setId(id);
			t1.setNoOfSeats(noOfSeats);
			t1.setDate(date1);
			t1.setTheatreScreenShows(tss);
			t1.setTotalCost(totalCost);
			t1.setStatus(status);
			tlist.add(t1);
			}
			
		} catch (DataAccessException e) {
			throw new ServiceLayerException(e);

		}
		return tlist;
	}
}

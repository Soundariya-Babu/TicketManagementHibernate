package com.project.service;

import java.util.List;

import com.project.model.Ticket;
import com.project.model.User;
import com.project.service.exception.ServiceErrorException;
import com.project.service.exception.ServiceLayerException;

public interface TicketService {

	public String insertTicket(User user) throws ServiceErrorException,ServiceLayerException;

	public String cancelTicketBooked(Integer id, Integer showId) throws ServiceErrorException, ServiceLayerException;
	
	public List<Ticket> listOfTicketsConfirmed() throws ServiceLayerException;


}

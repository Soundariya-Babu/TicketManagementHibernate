package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.project.model.Ticket;
import com.project.model.User;
import com.project.service.TicketService;
import com.project.service.exception.ServiceErrorException;
import com.project.service.exception.ServiceLayerException;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@PostMapping
	public ResponseEntity<String> store(@RequestBody User user) {
		try {
			String message = ticketService.insertTicket(user);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (ServiceErrorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (ServiceLayerException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<String> cancelTicket(@RequestBody User user) {
		try {
			String message = ticketService.cancelTicketBooked(user.getId(), user.getShowId());
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (ServiceErrorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);

		} catch (ServiceLayerException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
    
	
	}

	@GetMapping
	public ResponseEntity<List<Ticket>>  listTickets() {
		List<Ticket> ticketList;
		try
		{
 	        ticketList=ticketService.listOfTicketsConfirmed();
			return new ResponseEntity<List<Ticket>>( ticketList,HttpStatus.OK);
		}
		catch (ServiceLayerException e) {
			return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
   	
	}
	}


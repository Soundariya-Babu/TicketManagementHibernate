package com.project.DAO;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.DAO.exception.DataAccessException;
import com.project.model.TheatreScreenShow;
import com.project.model.Ticket;

@Repository
public class TicketDAOImple implements TicketDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// private static Log logger = LogManager.getLogger(TicketDaoImple.class);

	public Integer bookTicket(Ticket t) throws DataAccessException {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(t);
			Integer ticketId = t.getId();
			System.out.println(ticketId);
			transaction.commit();
			session.close();
			return ticketId;
		} catch (Exception e) {
			throw new DataAccessException(e);
		}

	}

	public Integer selectSeatsByDate(Integer id, LocalDate date) throws DataAccessException {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			@SuppressWarnings("rawtypes")
			Query query = session
					.createQuery("SELECT SUM(noOfSeats) FROM Ticket WHERE theatreScreenShows.id=:id  AND date=:date");
			query.setParameter("id", id);
			query.setParameter("date", date);
			Long sumOfSeats = (Long) query.uniqueResult();
			transaction.commit();
			session.close();
			return sumOfSeats.intValue();

		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public TheatreScreenShow getTheatreScreenShows(Integer id) throws DataAccessException {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			TheatreScreenShow theatreScreenShow = session.get(TheatreScreenShow.class, id);
			transaction.commit();
			session.close();
			return theatreScreenShow;
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public void cancelTicket(Ticket t) throws DataAccessException {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(t);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public LocalDate getDate(Integer id) throws DataAccessException {
		try {

			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Ticket tickets = session.get(Ticket.class, id);
			transaction.commit();
			session.close();
			return tickets.getDate();
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public List<Ticket> listTicketsConfirmed(String status, LocalDate date) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Ticket> query = session.createQuery(
				"from Ticket WHERE status=:status  AND date=:date ");
		query.setParameter("status", status);
		query.setParameter("date", date);
		List<Ticket> ticketList = query.list();
		tx.commit();
		session.close();

		return ticketList;
	}

}

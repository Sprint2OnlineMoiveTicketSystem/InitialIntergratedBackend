package com.sprint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
	private int bookingId;
	private int movieId;
	private int showId;
	private LocalDate bookingDate;
	private int transactionId;
	private double totalCost;
    private Ticket ticket;
	
	@OneToOne(targetEntity = Show.class, cascade = CascadeType.ALL)
	private Show showref;
	
	@OneToMany(targetEntity = Seat.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_fk", referencedColumnName = "bookingId")
	private List<Seat> seats;

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}

	/**
	 * @param showId the showId to set
	 */
	public void setShowId(int showId) {
		this.showId = showId;
	}

	/**
	 * @return the bookingDate
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the showref
	 */
	public Show getShowref() {
		return showref;
	}

	/**
	 * @param showref the showref to set
	 */
	public void setShowref(Show showref) {
		this.showref = showref;
	}

	/**
	 * @return the seats
	 */
	public List<Seat> getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	/**
	 * @param movieId
	 * @param showId
	 * @param bookingDate
	 * @param transactionId
	 * @param totalCost
	 * @param ticket
	 * @param showref
	 * @param seats
	 */
	public Booking(int movieId, int showId, LocalDate bookingDate, int transactionId, double totalCost, Ticket ticket,
			Show showref, List<Seat> seats) {
		super();
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.ticket = ticket;
		this.showref = showref;
		this.seats = seats;
	}

	public Booking()
	{
		super();
	}
	
}

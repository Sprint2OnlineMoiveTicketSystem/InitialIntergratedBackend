package com.sprint.service;

import java.util.List;

import com.sprint.model.Booking;
import com.sprint.model.Seat;

public interface BookingService {

	public String cancelBooking(int id);
	public Seat chooseSeat(Seat seat);
	List<Booking> getallBooking(Booking booking);
}

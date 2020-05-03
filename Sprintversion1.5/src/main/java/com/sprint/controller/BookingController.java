package com.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.model.Booking;
import com.sprint.model.Seat;
import com.sprint.service.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingController {

	@Autowired
	BookingService bservice;
	
	@RequestMapping(value = "/cancelBooking/{bookingId}", method = RequestMethod.DELETE)
	public String cancelBooking(@PathVariable("bookingId") Integer bookingId) {
		return bservice.cancelBooking(bookingId);
	}
	
	@RequestMapping(value = "/chooseSeat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Seat chooseSeat(@RequestBody Seat seat) {
		return bservice.chooseSeat(seat);
	}
	
	@RequestMapping(value = "/getAllBookings" , method = RequestMethod.GET)
	public List<Booking> getAllBooking(@RequestBody Booking booking){
		return bservice.getallBooking(booking);
		
	}
	
	//@RequestMapping(value = "/calculateTotalCost")
	
}

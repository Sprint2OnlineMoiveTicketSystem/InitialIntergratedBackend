package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.BookingDao;
import com.sprint.dao.SeatDao;
import com.sprint.dao.TicketDao;
import com.sprint.error.SeatNotVacant;
import com.sprint.model.Booking;
import com.sprint.model.BookingState;
import com.sprint.model.Seat;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bdao;

	@Autowired
	TicketDao tdao;
	
	@Autowired
	SeatDao sdao;
	
	@Override
	public String cancelBooking(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> booking = bdao.findById(id) ;
		if(!booking.isPresent() || booking == null) {
			return "No booking found for given id!" ;
		}
		bdao.deleteById(id);
		return "Booking Deleted Successfully!";
	}

	@Override
	public Seat chooseSeat(Seat seat) throws SeatNotVacant {
		// TODO Auto-generated method stub
		Optional<Seat> findById = sdao.findById(seat.getSeatId());
		try {
			
				if((findById.isPresent()) && (findById.get().getSeatStatus().equals(seat.getSeatStatus().AVAILABLE))) {
						findById.get().setSeatStatus(BookingState.BOOKED);
						sdao.save(seat);
					}else
						throw new SeatNotVacant("Seat is already Booked");
				
		}catch(SeatNotVacant s) {
			
			throw new SeatNotVacant("Seat is Not Vacant");
			
		}
		return null;
	}

	@Override
	public List<Booking> getallBooking(Booking booking) {
		// TODO Auto-generated method stub
			List<Booking> bookings = bdao.findAll();
			return bookings;
	}

}

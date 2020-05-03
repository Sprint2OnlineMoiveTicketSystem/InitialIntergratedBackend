package com.sprint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.SeatDao;
import com.sprint.error.SeatIsBooked;
import com.sprint.error.SeatNotFound;
import com.sprint.model.BookingState;
import com.sprint.model.Seat;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	SeatDao sdao;
	@Override
	public String blockSeat(Seat seat) {
		// TODO Auto-generated method stub
		Optional<Seat> findbyId = sdao.findById(seat.getSeatId());
		if(findbyId.isPresent() && findbyId.get().getSeatStatus().equals(BookingState.AVAILABLE)) {
			findbyId.get().setSeatStatus(BookingState.BLOCKED);
			return "The Seat is Blocked";
		}
		else
			return "Seat is available";
	}

	@Override
	public Seat bookSeat(Seat seat) {
		// TODO Auto-generated method stub
		Optional<Seat> seatFindId = sdao.findById(seat.getSeatId());
			try {
				if(seatFindId.isPresent())
					throw new SeatIsBooked("Seat is already Booked");
			} catch (SeatIsBooked e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seatFindId.get().setSeatStatus(BookingState.BOOKED);
		return sdao.save(seat);
	}

	@Override
	public String cancelSeat(int sid) {
		// TODO Auto-generated method stub
		Optional<Seat> seat = sdao.findById(sid);			
		try {
			if(!seat.isPresent() || seat == null) {
				throw new SeatNotFound("Seat is not found by given ID");
			}
		} catch(SeatNotFound e) {
			e.printStackTrace();
		}
		sdao.deleteById(sid);
		seat.get().setSeatStatus(BookingState.AVAILABLE);
		return "Seat is Cancelled";
	}

}

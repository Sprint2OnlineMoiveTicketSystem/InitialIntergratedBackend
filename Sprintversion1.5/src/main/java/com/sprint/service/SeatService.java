package com.sprint.service;

import com.sprint.model.Seat;

public interface SeatService {
	
	public String blockSeat(Seat seat);
	public Seat bookSeat(Seat seat);
	public String cancelSeat(int sid);
}

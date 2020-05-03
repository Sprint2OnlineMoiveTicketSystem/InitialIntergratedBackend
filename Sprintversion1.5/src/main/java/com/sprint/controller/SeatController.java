package com.sprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.model.Seat;
import com.sprint.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	SeatService seatService;
	
	@RequestMapping(value = "/bookSeat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Seat bookSeat(@RequestBody Seat seat) {
		return seatService.bookSeat(seat);
	}
	
	@RequestMapping(value = "/cancelSeat/{seatId}", method = RequestMethod.DELETE)
	public String cancelSeat(@PathVariable("seatId") Integer sid) {
		return seatService.cancelSeat(sid);
	}
	
	@RequestMapping(value = "/blockSeat/{seatId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String blockSeat(@RequestBody Seat seat) {
		return seatService.blockSeat(seat);
	}
	
}

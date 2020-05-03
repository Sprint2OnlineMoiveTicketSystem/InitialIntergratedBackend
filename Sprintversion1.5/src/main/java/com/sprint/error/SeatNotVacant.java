package com.sprint.error;

public class SeatNotVacant extends RuntimeException {

	public SeatNotVacant(String msg) {
		super(msg);
	}
}

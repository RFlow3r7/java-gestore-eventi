package it.java.gestore.eventi;		
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

	public class Event {
		
		private String Title;
		private LocalDateTime Data;
		private int totSeats;
		private int bookedSeats = 0;
		
		
		
		public Event (String Title, LocalDateTime Data, int totSeats) {
			
			this.Title = Title;
			this.Data = Data;
			this.totSeats = totSeats;
			assert this.Data.isAfter(LocalDateTime.now()) : "This time is past due";
			
			
	}
	
	
	
	
	}
	
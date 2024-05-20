package it.java.gestore.eventi;		
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

	public class Event {
		
		private String Title;
		private LocalDateTime Data;
		private int totSeats;
		private int bookedSeats = 0;
		
		
		
		public Event (String Title, LocalDateTime Data, int totSeats) {
			assert Data.isAfter(LocalDateTime.now()) : "This time is past due";
			this.Title = Title;
			this.Data = Data;
			this.totSeats = totSeats;
			
			}
		
		public String getTitle() {
			return this.Title;
		}
	
		public void setTitle(String Title) {
			this.Title = Title;
		
		}
		
		public LocalDateTime getData() {
			return this.Data;
			
			}
		public void setData(LocalDateTime Data) {
			this.Data = Data;
		}
		
		public int getTotSeats() {
			return this.totSeats;
		}
		
		public int getBookedSeats() {
			return this.bookedSeats;
		}
	}
	
	
	
	
	
	
	
	
	
	
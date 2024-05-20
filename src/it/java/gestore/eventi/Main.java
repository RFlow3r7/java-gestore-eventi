package it.java.gestore.eventi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
 

		  public static void main(String[] args) {
			LocalDateTime dataConcert = LocalDateTime.of(2024, 12, 11, 12, 00);
		    Event Concerto = new Event ("Concerto", dataConcert, 100);
		    Concerto.setTitle("Concert");
		    System.out.println(Concerto.getTitle());
		  }
		}

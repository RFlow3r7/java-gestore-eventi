package it.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Eventi {
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotale;
    private int numeroPostiPrenotati;

    // Costruttore per inizializzare l'evento con titolo, data e numero totale di posti
    public Eventi(String titolo, LocalDate data, int numeroPostiTotale) {
        this.titolo = titolo;
        this.numeroPostiPrenotati = 0;  // Inizialmente non ci sono prenotazioni
        this.data = data;

        // Controllo che la data non sia nel passato
        if (data.isBefore(LocalDate.now())) {
            System.out.println("La data dell'evento non può essere nel passato. Impostata data di oggi.");
            this.data = LocalDate.now();
        } else {
            this.data = data;
        }
        
        // Controllo che il numero totale di posti sia positivo
        if (numeroPostiTotale <= 0) {
            System.out.println("Il numero di posti totale deve essere positivo. Impostato a 1.");
            this.numeroPostiTotale = 1;
        } else {
            this.numeroPostiTotale = numeroPostiTotale;
        }
    }

    // Getter e setter per il titolo
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Getter per la data formattata
    public String getData() {
        return this.data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    // Setter per la data
    public void setData(LocalDate data) {
        this.data = data;
    }

    // Getter per il numero totale di posti
    public int getNumeroPostiTotale() {
        return numeroPostiTotale;
    }

    // Getter per il numero di posti prenotati
    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    // Metodo per prenotare un posto
    public String prenota() {
        if (numeroPostiPrenotati >= numeroPostiTotale) {
            return "Non ci sono posti disponibili.";
        }
        numeroPostiPrenotati++;
        return "Prenotazione effettuata con successo.";
    }

    // Metodo per disdire un numero specifico di posti
    public String disdici(int numeroPostiDaDisdire) {
        if (numeroPostiPrenotati <= 0) {
            return "Non ci sono prenotazioni da disdire.";
        }
        if (numeroPostiDaDisdire > numeroPostiPrenotati) {
            return "Non è possibile disdire più posti di quelli prenotati. Posti prenotati: " + numeroPostiPrenotati;
        }
        numeroPostiPrenotati -= numeroPostiDaDisdire;
        return "Disdetta di " + numeroPostiDaDisdire + " posti effettuata con successo.";
    }

    // Override del metodo toString per fornire una rappresentazione dell'evento
    @Override
    public String toString() {
        return "Titolo: " + titolo + "\n" +
               "Data: " + getData() + "\n" +
               "Numero totale di posti disponibili: " + numeroPostiTotale + "\n" +
               "Numero di posti prenotati: " + numeroPostiPrenotati;
    }
}

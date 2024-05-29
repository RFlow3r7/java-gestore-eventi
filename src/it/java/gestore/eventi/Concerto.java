package it.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Eventi {
    private LocalTime ora;
    private double prezzo;

    // Costruttore per inizializzare un concerto con titolo, data, numero totale di posti, ora e prezzo
    public Concerto(String titolo, LocalDate data, int numeroPostiTotale, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPostiTotale);  // Chiamata al costruttore della classe base
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // Getter e setter per l'ora
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    // Getter e setter per il prezzo
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo per ottenere l'ora formattata come stringa
    public String getOraFormattata() {
        return this.ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    // Metodo per ottenere il prezzo formattato come stringa
    public String getPrezzoFormattato() {
        return String.format("%.2f€", this.prezzo);
    }

    // Override del metodo toString per includere le informazioni specifiche del concerto
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Ora: " + getOraFormattata() + "\n" +
               "Prezzo: " + getPrezzoFormattato();
    }
}

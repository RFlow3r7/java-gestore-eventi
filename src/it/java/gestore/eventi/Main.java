package it.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dei dati dell'evento
        System.out.println("Inserisci il titolo dell'evento:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la data dell'evento (formato: dd-MM-yyyy):");
        LocalDate data = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println("Inserisci il numero totale di posti disponibili:");
        int numeroPostiTotale = scanner.nextInt();

        // Creazione dell'oggetto Eventi
        Eventi evento = new Eventi(titolo, data, numeroPostiTotale);

        // Chiedi all'utente quante prenotazioni vuole fare
        System.out.println("Quante prenotazioni vuoi fare?");
        int numeroPrenotazioni = scanner.nextInt();

        // Effettua delle prenotazioni
        for (int i = 0; i < numeroPrenotazioni; i++) {
            String risultatoPrenotazione = evento.prenota();
            System.out.println(risultatoPrenotazione);
        }

        // Chiedi all'utente quante disdette vuole fare
        System.out.println("Quante disdette vuoi fare?");
        int numeroDisdette = scanner.nextInt();

        // Effettua delle disdette
        String risultatoDisdetta = evento.disdici(numeroDisdette);
        System.out.println(risultatoDisdetta);

        // Stampare l'evento prenotato
        System.out.println("Evento prenotato:");
        System.out.println(evento);

        // Chiedi all'utente se l'evento è un concerto
        System.out.println("L'evento è un concerto? (si/no):");
        scanner.nextLine(); // Consuma il newline pendente
        String risposta = scanner.nextLine();

        if (risposta.equals("si")) {
            System.out.println("Inserisci l'ora del concerto (formato: HH:mm):");
            LocalTime ora = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));

            System.out.println("Inserisci il prezzo del concerto:");
            double prezzo = scanner.nextDouble();

            Concerto concerto = new Concerto(titolo, data, numeroPostiTotale, ora, prezzo);

            // Effettua le stesse prenotazioni e disdette sull'oggetto Concerto
            for (int i = 0; i < numeroPrenotazioni; i++) {
                concerto.prenota();
            }
            concerto.disdici(numeroDisdette);

            // Stampare l'evento prenotato come concerto
            System.out.println("Il tuo evento prenotato è un Concerto:");
            System.out.println(concerto);
        }

        // Chiudere lo scanner
        scanner.close();
    }
}

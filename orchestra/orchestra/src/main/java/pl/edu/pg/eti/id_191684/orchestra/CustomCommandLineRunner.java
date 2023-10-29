package pl.edu.pg.eti.id_191684.orchestra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.service.*;

import java.util.Scanner;
import java.util.UUID;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private final InstrumentService instrumentService;
    private final SectionService sectionService;

    @Autowired
    public CustomCommandLineRunner(InstrumentService instrumentService, SectionService sectionService) {
        this.instrumentService = instrumentService;
        this.sectionService = sectionService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. List Categories");
            System.out.println("2. List Instruments");
            System.out.println("3. Add Instrument");
            System.out.println("4. Delete Instrument");
            System.out.println("5. Exit");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    listSections();
                    break;
                case 2:
                    listInstruments();
                    break;
                case 3:
                    addInstrument(scanner);
                    break;
                case 4:
                    deleteInstrument(scanner);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Finishing...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

        scanner.close();
    }

    private void listSections() {
        System.out.println("Sections:");
        sectionService.getAllSections().forEach(section -> System.out.println(section));
    }

    private void listInstruments() {
        System.out.println("Instruments:");
        instrumentService.getAllInstruments().forEach(instrument -> System.out.println(instrument));
    }

    private void addInstrument(Scanner scanner) {
        System.out.print("Enter Instrument Name: ");
        String instrumentName = scanner.nextLine();

        System.out.print("Enter Instrument Production Year: ");
        int instrumentProductionYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Available Sections:");
        sectionService.getAllSections().forEach(section -> System.out.println(section));
        System.out.print("Enter Section ID: ");
        UUID categoryId = UUID.fromString(scanner.nextLine());

        Section section = sectionService.getSectionById(categoryId);
        if (section != null) {
            Instrument instrument = new Instrument(instrumentName, instrumentProductionYear, section);
            instrumentService.saveInstrument(instrument);
            System.out.println("Instrument added successfully!");
        } else {
            System.out.println("Invalid Section. Instrument not added.");
        }
    }

    private void deleteInstrument(Scanner scanner) {
        System.out.print("Enter Instrument ID to Delete: ");
        UUID instrumentId = UUID.fromString(scanner.nextLine());

        Instrument instrument = instrumentService.getInstrumentById(instrumentId);
        if (instrument != null) {
            instrumentService.deleteInstrument(instrumentId);
            System.out.println("Instrument deleted successfully!");
        } else {
            System.out.println("Instrument not found with ID: " + instrumentId);
        }
    }
}

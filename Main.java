import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


class Odliczanie {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println("Podaj datę i czas na którym Ci zależy :)  (format: yyyy-MM-dd HH:mm:ss): ");
            String targetDateTimeString = scanner.nextLine();

            LocalDateTime targetDateTime = LocalDateTime.parse(targetDateTimeString, formatter);

            while (true) {
                LocalDateTime now = LocalDateTime.now();

                if (now.isAfter(targetDateTime)) {
                    System.out.println("Odliczanie zakończone!");
                    break;
                }

                Duration duration = Duration.between(now, targetDateTime);

                long lata = duration.toDays() / 365;
                long miesiace = (duration.toDays() % 365) / 30;
                long tygodnie = (duration.toDays() % 30) / 7;
                long dni = duration.toDays() % 7;
                long godziny = duration.toHours() % 24;
                long minuty = duration.toMinutes() % 60;
                long sekundy = duration.getSeconds() % 60;

                System.out.printf("Pozostało: %d Lat, %d Miesięcy, %d Tygodni, %d Dni, %d Godzin, %d Minut, %d Sekund%n",
                        lata, miesiace, tygodnie, dni, godziny, minuty, sekundy);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }
    }
//Kacper 168936

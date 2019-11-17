import java.time.*;
import java.time.temporal.ChronoUnit;

public class main {

    public static void main(String[] args) {

        // Instant
        System.out.println(Instant.now());
        System.out.println(Instant.now().atZone(ZoneId.of("America/New_York")));
        Instant timestamp = Instant.from(Instant.now().atZone(ZoneId.systemDefault()));
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());

        //Duration
        Duration gap = Duration.ofHours(4);
        System.out.println(timestamp.plus(gap));

        //Period
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1989, Month.APRIL, 26);

        LocalDate nextBDay = birthday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +
                p.getDays() + " days until your next birthday. (" +
                p2 + " total)");
    }
}

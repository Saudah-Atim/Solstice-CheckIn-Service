import java.util.HashSet;
import java.util.Set;

class CheckInService {

    static Set<String> checkedInAttendees = new HashSet<>();

    public static void checkIn(String attendeeId, String attendeeName) {

        if (checkedInAttendees.contains(attendeeId)) {
            System.out.println(attendeeName + " is already checked in. No second badge.");
            return;
        }

        System.out.println("Scanning: " + attendeeName + " (" + attendeeId + ")");

        boolean printed = PrinterAPI.printBadge(attendeeId);

        if (printed) {
            checkedInAttendees.add(attendeeId);
            System.out.println(attendeeName + " CHECKED IN");
        }
    }

    public static void main(String[] args) {

        checkIn("ATT1001", "Saudah");
        checkIn("ATT1002", "Mercy");
        checkIn("ATT1003", "John");

        // Duplicate scan
        checkIn("ATT1001", "Saudah");
    }
}
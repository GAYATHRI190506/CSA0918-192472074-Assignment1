package TASK12;
import java.time.LocalDate;

public class VisitorPass {
    private static int nextPassNumber = 5001;

    private final int passNumber;
    private final String visitorName;
    private final LocalDate issueDate;

    public VisitorPass(String visitorName, LocalDate issueDate) {
        if (visitorName == null || visitorName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Visitor name cannot be empty"
            );
        }

        if (issueDate == null) {
            throw new IllegalArgumentException(
                "Issue date cannot be null"
            );
        }

        this.passNumber = nextPassNumber++;
        this.visitorName = visitorName;
        this.issueDate = issueDate;
    }

    public boolean isValidOn(LocalDate date) {
        return date != null && date.equals(issueDate);
    }

    @Override
    public String toString() {
        return "Visitor Pass #" + passNumber
                + " | Name: " + visitorName
                + " | Valid on: " + issueDate;
    }
}

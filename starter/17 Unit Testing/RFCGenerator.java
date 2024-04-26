import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RFCGenerator {
    public static String generateRFC(String fullName, String birthdate) {
    String[] names = fullName.split(" ");
    String firstName = names[0];
    String lastName = names[1];
    String motherLastName = names[2];

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date = LocalDate.parse(birthdate, formatter);

    String rfc = lastName.substring(0, 2).toUpperCase() +
             motherLastName.substring(0, 1).toUpperCase() +
             firstName.substring(0, 1).toUpperCase() +
             date.format(DateTimeFormatter.ofPattern("yyMMdd"));

    return rfc;
    }
}

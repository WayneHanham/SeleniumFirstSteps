package helpers;

public class EmailHelper {
    public static String generateRandomEmail() {
        long currentMillis = System.currentTimeMillis(); // this is goint to be 1616574866666
        // below line generates: michal+1616574866666@gmail.com
        return "michal+" + currentMillis + "@gmail.com";
    }
}

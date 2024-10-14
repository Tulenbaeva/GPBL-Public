package ui.config;
import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private static final int PASSWORD_LENGTH = 8;
    private static final Faker faker = new Faker();
    private static final SecureRandom random = new SecureRandom();

    private String generatedPassword;

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        password.append(getRandomCharacter(LOWERCASE));
        password.append(getRandomCharacter(UPPERCASE));
        password.append(getRandomCharacter(DIGITS));
        password.append(getRandomCharacter(SPECIAL_CHARS));

        String allAllowedChars = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARS;
        for (int i = 4; i < PASSWORD_LENGTH; i++) {
            password.append(getRandomCharacter(allAllowedChars));
        }

        List<Character> passwordChars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            passwordChars.add(c);
        }
        Collections.shuffle(passwordChars);

        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : passwordChars) {
            shuffledPassword.append(c);
        }

        generatedPassword = shuffledPassword.toString();
        return generatedPassword;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    private static char getRandomCharacter(String characters) {
        int index = random.nextInt(characters.length());
        return characters.charAt(index);
    }
}

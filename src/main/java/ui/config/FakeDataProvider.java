package ui.config;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeDataProvider {
    private static final Faker faker = new Faker(new Locale("ru"));

    public String generateUserLastName() {

        return faker.name().lastName();
    }

    public String generateUserFirstName() {
        return faker.name().firstName();
    }

    public String generatePhoneNumber() {
        return faker.regexify("[89][0-9]{9}");
    }

    public String generateInvalidPhoneNumber() {
        return faker.regexify("[89][0-9]{8}");
    }

    public String generateINN() {
        return faker.number().digits(10);
    }

    public String generateCompanyName() {
        return faker.company().name();
    }

    public String generateContactPersonName() {
        return faker.name().fullName();
    }
}

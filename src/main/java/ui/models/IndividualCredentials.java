package ui.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class IndividualCredentials implements Serializable {
    private final String phoneNumber;
    private final String firstName;
    private final String lastName;
    private final String password;

    @JsonCreator
    public IndividualCredentials(@JsonProperty("phoneNumber") String phoneNumber,
                                 @JsonProperty("firstName") String firstName,
                                 @JsonProperty("lastName") String lastName,
                                 @JsonProperty("password") String password) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "IndividualCredentials{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

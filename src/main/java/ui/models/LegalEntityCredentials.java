package ui.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class LegalEntityCredentials implements Serializable {
    private final String phone;
    private final String inn;
    private final String companyName;
    private final String contactPersonName;
    private final String password;

    @JsonCreator
    public LegalEntityCredentials(@JsonProperty("phone") String phone,
                                  @JsonProperty("inn") String inn,
                                  @JsonProperty("companyName") String companyName,
                                  @JsonProperty("contactPersonName") String contactPersonName,
                                  @JsonProperty("password") String password) {
        this.phone = phone;
        this.inn = inn;
        this.companyName = companyName;
        this.contactPersonName = contactPersonName;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getInn() {
        return inn;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LegalEntityCredentials{" +
                "phone='" + phone + '\'' +
                ", inn='" + inn + '\'' +
                ", companyName='" + companyName + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

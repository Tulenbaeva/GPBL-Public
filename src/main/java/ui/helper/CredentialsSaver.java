package ui.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ui.models.IndividualCredentials;
import ui.models.LegalEntityCredentials;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialsSaver {

    private static final String INDIVIDUAL_FILE_PATH = "registrationData.json";
    private static final String LEGAL_ENTITY_FILE_PATH = "legalEntityRegistrationData.json";

    public void saveIndividual(IndividualCredentials user) {
        List<IndividualCredentials> userList = readFromFile(INDIVIDUAL_FILE_PATH, new TypeReference<>() {
        });
        userList.add(user);
        saveToFile(INDIVIDUAL_FILE_PATH, userList);
    }

    public List<IndividualCredentials> readIndividualsFromFile() {
        return readFromFile(INDIVIDUAL_FILE_PATH, new TypeReference<>() {
        });
    }

    public void saveLegalEntity(LegalEntityCredentials user) {
        List<LegalEntityCredentials> userList = readFromFile(LEGAL_ENTITY_FILE_PATH, new TypeReference<>() {
        });
        userList.add(user);
        saveToFile(LEGAL_ENTITY_FILE_PATH, userList);
    }

    public List<LegalEntityCredentials> readLegalEntitiesFromFile() {
        return readFromFile(LEGAL_ENTITY_FILE_PATH, new TypeReference<>() {
        });
    }

    private <T> List<T> readFromFile(String filePath, TypeReference<List<T>> typeReference) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> userList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (file.exists()) {
                userList = objectMapper.readValue(file, typeReference);
            } else {
                System.err.println("File does not exist: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Failed to read users from file: " + e.getMessage());
            e.printStackTrace();
        }
        return userList;
    }

    private <T> void saveToFile(String filePath, List<T> userList) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(filePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            objectMapper.writeValue(file, userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

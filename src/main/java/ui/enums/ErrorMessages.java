package ui.enums;

import lombok.Getter;

public enum ErrorMessages {
    PHONE_NUMBER_VALIDATION_ERROR();
    @Getter
    final
    String errorMessage;

    ErrorMessages(){
        this.errorMessage= "Телефон: проверьте номер";
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}



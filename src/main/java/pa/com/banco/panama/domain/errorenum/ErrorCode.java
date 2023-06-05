package pa.com.banco.panama.domain.errorenum;

public enum ErrorCode {
    ERROR_B00_LIST_BANK_EMPTY("ERR-B00: Lista de bancos sin contenido"),
    ERROR_B01_BANK_NOT_FOUND("ERR-B01: Banco con ese id no encontrado"),
    ERROR_AT00_LIST_ALIAS_TYPE_EMPTY("ERR-AT00: Lista tipo alias sin contenido"),
    ERROR_AT01_ALIAS_TYPE_NOT_FOUND("ERR-AT01: Tipo alias con ese id no encontrado"),
    ERROR_C00_LIST_COUNTRY_EMPTY("ERR-C00: Lista de paises sin contenido"),
    ERROR_C01_COUNTRY_NOT_FOUND("ERR-C01: País con ese id no encontrado"),
    ERROR_US00_LIST_USER_STATE_EMPTY("ERR-US00: Lista estado usuario sin contenido"),
    ERROR_US01_USER_STATE_NOT_FOUND("ERR-US01: Estado usuario con ese id no encontrado");


    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

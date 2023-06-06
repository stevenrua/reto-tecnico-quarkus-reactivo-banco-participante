package pa.com.banco.panama.domain.errorenum;

public enum ErrorCode {
    ERROR_B00_LIST_BANK_EMPTY("ERR-B00: Lista de bancos sin contenido"),
    ERROR_B01_BANK_NOT_FOUND("ERR-B01: Banco no encontrado"),
    ERROR_AT00_LIST_ALIAS_TYPE_EMPTY("ERR-AT00: Lista tipo alias sin contenido"),
    ERROR_AT01_ALIAS_TYPE_NOT_FOUND("ERR-AT01: Tipo alias no encontrado"),
    ERROR_C00_LIST_COUNTRY_EMPTY("ERR-C00: Lista de paises sin contenido"),
    ERROR_C01_COUNTRY_NOT_FOUND("ERR-C01: País no encontrado"),
    ERROR_US00_LIST_USER_STATE_EMPTY("ERR-US00: Lista estado usuario sin contenido"),
    ERROR_US01_USER_STATE_NOT_FOUND("ERR-US01: Estado usuario no encontrado"),
    ERROR_ACC00_BANK_REGISTERED("ERR-ACC00: Lo sentimos, ese banco ya esta registrado en una de nuestras cuentas"),
    ERROR_ACC01_NUMBER_ACCOUNT_REGISTERED("ERR-ACC01: Lo sentimos, el número de cuenta ya esta registrado");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

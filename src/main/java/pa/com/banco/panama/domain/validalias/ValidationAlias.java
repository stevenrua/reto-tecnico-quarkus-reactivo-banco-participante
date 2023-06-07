package pa.com.banco.panama.domain.validalias;

public class ValidationAlias {
    public static boolean isValidAlias(String alias) {
        return alias != null && alias.matches("^6\\d{7}$");
    }
}

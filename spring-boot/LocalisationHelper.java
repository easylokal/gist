import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class LocalisationHelper {
    /*
        This is Spring class that resolves the string based on the key provided
    */
    @Autowired
    private MessageSource messageSource;

    private static String defaultLanguage = "en";

    public String convertToLocalMessage(String key, String[] paramList, Locale locale) {

        if(null == locale) {
            locale = new Locale(defaultLanguage);
        }

        return this.messageSource.getMessage(key, paramList, locale);
    }

    public String convertToLocalMessage(String key, Locale locale) {

        if(null == locale) {
            locale = new Locale(defaultLanguage);
        }

        return this.messageSource.getMessage(key, new String[]{}, locale);
    }
}

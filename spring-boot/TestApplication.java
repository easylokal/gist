import org.springframework.beans.factory.annotation.Autowired;
import java.util.Locale;

public class TestApplication {
    @Autowired
    private LocalisationHelper localeHelper;

    public void testFunction() {
        Locale locale = new Locale("en");

        String englishTranslation = localeHelper.convertToLocalMessage("api.message_1", locale);

        Locale localeHindi = new Locale("hi");

        String hindiTranslation = localeHelper.convertToLocalMessage("api.message_1", localeHindi);

        /*
             outputs following:

             This is a sample message 1
             यह एक संदेश है 1

        */
        System.out.println(englishTranslation);
        System.out.println(hindiTranslation);
    }

}

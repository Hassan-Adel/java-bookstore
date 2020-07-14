package utilities;

public class TextUtil {
    public String sanatize(String textToSanatize){
        return textToSanatize.replaceAll("\\s+", "");
    }
}

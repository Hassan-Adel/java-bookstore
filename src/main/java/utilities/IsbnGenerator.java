package utilities;

import java.util.Random;

public class IsbnGenerator implements NumberGenerator {
    @Override
    public String generateNumber() {
        return "12-3994-" + Math.abs(new Random().nextInt());
    }
}

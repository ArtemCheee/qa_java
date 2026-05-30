import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class FelineTest {
    @Test
    public void isGetFamilyCorrect() {
        String expectedFelineFamilyName = "Кошачьи";

        MatcherAssert.assertThat("Некорректное название семейства кошачьих", new Feline().getFamily(), equalTo(expectedFelineFamilyName));
    }

    @Test
    public void isGetKittensInputCountCorrect() {
        int expectedCount = 5;
        MatcherAssert.assertThat("Некорректное количество котят", new Feline().getKittens(expectedCount), equalTo(expectedCount));
    }

    @Test
    public void isGetKittensDefaultCorrect() {
        int expectedCount = 1;
        MatcherAssert.assertThat("Некорректное количество котят", new Feline().getKittens(), equalTo(expectedCount));
    }

    @Test
    public void isEatMeatCorrect() throws Exception {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Неправильный список еды", feline.eatMeat(), equalTo(feline.getFood("Хищник")));
    }
}


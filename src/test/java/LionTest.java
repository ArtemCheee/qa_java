import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void hasManeThrowsException() {
        try {
            new Lion(feline, "абв");

        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void isGetKittensCorrect() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        int expectedCount = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        MatcherAssert.assertThat("Некорректное количество котят", lion.getKittens(), equalTo(expectedCount));
    }

    @Test
    public void isGetFoodCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        MatcherAssert.assertThat("Некорректный список еды", lion.getFood(), equalTo(expectedFood));
    }
}
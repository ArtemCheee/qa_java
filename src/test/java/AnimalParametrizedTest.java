import com.example.Animal;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)

public class AnimalParametrizedTest {
    private final String ANIMAL_KIND;
    private final List<String> EXPECTED_FOOD;

    public AnimalParametrizedTest(String animalKind, List<String> expectedFood) {
        this.ANIMAL_KIND = animalKind;
        this.EXPECTED_FOOD = expectedFood;
    }

    @Parameterized.Parameters

    public static Object[][] paramsAnimalTest() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void isGetFoodCoorect() throws Exception {
        MatcherAssert.assertThat("Неправильный набор еды",new Animal().getFood(ANIMAL_KIND), equalTo(this.EXPECTED_FOOD));
    }

}

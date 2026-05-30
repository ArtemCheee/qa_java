import com.example.Animal;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFamilyIsCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actualString = new Animal().getFamily();

        assertEquals("Некорректный перечень семейств", expectedString, actualString);
    }

    @Test
    public void getFoodWithEmptyStringThrowException() {
        try {
            new Animal().getFood("");

        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",exception.getMessage());
        }
    }
}
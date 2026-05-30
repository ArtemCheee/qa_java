import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String SEX;
    private final boolean HASMANE;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.SEX = sex;
        this.HASMANE = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setSexForLion(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void isHaveManeCorrect() throws Exception {

        Feline feline = Mockito.mock(Feline.class);

        MatcherAssert.assertThat("Грива есть только у льва", new Lion(feline, this.SEX).doesHaveMane(), equalTo(HASMANE));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
class ArrayCheckingTest {
    private ArrayChecking arrayChecking;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 8, 4, 4, 2, 9, 8}, new int[]{2, 9, 8}},
                {new int[]{4, 3, 7, 5, 4, 4, 4, 2}, new int[]{2}}
        });
    }

    @Parameterized.Parameter(0)
    private int[] inputArray;
    @Parameterized.Parameter(1)
    private int[] resultArray;

    @BeforeEach
    void setUp() {
        arrayChecking = new ArrayChecking();
    }

    @Test
    void createArrayAfterLast4() {
        Assertions.assertArrayEquals(resultArray, inputArray);

    }

    @Test
    void testRunTimeExceptionThrown() {
        Assertions.assertThrows(NoFourException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                arrayChecking.createArrayAfterLast4(new int[]{2, 3, 5});
            }
        });
    }


    @Test
    void shouldFourOrOneFoundTrue() {
        Assertions.assertTrue(arrayChecking.findFourOrOne(new int[]{1, 3, 5}));
    }

    @Test
    void shouldFourOrOneFoundFalse() {
        Assertions.assertFalse(arrayChecking.findFourOrOne(new int[]{5, 3, 5}));
    }
}
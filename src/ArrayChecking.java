import java.util.ArrayList;
import java.util.List;

public class ArrayChecking {

    public int[] createArrayAfterLast4(int[] array) {
        int last4index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                last4index = i;
            }
        }
        if (last4index == 0) {
            throw new NoFourException("There is no 4 in the array : " + array.toString());
        }
        List<Integer> newArray = new ArrayList<>();
        for (int i = last4index + 1; i < array.length; i++) {
            newArray.add(array[i]);
        }
        int[] returnArray = new int[newArray.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = newArray.get(i);
        }
        return returnArray;
    }

    public boolean findFourOrOne(int[] inputArray) {
        for (int number : inputArray) {
            if (number == 4 || number == 1) {
                return true;
            }
        }
        return false;

    }
}

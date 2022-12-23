import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar = genRanArray(100000000);
        
        System.out.println("Поиск перебором:");
        long time = System.currentTimeMillis();
        System.out.println(Search.enumMethod(ar, 55));
        System.out.println(System.currentTimeMillis() - time);
        
        Arrays.sort(ar);
        System.out.println("Двоичный поиск:");
        time = System.currentTimeMillis();
        System.out.println(Search.binMethod(ar, 55, 0, ar.length));
        System.out.println(System.currentTimeMillis() - time);
    }
    
    private static int[] genRanArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * 10000);
        }
        return array;
    }
}

class Search {
    public static int enumMethod(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }
    public static int binMethod(int[] sortedArray, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return binMethod(sortedArray, key, low, middle - 1);
        } else {
            return binMethod(sortedArray, key, middle + 1, high);
        }
    }
}
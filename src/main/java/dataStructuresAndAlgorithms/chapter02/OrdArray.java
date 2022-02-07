package main.java.dataStructuresAndAlgorithms.chapter02;

public class OrdArray {
    private long[] numbers;
    private int numbersCount = 0;

    public OrdArray(int size) {
        numbers = new long[size];
    }

    public void insert(long l) {
        int i = find(l);

        if (i >= 0) {
            for (int j = numbersCount; j > i; j--) {
                numbers[j] = numbers[j - 1];
            }

            numbers[i] = l;

            numbersCount++;
        }
    }

    public boolean delete(long l) {
        int i = find(l);

        if (i == -1) {
            return false;
        }

        for (int j = i + 1; j < numbersCount; j++) {
            numbers[j - 1] = numbers[j];
        }

        numbersCount--;
        return true;
    }

    public int find(long l) {
        int min = 0;
        int max = numbersCount - 1;

        while (min <= max) {
            int midpoint = (min + max) / 2;

            if (numbers[midpoint] == l) {
                return midpoint;
            }

            if (numbers[midpoint] < l) {
                min = midpoint + 1;
            } else {
                max = midpoint - 1;
            }
        }

        return -1;
    }

    public void display() {
        for (int i = 0; i < numbersCount; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("");
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        System.out.println(arr.find(77));
        System.out.println(arr.find(33));
        System.out.println(arr.find(-1));

        int searchKey = 55;
        if (arr.find(searchKey) != -1)
            System.out.println("Found " + searchKey + " at " + arr.find(searchKey));
        else
            System.out.println("Can't find " + searchKey);

        arr.display();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
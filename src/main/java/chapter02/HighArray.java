package main.java.chapter02;

class HighArray {
    private long[] numbers;
    private int numbersCount = 0;

    public HighArray(int size) {
        numbers = new long[size];
    }

    public void insert(long l) {
        numbers[numbersCount] = l;
        numbersCount += 1;
    }

    public boolean find(long l) {
        for (int i = 0; i < numbersCount; i++) {
            if (numbers[i] == l) {
                return true;
            }
        }

        return false;
    }

    public boolean delete(long l) {
        int i = 0;
        while (i < numbersCount && numbers[i] != l) {
            i++;
        }

        if (numbers[i] != l) {
            return false;
        }

        for (int j = i + 1; j < numbersCount; j++) {
            numbers[j - 1] = numbers[j];
        }

        numbersCount--;
        return true;
    }

    public void display() {
        for (int i = 0; i < numbersCount; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("");
    }

    public long getMax() {
        long max = -1;

        for (int i = 0; i < numbersCount; i++) {
            max = Math.max(max, numbers[i]);
        }

        return max;
    }

    public void removeMax() {
        long max = getMax();
        delete(max);
    }
}

class HighArrayApp {
    public static void main(String[] args) {

        HighArray highArray = new HighArray(10);

        highArray.insert(77);
        highArray.insert(99);
        highArray.insert(44);
        highArray.insert(55);
        highArray.insert(22);
        highArray.insert(88);
        highArray.insert(11);
        highArray.insert(00);
        highArray.insert(66);
        highArray.insert(33);
        highArray.display();

        int searchKey = 35;           // search for item
        if (highArray.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        highArray.delete(00);
        highArray.delete(55);
        highArray.delete(99);

        System.out.println("Max: " + highArray.getMax());
        highArray.removeMax();
        highArray.display();
    }
}

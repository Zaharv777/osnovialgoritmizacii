

package zadanie1;

public class MyArray {
    private int[] arr;
    private int size;

    public MyArray(int maxSize) {
        this.arr = new int[maxSize];
        this.size = 0;
    }

    public void insert(int key) {
        if (this.size < this.arr.length) {
            this.arr[this.size++] = key;
        } else {
            System.out.println("Массив полон, вставка невозможна");
        }

    }

    public void display() {
        System.out.print("[");

        for(int i = 0; i < this.size; ++i) {
            System.out.print(this.arr[i]);
            if (i < this.size - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public int getMax() {
        if (this.size == 0) {
            return -1;
        } else {
            int max = this.arr[0];

            for(int i = 1; i < this.size; ++i) {
                if (this.arr[i] > max) {
                    max = this.arr[i];
                }
            }

            return max;
        }
    }

    public int removeMax() {
        if (this.size == 0) {
            return -1;
        } else {
            int maxIndex = 0;

            int maxValue;
            for(maxValue = 1; maxValue < this.size; ++maxValue) {
                if (this.arr[maxValue] > this.arr[maxIndex]) {
                    maxIndex = maxValue;
                }
            }

            maxValue = this.arr[maxIndex];

            for(int i = maxIndex; i < this.size - 1; ++i) {
                this.arr[i] = this.arr[i + 1];
            }

            --this.size;
            return maxValue;
        }
    }

    public void noDups() {
        label35:
        for(int i = 0; i < this.size; ++i) {
            int j = i + 1;

            while(true) {
                while(true) {
                    if (j >= this.size) {
                        continue label35;
                    }

                    if (this.arr[j] == this.arr[i]) {
                        for(int k = j; k < this.size - 1; ++k) {
                            this.arr[k] = this.arr[k + 1];
                        }

                        --this.size;
                    } else {
                        ++j;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(20);
        int[] testData = new int[]{5, 3, 9, 3, 7, 9, 1, 3, 9, 8};
        int[] var3 = testData;
        int removed = testData.length;

        for(int var5 = 0; var5 < removed; ++var5) {
            int val = var3[var5];
            myArray.insert(val);
        }

        System.out.println("Исходный массив:");
        myArray.display();
        System.out.println("\n1. Тест getMax():");
        int max = myArray.getMax();
        System.out.println("Максимальный ключ: " + max);
        System.out.println("\n2. Тест removeMax():");
        removed = myArray.removeMax();
        System.out.println("Удалён максимальный ключ: " + removed);
        System.out.println("Массив после удаления максимума:");
        myArray.display();
        removed = myArray.removeMax();
        System.out.println("Удалён следующий максимум: " + removed);
        System.out.println("Массив после второго удаления:");
        myArray.display();
        System.out.println("\n3. Тест noDups():");
        myArray.noDups();
        System.out.println("Массив после удаления дубликатов:");
        myArray.display();
        MyArray emptyArray = new MyArray(5);
        System.out.println("\nПустой массив:");
        emptyArray.display();
        System.out.println("getMax() = " + emptyArray.getMax());
        System.out.println("removeMax() = " + emptyArray.removeMax());
        emptyArray.noDups();
        System.out.println("noDups() на пустом массиве (ничего не меняет):");
        emptyArray.display();
    }
}
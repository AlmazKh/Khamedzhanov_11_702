package ru.itis;

public class MergeSort_2 {
        private int[] numbers;
        private int[] helper;

        private int number;
        private int countOfIterations = 0;

        public void sort(int[] values) {
            this.numbers = values;
            number = values.length;
            this.helper = new int[number];
            mergeSort(0, number - 1);
        }

        private void mergeSort(int low, int high) {
            // если low  = high, то массив отсортирован
            if (low < high) {
                int middle = low + (high - low) / 2;
                // сортровка левой части
                mergeSort(low, middle);
                // сортировка правой части
                mergeSort(middle + 1, high);
                // слияние
                merge(low, middle, high);
            }
        }

        private void merge(int low, int middle, int high) {

            // копирование в helper двух частей
            for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;
            // копирование наименьшего значения либо из правой, либо из левой части
            while (i <= middle && j <= high) {
                if (helper[i] <= helper[j]) {
                    numbers[k] = helper[i];
                    i++;
                } else {
                    numbers[k] = helper[j];
                    j++;
                }
                k++;
                countOfIterations++;
            }
            // копирование оставшейся левой части
            while (i <= middle) {
                numbers[k] = helper[i];
                k++;
                i++;
                countOfIterations++;
            }

        }

    public int getCountOfIterations() {
        return countOfIterations;
    }
}

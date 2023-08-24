package Opgaver;

public class Opg1 {
    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        bubbleSort(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void bubbleSort(String[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (list[j].compareTo(list[j + 1])>0 )
                    swap(list, j, j + 1);
            }
        }
    }

}

/**
 * Javacore 1. Homewokr 2.
 * @author Andrey Ievlev
 * @version Jan 24, 2018
 * @Link
 */

public class HomeWork2 {
   private static int sum = 0;
   private static int stop_counting;
        public static void main(String[] args) {

            String[][] array = new String[4][];
            array[0] = new String[2];
            array[1] = new String[3];
            array[2] = new String[1];
            array[3] = new String[3];

            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    array[i][j] = "1";
                }
            }


            try {
                arraySizeCheck(array);
            } catch (MyArraySizeException e){
                System.out.println("Ошибка в размере массива!");
            }

            array[0][1] = null;
            array[0][2] = "error";  

            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        arrayDataCheck(array, i, j);
                        } catch (MyArrayDataException e) {
                        System.out.println("Ошибка ввода данных в ячейке: " + e.i + "х" + e.j);
                        stop_counting = 1;
                    }
                }
            }
            if(stop_counting == 1){
                System.out.println("Сумму чисел в массиве не корректна!");
            }else {
                System.out.println("Сумма чисел в массиве: " + sum);
            }
            }

    static void arraySizeCheck(String[][] array) throws MyArraySizeException{
        try {
            if (array.length != 4) {
                throw new MyArraySizeException(array.length, array[0].length);
            }
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        for (String[] strings : array) {
            if (strings.length > 4) {
                throw new MyArraySizeException(array.length, strings.length);
            }
        }
    }
        static void arrayDataCheck(String[][] array, int i, int j) throws MyArrayDataException{
            try {
                sum += Integer.parseInt(array[i][j]);
            } catch (NumberFormatException e) {
                throw new MyArrayDataException(i, j);
                }
        }
}


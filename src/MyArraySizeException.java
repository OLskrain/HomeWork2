 class MyArraySizeException extends RuntimeException {
    MyArraySizeException(int row, int column) {
        super("Массив должен быть 4х4\nУ вас введен " + row + "х" + column);
    }
}
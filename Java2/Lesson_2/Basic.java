package Lesson2;

public class Basic {
    public static void main(String[] args) throws MyArrayDataException {
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"4", "3", "2", "4"},
                {"1", "fh", "2", "2"},
                {"3", "3", "4", "4"}};
        try {
            System.out.println(arraySum(invalidDataArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] invalidSizeArray = {
                {"2", "3", "4", "5"},
                {"3", "4", "5", "6", "7"},
                {"5", "4", "3", "2"},
                {"6", "5", "4", "3"}};


        try {
            System.out.println(arraySum(invalidSizeArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int arraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Не верный размер массива");
        }
        for(String [] row : array) {
            if (row.length !=4) {
                throw new MyArraySizeException("Не верный размер массива");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("в " + (i + 1) + " ряду, " + (j + 1) + " ячейке");
                }
            }
        }
        return sum;
    }


}




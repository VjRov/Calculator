import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        exeptionCheck(str);
        if (checkIfNumberIsArabic(str)) {
            String[] arrInput = str.split(" ");
            int firstValue = Integer.parseInt(arrInput[0]);
            int secondValue = Integer.parseInt(arrInput[2]);
//            int integerResult = calculationReturnResult(firstValue, secondValue, arrInput[1]);
            System.out.println(calculationReturnResult(firstValue, secondValue, arrInput[1]));
        }

        if (checkIfNumberIsRoman(str)) {
            String[] arrInput = str.split(" ");
            RomanToArabic roman1 = RomanToArabic.valueOf(arrInput[0]);
            RomanToArabic roman2 = RomanToArabic.valueOf(arrInput[2]);
            int IntegerArabicForRomanCalc = calculationReturnResult(roman1.getArabic(), roman2.getArabic(), arrInput[1]);
            if (IntegerArabicForRomanCalc < 0){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
            }
            char arrRomanResult[] = {1,2,3};
            if (IntegerArabicForRomanCalc == 10) {
                arrRomanResult[0] = 'Ⅹ';

            }
            else if (IntegerArabicForRomanCalc == 100) {
                arrRomanResult[0] = 'C';
            }
            else if (IntegerArabicForRomanCalc < 11) {
                String[] arrForRomanOutput2 = Integer.toString(IntegerArabicForRomanCalc).split("");
                for (int i = 0; i < arrForRomanOutput2.length; i++) {
                    if (arrForRomanOutput2[i].equals("1")) {
                        arrRomanResult[i] = 'Ⅰ';
                    }
                    else if (arrForRomanOutput2[i].equals("2")) {
                        arrRomanResult[i] = 'Ⅱ';
                    }
                    else if (arrForRomanOutput2[i].equals("3")) {
                        arrRomanResult[i] = 'Ⅲ';
                    }
                    else if (arrForRomanOutput2[i].equals("4")) {
                        arrRomanResult[i] = 'Ⅳ';
                    }
                    else if (arrForRomanOutput2[i].equals("5")) {
                        arrRomanResult[i] = 'Ⅴ';
                    }
                    else if (arrForRomanOutput2[i].equals("6")) {
                        arrRomanResult[i] = 'Ⅵ';
                    }
                    else if (arrForRomanOutput2[i].equals("7")) {
                        arrRomanResult[i] = 'Ⅶ';
                    }
                    else if (arrForRomanOutput2[i].equals("8")) {
                        arrRomanResult[i] = 'Ⅷ';
                    }
                    else if (arrForRomanOutput2[i].equals("9")) {
                        arrRomanResult[i] = 'Ⅸ';
                    }


                }

            }
         //   String string = new String(arrRomanResult);
           // string.replaceAll("\\s+","");
            System.out.print((arrRomanResult));

        }

    }

    public static Integer calculationReturnResult(int firstValue, int secondValue, String operand) {
        if (operand.equals("+"))
            return firstValue + secondValue;
        if (operand.equals("-"))
            return (firstValue - secondValue);
        if (operand.equals("*"))
            return (firstValue * secondValue);
        if (operand.equals("/"))
            return firstValue / secondValue;
        return 10000;
    }

    private static void exeptionCheck(String str) {
        String[] arrInput = null;

        arrInput = str.split(" ");
        if (arrInput.length < 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }
        if ((checkIfNumberIsArabic(str)) && ((checkIfNumberIsRoman(str)))) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        }
        if ((checkIfNumberIsArabic(str))) {
            checkArabicNumbersLegit(arrInput);
        }

    }

    public static boolean checkIfNumberIsRoman(String str) {
        if (str.contains("Ⅰ") || str.contains("Ⅱ") || str.contains("Ⅲ") || str.contains("Ⅳ") || str.contains("Ⅴ")
                || str.contains("Ⅵ") || str.contains("Ⅶ") || str.contains("Ⅷ") || str.contains("Ⅸ")
                || str.contains("Ⅹ")) {
            return true;
        }

        return false;
    }

    public static boolean checkIfNumberIsArabic(String str) {
        if (str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5")
                || str.contains("6") || str.contains("7") || str.contains("8") || str.contains("9")
                || str.contains("10")) {
            return true;
        }
        return false;
    }

    public static void checkArabicNumbersLegit(String[] arrInput) {
        int integerCheck, operandFlag = 0;
        for (int i = 0; i < arrInput.length; i++) {
            if ((arrInput[i].equals("+")) || (arrInput[i].equals("-")) || (arrInput[i].equals("/"))
                    || (arrInput[i].equals("*"))) {
                operandFlag++;
            } else {
                integerCheck = Integer.parseInt(arrInput[i]);
                if (integerCheck > 10 || integerCheck < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        //
                        System.out.println("throws Exception //т.к. ввод чисел меньше 0 или больше 10 запрещен");
                    }
                }
            }
            if (operandFlag > 1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    //
                    System.out.println(
                            "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор");
                }
            }
        }
    }

}

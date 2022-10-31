import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        exceptionCheck(str);
        if (checkIfNumberIsArabic(str)) {
            String[] arrInput = str.split(" ");
            int firstValue = Integer.parseInt(arrInput[0]);
            int secondValue = Integer.parseInt(arrInput[2]);
            System.out.println(calculationReturnResult(firstValue, secondValue, arrInput[1]));
        }

        if (checkIfNumberIsRoman(str)) {
            String[] arrInput = str.split(" ");
            RomanToArabic roman1 = RomanToArabic.valueOf(arrInput[0]);
            RomanToArabic roman2 = RomanToArabic.valueOf(arrInput[2]);
            int arabicToRoman = calculationReturnResult(roman1.getArabic(), roman2.getArabic(), arrInput[1]);
            if (arabicToRoman < 0){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(0);
                }
            }
            System.out.println(arabicToRomanTranslation(arabicToRoman));



        }
    }

    public static String arabicToRomanTranslation(int arabicToRoman) {
        StringBuilder roman = new StringBuilder();

        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1,"Ⅰ");
        map.put(4,"Ⅳ");
        map.put(5,"Ⅴ");
        map.put(10,"Ⅹ");
        map.put(40,"ⅩⅬ");
        map.put(50,"Ⅼ");
        map.put(90,"ⅩⅭ");
        map.put(100,"Ⅽ");
//comment for contribution
        do {
            roman.append(map.get(map.floorKey(arabicToRoman)));
            arabicToRoman -= map.floorKey(arabicToRoman);
        }while (arabicToRoman != 0);


        return roman.toString();
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
        return 0;
    }

    public static void exceptionCheck(String str) {
        String[] arrInput;
        int integerCheck, operandFlag = 0;

        arrInput = str.split(" ");
        if (arrInput.length < 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(0);
            }
        }
        if ((checkIfNumberIsArabic(str)) && ((checkIfNumberIsRoman(str)))) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                System.exit(0);
            }
        }
        for (int i = 0; i < arrInput.length; i++) {
            if ((arrInput[i].equals("+")) || (arrInput[i].equals("-")) || (arrInput[i].equals("/"))
                    || (arrInput[i].equals("*")))  {
                operandFlag++;
            } else if (checkIfNumberIsArabic(str)) {
                integerCheck = Integer.parseInt(arrInput[i]);
                if (integerCheck > 10 || integerCheck < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        //
                        System.out.println("throws Exception //т.к. ввод чисел меньше 0 или больше 10 запрещен");
                        System.exit(0);
                    }
                }
            }
            if ((operandFlag > 1) || (arrInput.length != 3)) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    //
                    System.out.println(
                            "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор");
                    System.exit(0);
                }
            }
        }
    }

    public static boolean checkIfNumberIsRoman(String str) {
        return str.contains("Ⅰ") || str.contains("Ⅱ") || str.contains("Ⅲ") || str.contains("Ⅳ") || str.contains("Ⅴ")
                || str.contains("Ⅵ") || str.contains("Ⅶ") || str.contains("Ⅷ") || str.contains("Ⅸ")
                || str.contains("Ⅹ");
    }

    public static boolean checkIfNumberIsArabic(String str) {
        return str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5")
                || str.contains("6") || str.contains("7") || str.contains("8") || str.contains("9")
                || str.contains("10");
    }

}

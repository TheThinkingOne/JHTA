import java.util.Scanner;

public class prac8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("연산 >>");

        double num1 = sc.nextDouble();
        String operator = sc.next();
        double num2 = sc.nextDouble();
        double result = 0;

//        switch(calc) {
//            case "+":
//                System.out.println(num1+"+"+num2 + "의 계산 결과는 " + num1+num2);
//                break;
//            case "-":
//                System.out.println(num1+"-"+num2 + "의 계산 결과는 " + num1-num2);
//                break;
//            case "/":
//                if (num2 == 0) {
//                    System.out.println("0으로 나눌 수 없습니다");
//                    break;
//                }
//                System.out.println(num1 + calc + num2 + "의 계산 결과는 " + num1/num2);
//                break;
//            case "*":
//                System.out.println(num1 + calc + num2 + "의 계산 결과는 " + num1*num2);
//                break;
//            default:
//                System.out.println("..");
//        }

        if(operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("/")) {
            if (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다");
            } else {
                result = num1 / num2;
            }
        } else if (operator.equals("*")) {
            result = num1 * num2;
        }

        System.out.println(result);
    }
}

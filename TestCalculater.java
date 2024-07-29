package testcalculater;

import java.util.Scanner;

public class TestCalculater {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your query as (number ,+,=,*,/, number):");
        while (true) {

            String user = input.nextLine();
            
            //exit the program
            if (user.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break; // Exit the loop and end the program
            }

            // Check if the query matches the expected format
            if (!user.matches("\\d+\\s[+\\-*/]\\s\\d+")) {
                System.out.println("Invalid query format! Please enter the "
                        + "query as (number operator number) with spaces, and (exit) "
                        + "for terminate");
                continue; // Continue to the next iteration of the loop
            }
            Calculater op1 = new Calculater();
            char sum = '+';
            char sup = '-';
            char mult = '*';
            char divide = '/';

            char op = ' ';

            for (int i = 0; i < user.length(); i++) {
                if (user.charAt(i) == sum) {
                    op = '+';
                    System.out.println("The sum of ");
                } else if (user.charAt(i) == sup) {
                    op = '-';
                    System.out.println("The substract of ");

                } else if (user.charAt(i) == mult) {
                    op = '*';
                    System.out.println("The multiplecation of ");

                } else if (user.charAt(i) == divide) {
                    op = '/';
                    System.out.println("The division of ");

                }
            }//for 
            switch (op) {
                case '+':
                    String[] num1 = user.split(" ");
                    int n1 = Integer.parseInt(num1[0]);
                    int n2 = Integer.parseInt(num1[2]);
                    op1.setSum(n1, n2);
                    break;
                case '-':
                    String[] num2 = user.split(" ");
                    int n3 = Integer.parseInt(num2[0]);
                    int n4 = Integer.parseInt(num2[2]);
                    op1.setSup(n3, n4);
                    break;
                case '*':
                    String[] num3 = user.split(" ");
                    double n5 = Integer.parseInt(num3[0]);
                    double n6 = Integer.parseInt(num3[2]);
                    op1.setMult(n5, n6);
                    break;
                case '/':
                    String[] num4 = user.split(" ");
                    try {
                        double n7 = Integer.parseInt(num4[0]);
                        double n8 = Integer.parseInt(num4[2]);
                        op1.setDivide(n7, n8);
                    } catch (ArithmeticException ex) {
                        System.out.println("Error: Division by zero is not "
                                + "allowed");

                    }

                    break;
                default:
                    System.out.println("Enter a valid symbol");

            }//switch

        }//loop while

    }//main method

}//main class

class Calculater {

    private String opration;
    private char type;
    int sum;
    int sup;
    double mult;
    double divide;

    Calculater() {
    }

    Calculater(String op) {
        this.opration = op;
    }

    Calculater(char type) {
        this.type = type;
    }

    public String getOpraion() {
        return this.opration;
    }

    public char getType() {
        return this.type;
    }

    public void setSum(int n1, int n2) {
        this.sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    public void setSup(int n1, int n2) {
        this.sup = n1 - n2;
        System.out.println(n1 + " - " + n2 + " = " + sup);
    }

    public void setMult(double n1, double n2) {
        this.mult = n1 * n2;
        System.out.println(n1 + " x " + n2 + " = " + mult);
    }

    public void setDivide(double n1, double n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Diviser can not be Zero");
        }
        this.divide = n1 / n2;
        System.out.println(n1 + " / " + n2 + " = " + divide);

    }
}//class calcuater

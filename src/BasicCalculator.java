import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("Enter expression: ('stop to exit') ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("stop") || input.equalsIgnoreCase("exit")) {
                break;
            }
            // This regex splits the string but keeps the operator in the array
            // It looks for +, -, *, or /
            String[] parts = input.split("(?<=[-+*/])|(?=[-+*/])");

            if (parts.length == 3) {
                int num1 = Integer.parseInt(parts[0].trim());
                String operator = parts[1].trim();
                int num2 = Integer.parseInt(parts[2].trim());
                int result = 0;
                boolean validOperation = true;
                if(num2 == 0 && operator.equals("/")){
                    System.out.println("can't divide by zero");
                    validOperation = false;
                }else {
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                        default:
                            System.out.println("invalid operator");
                            validOperation = false;
                            break;
                    }
                }
                if (validOperation) {
                    System.out.println("Output: " + result);
                }
            } else {
                System.out.println("Invalid format. Use: number operator number");
            }
        }
        sc.close();
    }
}
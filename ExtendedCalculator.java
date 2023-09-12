import java.util.Scanner;

public class ExtendedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Extended Calculator!");
        System.out.println("===================================");

        double memory = 0.0; // Store the result for memory functions

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Memory Functions");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleBasicArithmetic(scanner);
                    break;
                case 2:
                    memory = handleMemoryFunctions(memory, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the calculator. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option (1-3).");
            }
        }
    }

    public static void handleBasicArithmetic(Scanner scanner) {
        while (true) {
            System.out.println("\nBasic Arithmetic Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            double result = 0.0;

            switch (choice) {
                case 1:
                    result = performAddition(scanner);
                    break;
                case 2:
                    result = performSubtraction(scanner);
                    break;
                case 3:
                    result = performMultiplication(scanner);
                    break;
                case 4:
                    result = performDivision(scanner);
                    break;
                case 5:
                    return; // Return to the Main Menu
                default:
                    System.out.println("Invalid choice. Please choose a valid option (1-5).");
            }

            // Added ANSI escape code to change text color for the result
            System.out.println();
            System.out.println("\u001B[32mResult: " + result + "\u001B[0m");
        }
    }

    public static double performAddition(Scanner scanner) {
        System.out.print("Enter the number of values to add: ");
        int count = scanner.nextInt();
        double result = 0.0;

        for (int i = 0; i < count; i++) {
            double num = getNumber("Enter value #" + (i + 1) + ": ");
            result += num;
        }

        return result;
    }

    public static double performSubtraction(Scanner scanner) {
        System.out.print("Enter the number of values to subtract: ");
        int count = scanner.nextInt();
        double result = 0.0;

        if (count >= 1) {
            result = getNumber("Enter value #1: ");

            for (int i = 1; i < count; i++) {
                double num = getNumber("Enter value #" + (i + 1) + ": ");
                result -= num;
            }
        } else {
            System.out.println("Error: At least one value is required for subtraction.");
        }

        return result;
    }

    public static double performMultiplication(Scanner scanner) {
        System.out.print("Enter the number of values to multiply: ");
        int count = scanner.nextInt();
        double result = 1.0;

        for (int i = 0; i < count; i++) {
            double num = getNumber("Enter value #" + (i + 1) + ": ");
            result *= num;
        }

        return result;
    }

    public static double performDivision(Scanner scanner) {
        double num1 = getNumber("Enter the dividend: ");
        double num2 = getNonZeroNumber("Enter the divisor (non-zero): ");
        return num1 / num2;
    }

    public static double handleMemoryFunctions(double memory, Scanner scanner) {
        System.out.println("\nMemory Functions Menu:");
        System.out.println("1. Store Result to Memory");
        System.out.println("2. Recall Memory");
        System.out.println("3. Clear Memory");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice (1-4): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                memory = getNumber("Enter the number to store in memory: ");
                System.out.println("Value stored in memory.");
                break;
            case 2:
                System.out.println("Memory Value: " + memory);
                break;
            case 3:
                memory = 0.0;
                System.out.println("Memory cleared.");
                break;
            case 4:
                break; // Return to the Main Menu
            default:
                System.out.println("Invalid choice. Please choose a valid option (1-4).");
        }

        return memory;
    }

    public static double getNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static double getNonZeroNumber(String prompt) {
        double num;
        do {
            num = getNumber(prompt);
            if (num == 0) {
                System.out.println("Error: Division by zero is not allowed.");
            }
        } while (num == 0);
        return num;
    }
}

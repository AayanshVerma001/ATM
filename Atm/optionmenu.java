import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class optionmenu extends account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat MoneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() {
        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 717976);

                System.out.println("Welcome to the ATM");
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\nInvalid input. Only numbers are allowed.\n");
                menuInput.nextLine(); // Clear input buffer
                continue;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
                x = 2;
            } else {
                System.out.println("\nWrong Customer Number or PIN. Try again.\n");
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("\nSelect Account Type:");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Savings Account");
        System.out.println("3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> {
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice.\n");
                getAccountType();
            }
        }
    }

    public void getChecking() {
        System.out.println("\nChecking Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Checking Balance: " + MoneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> {
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice.\n");
                getChecking();
            }
        }
    }

    public void getSaving() {
        System.out.println("\nSaving Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Saving Balance: " + MoneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> {
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice.\n");
                getSaving();
            }
        }
    }

    public static void main(String[] args) {
        optionmenu atm = new optionmenu();
        atm.getLogin();
    }
}
import java.util.Scanner;
import java.util.Stack;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String currentPage = "Home"; // initial page

        int choice;
        do {
            System.out.println("\n--- Browser Navigation Menu ---");
            System.out.println("Current Page: " + currentPage);
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new URL: ");
                    backStack.push(currentPage); // store current page
                    currentPage = sc.nextLine(); // go to new page
                    forwardStack.clear(); // clear future navigation
                    System.out.println("Visited: " + currentPage);
                    break;

                case 2:
                    if (!backStack.isEmpty()) {
                        forwardStack.push(currentPage);
                        currentPage = backStack.pop();
                        System.out.println("Moved Back to: " + currentPage);
                    } else {
                        System.out.println("No more pages in Back history!");
                    }
                    break;

                case 3:
                    if (!forwardStack.isEmpty()) {
                        backStack.push(currentPage);
                        currentPage = forwardStack.pop();
                        System.out.println("Moved Forward to: " + currentPage);
                    } else {
                        System.out.println("No forward pages available!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Browser...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
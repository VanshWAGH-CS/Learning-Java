
public class Runner {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Stack stack = null;
        while (true) {
            System.out.println("\n=== Stack Demo ===");
            System.out.println("1. Create stack (with capacity)");
            System.out.println("2. Push");
            System.out.println("3. Pop");
            System.out.println("4. Peek");
            System.out.println("5. Size");
            System.out.println("6. isEmpty");
            System.out.println("7. isFull");
            System.out.println("8. Clear");
            System.out.println("9. Show");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter capacity: ");
                        int cap = Integer.parseInt(scanner.nextLine().trim());
                        stack = new Stack(cap);
                        System.out.println("Created stack with capacity " + cap);
                        break;
                    case 2:
                        ensureStackCreated(stack);
                        System.out.print("Enter value to push: ");
                        int val = Integer.parseInt(scanner.nextLine().trim());
                        stack.push(val);
                        System.out.println("Pushed: " + val);
                        break;
                    case 3:
                        ensureStackCreated(stack);
                        System.out.println("Popped: " + stack.pop());
                        break;
                    case 4:
                        ensureStackCreated(stack);
                        System.out.println("Peek: " + stack.peek());
                        break;
                    case 5:
                        ensureStackCreated(stack);
                        System.out.println("Size: " + stack.size());
                        break;
                    case 6:
                        ensureStackCreated(stack);
                        System.out.println("isEmpty: " + stack.isEmpty());
                        break;
                    case 7:
                        ensureStackCreated(stack);
                        System.out.println("isFull: " + stack.isFull());
                        break;
                    case 8:
                        ensureStackCreated(stack);
                        stack.clear();
                        System.out.println("Cleared.");
                        break;
                    case 9:
                        ensureStackCreated(stack);
                        stack.show();
                        break;
                    case 0:
                        System.out.println("Bye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Unknown choice.");
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Create the stack first (option 1).");
            }
        }
    }

    private static void ensureStackCreated(Stack stack) {
        if (stack == null) {
            throw new NullPointerException("Stack not created");
        }
    }
}

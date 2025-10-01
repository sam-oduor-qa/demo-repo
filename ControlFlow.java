public class ControlFlow {
    public static void main(String[] args) {
    
    //Comparison Operators
    
    int x = 1;
        int y = 1;
        
        // Equality operators
        System.out.println(x == y);  // true (equal to)
        System.out.println(x != y);  // false (not equal to)
        
        // Relational operators
        System.out.println(x > y);   // false (greater than)
        System.out.println(x >= y);  // true (greater than or equal to)
        System.out.println(x < y);   // false (less than)
        System.out.println(x <= y);  // true (less than or equal to)

    //Logical Operators
        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30;  // AND
        System.out.println(isWarm);  // true
        
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;  // OR and NOT
        System.out.println(isEligible);  // true  

    //If Statements
        int temp = 32;
        
        if (temp > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink plenty of water");
        }
        else if (temp > 20)
            System.out.println("Beautiful day");
        else if (temp > 10)
            System.out.println("It's cold");
        else
            System.out.println("It's freezing");  


    //Simplyfied If Statements
        int income = 120_000;
        
        // Bad practice - redundant
        boolean hasHighIncome2;
        if (income > 100_000)
            hasHighIncome2 = true;
        else
            hasHighIncome2 = false;
        System.out.println(hasHighIncome2);
        
        // Good practice - simplified
        boolean hasHighIncome3 = (income > 100_000);   
        System.out.println(hasHighIncome3);

        
    //Ternary Operator
        int income2 = 120_000;
        
        // If-else way
        String className;
        if (income2 > 100_000)
            className = "First";
        else
            className = "Economy";
        System.out.println(className);

        // Ternary operator way (condition ? valueIfTrue : valueIfFalse)
        String className2 = income2 > 100_000 ? "First" : "Economy";
        System.out.println(className2); 


    //switch Statements
    String role = "admin";
        
        // Using if-else
        if (role.equals("admin"))
            System.out.println("You're an admin");
        else if (role.equals("moderator"))
            System.out.println("You're a moderator");
        else
            System.out.println("You're a guest");
        
        // Using switch statement (cleaner for multiple conditions)
        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;
            case "moderator":
                System.out.println("You're a moderator");
                break;
            default:
                System.out.println("You're a guest");
        }    

    //For Loops
        // Print "Hello World" 5 times
        for (int i = 0; i < 5; i++)
            System.out.println("Hello World " + i);
        
        // Loop in reverse
        for (int i = 5; i > 0; i--)
            System.out.println("Hello World " + i);
        
        // Loop with step of 2
        for (int i = 0; i < 10; i += 2)
            System.out.println(i);
            
    //While Loops
    int i = 0;
        while (i < 5) {
            System.out.println("Hello World " + i);
            i++;
        }
        
        // Example: Input validation
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = "";
        
        while (!input.equals("quit")) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println("You typed: " + input);
        }

    //Do While Loops
    int j = 0;
        do {
            System.out.println("Hello World " + j);
            j++;
        } while (j < 5);
        
        // Example: Always ask at least once
        String input2;
        do {
            System.out.print("Input: ");
            input2 = scanner.next().toLowerCase();
            System.out.println("You typed: " + input2);
        } while (!input2.equals("quit"));            

    //Break and Continue
        // BREAK - exits the loop
        int k = 0;
        while (k < 10) {
            if (k == 5)
                break;  // Exit loop when k is 5
            System.out.println(k);
            k++;
        }
        
        // CONTINUE - skips current iteration
        int m = 0;
        while (m < 10) {
            if (m % 2 == 0) {
                m++;
                continue;  // Skip even numbers
            }
            System.out.println(m);  // Only prints odd numbers
            m++;
        }
        
    //For-Each Loops
        // For-each loop - iterates over arrays/collections
        String[] fruits = {"Apple", "Mango", "Orange"};
        
        // Traditional for loop
        for (int n = 0; n < fruits.length; n++)
            System.out.println(fruits[n]);
        
        // For-each loop (cleaner, simpler)
        for (String fruit : fruits)
            System.out.println(fruit);    
        scanner.close();


    }  
}

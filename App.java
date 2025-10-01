public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");

//1. Variables & Contsants
     int age = 30;
        age = 35; // Can be reassigned   
        final float PI = 3.14F;
        System.out.println("Age: " + age);
        System.out.println("PI: " + PI);

//2. Primitive Data Types
        byte myAge = 30;           
        short myShort = 30000;     
        int myInt = 2000000;       
        long myLong = 3000000000L; 
        
        float myFloat = 3.14F;     
        double myDouble = 3.14;    
        System.out.println("Double: " + myDouble);

        char myChar = 'A';         
        boolean myBoolean = true;  
        System.out.println("Boolean: " + myBoolean);
        System.out.println("Char: " + myChar);

        System.out.println("Byte: " + myAge);
        System.out.println("Short: " + myShort);
        System.out.println("Int: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("Float: " + myFloat);

        // Primitive types
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(y); // Prints 1 (copy was made)

        // Reference types
        java.awt.Point point1 = new java.awt.Point(1, 1);
        java.awt.Point point2 = point1;
        point1.x = 2;
        System.out.println(point2.x); // Prints 2 (both reference same object)
        
//3. Strings
        String message = "Hello, World!";
        System.out.println(message);

        // String methods
        System.out.println(message.length());        // 11
        System.out.println(message.toUpperCase());   // HELLO WORLD
        System.out.println(message.toLowerCase());   // hello world
        System.out.println(message.startsWith("H")); // true
        System.out.println(message.endsWith("d"));   // true
        System.out.println(message.indexOf("o"));    // 4
        System.out.println(message.replace("!", "**")); 
        System.out.println(message.trim());          // removes whitespace
        
        // Strings are immutable - original doesn't change
        System.out.println(message); // Still "Hello World"

//4. Arrays
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;

        int[] numbers2 = {2, 3, 5, 1, 4};
        System.out.println(numbers2.length);

        java.util.Arrays.sort(numbers2);
        System.out.println(java.util.Arrays.toString(numbers2));

//5. Multi-Dimensional Arrays
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(matrix[1][1]); // 5

//6. Arithmetic Expressions
        int result = 10 + 3;  // Addition: 13
        result = 10 - 3;      // Subtraction: 7
        result = 10 * 3;      // Multiplication: 30
        result = 10 / 3;      // Division (integer): 3
        double result2 = (double)10 / (double)3; // 3.333...
        result = 10 % 3;      // Modulus (remainder): 1
        result++;             // Increment: 2

        int b = 1;
        b += 5;            // b = b + 5
        b *= 3;            // b = b * 3
        System.out.println(b); // Use the variable 'b'

        System.out.println(result);
        System.out.println(result2);

//7. Operator Precedence
       int c = 10 + 3 * 2; // 16 (multiplication first)
       int d = (10 + 3) * 2; // 26 (parentheses first)

         System.out.println(c);
            System.out.println(d);

//8. Type Casting
        double e = 1.1;
        int f = (int)e; // Explicit casting: 1
        System.out.println(f);

        int g = 1;
        double h = g; // Implicit casting: 1.0
        System.out.println(h);

//9. Math Class
        int i = Math.round(1.1F); // 1
        double j = Math.ceil(1.1); // 2.0
        double k = Math.floor(1.9); // 1.0
        double l = Math.max(1, 2); // 2
        double m = Math.min(1, 2); // 1
        double n = Math.random(); // Random number between 0.0 and 1.0

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        System.out.println(n);

//10. Formatting Numbers
        java.text.NumberFormat currency = java.text.NumberFormat.getCurrencyInstance();
        String currencyString = currency.format(1234567.891);
        System.out.println(currencyString); // $1,234,567.89

        java.text.NumberFormat percent = java.text.NumberFormat.getPercentInstance();
        String percentString = percent.format(0.1);
        System.out.println(percentString); // 10%

//11. Reading Input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();
        System.out.println("You are " + userAge + " years old.");

        scanner.close();
    }
}
// Detailed example showing recursive method storage in JVM
public class RecursiveMethodStorage {
    
    // Instance variable (metadata in Method Area, instance data in Heap)
    private String instanceName;
    private static int globalCounter = 0;
    
    public RecursiveMethodStorage(String name) {
        this.instanceName = name;
    }
    
    // Recursive method to demonstrate stack frame creation
    public int factorialRecursive(int n) {
        // Each call creates a NEW stack frame with these local variables:
        int localN = n;  // Parameter copy (stored in current stack frame)
        String methodInfo = "factorial(" + n + ")"; // Local variable
        
        System.out.println("📋 Stack Frame Created for: " + methodInfo);
        System.out.println("   Local variable 'localN': " + localN);
        System.out.println("   'this' reference points to: " + this.instanceName);
        System.out.println("   Return address stored in frame");
        
        // Base case
        if (n <= 1) {
            System.out.println("🔚 Base case reached, returning 1");
            return 1;
        }
        
        // Recursive call - creates ANOTHER stack frame
        System.out.println("🔄 Making recursive call: factorial(" + (n-1) + ")");
        int result = factorialRecursive(n - 1); // NEW stack frame created
        
        // After recursive call returns, we're back in THIS frame
        int finalResult = n * result;
        System.out.println("✅ Returning from " + methodInfo + " = " + finalResult);
        
        return finalResult;
    }
    
    // Static recursive method to show difference
    public static int fibonacciRecursive(int n) {
        // Static method - no 'this' reference stored
        String callInfo = "fibonacci(" + n + ")";
        globalCounter++; // Modifies static variable in Method Area
        
        System.out.println("📋 Static Stack Frame: " + callInfo + " (Call #" + globalCounter + ")");
        
        if (n <= 1) {
            return n;
        }
        
        // Two recursive calls = Two new stack frames
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // Method to demonstrate deep recursion and stack overflow
    public void deepRecursion(int depth) {
        // Each call adds a frame to the stack
        String frameInfo = "Depth: " + depth;
        byte[] largeArray = new byte[1024]; // Large local variable
        
        System.out.println("Stack frame at depth: " + depth);
        
        if (depth > 0) {
            deepRecursion(depth - 1); // Recursive call
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== RECURSIVE METHOD STORAGE DEMONSTRATION ===\n");
        
        // Create object instance
        RecursiveMethodStorage demo = new RecursiveMethodStorage("DemoObject");
        
        System.out.println("1️⃣ === INSTANCE METHOD RECURSION ===");
        System.out.println("Each recursive call creates a new stack frame");
        System.out.println("Object reference 'this' is stored in each frame\n");
        
        int result = demo.factorialRecursive(4);
        System.out.println("Final result: " + result + "\n");
        
        System.out.println("2️⃣ === STATIC METHOD RECURSION ===");
        System.out.println("No 'this' reference stored in stack frames");
        System.out.println("Only method parameters and local variables\n");
        
        globalCounter = 0; // Reset counter
        int fibResult = fibonacciRecursive(5);
        System.out.println("Fibonacci result: " + fibResult);
        System.out.println("Total recursive calls made: " + globalCounter + "\n");
        
        System.out.println("3️⃣ === MEMORY LOCATION SUMMARY ===");
        printMemoryLocations();
        
        System.out.println("\n4️⃣ === STACK OVERFLOW DEMONSTRATION ===");
        System.out.println("Uncomment the line below to see StackOverflowError");
        // demo.deepRecursion(10000); // This will cause StackOverflowError
        System.out.println("(Deep recursion commented out to prevent crash)");
    }
    
    private static void printMemoryLocations() {
        System.out.println("📍 WHERE THINGS ARE STORED:");
        System.out.println();
        System.out.println("🏛️  METHOD AREA:");
        System.out.println("   ├─ Class: RecursiveMethodStorage.class");
        System.out.println("   ├─ Method bytecode: factorialRecursive(), fibonacciRecursive()");
        System.out.println("   ├─ Static variable: globalCounter");
        System.out.println("   └─ String literals: \"DemoObject\", \"factorial(\", etc.");
        System.out.println();
        System.out.println("📚 STACK AREA (per thread):");
        System.out.println("   ├─ main() frame: demo reference, result variable");
        System.out.println("   ├─ factorialRecursive(4) frame: n=4, localN=4, methodInfo, this reference");
        System.out.println("   ├─ factorialRecursive(3) frame: n=3, localN=3, methodInfo, this reference");
        System.out.println("   ├─ factorialRecursive(2) frame: n=2, localN=2, methodInfo, this reference");
        System.out.println("   └─ factorialRecursive(1) frame: n=1, localN=1, methodInfo, this reference");
        System.out.println();
        System.out.println("🏠 HEAP AREA:");
        System.out.println("   ├─ RecursiveMethodStorage object instance");
        System.out.println("   ├─ instanceName: \"DemoObject\"");
        System.out.println("   └─ String objects created during execution");
    }
}
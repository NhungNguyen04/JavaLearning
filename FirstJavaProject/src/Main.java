//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Primitive types
        int a = 5;
        char b = '1';
        long c = 49999;
        double d = 3.2;

        // Non-primitive types
        String name = "Nhung Hong";
        System.out.println(name.toUpperCase());
        addExclamationPoint(name);
    }

    public static void addExclamationPoint(String s){
        System.out.println(s + "!");
    }
}
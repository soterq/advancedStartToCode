package undemy9_10.generic.interface_example;

public class TestClass {
    public static void main(String[] args) {
        AddValues<String> stringAddValues = new AddStrings();
        AddValues<Integer> integerAddValues = new AddNumbers();

        System.out.println(stringAddValues.addValues("day" ,": 14"));
        System.out.println(integerAddValues.addValues(15,8));
    }
}

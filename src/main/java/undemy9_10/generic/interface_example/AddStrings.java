package undemy9_10.generic.interface_example;

public class AddStrings implements AddValues<String >{
    @Override
    public String addValues(String a, String b) {
        return a+b;
    }
}

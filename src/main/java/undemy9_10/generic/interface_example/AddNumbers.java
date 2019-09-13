package undemy9_10.generic.interface_example;

public class AddNumbers implements AddValues<Integer> {
    @Override
    public Integer addValues(Integer a, Integer b) {
        return a+b;
    }

}

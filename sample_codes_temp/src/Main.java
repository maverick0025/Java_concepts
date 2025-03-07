import java.util.LinkedList;
import java.util.List;

public class Main {

    @Override
    public String toString() {
        // Use StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder("Hey");
        result.append(super.toString());
        return result.toString();
    }

    public static void main(String[] args) {

        List<Integer> list2 = new LinkedList<>();

        list2.add(32);
        list2.add(54);
        Main mainInstance = new Main();
        System.out.println(mainInstance);
    }
}


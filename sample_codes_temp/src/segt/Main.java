package segt;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree st = new SegmentTree(array);

        st.display();
    }
}

package bst;

public class Main {

    public static void main(String[] args) {
        System.out.println("It's BST one");

        BST bst = new BST();
        int[] inp = {13, 12, 1, 5, 0, 20, 14, 25};

        for (int j : inp) {
            bst.insert(j);
        }

        System.out.println("Displaying the tree below:");
        bst.display();

    }
}

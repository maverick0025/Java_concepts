package bt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binTree = new BinaryTree();
        binTree.populate(scanner);
        binTree.display();

    }
}

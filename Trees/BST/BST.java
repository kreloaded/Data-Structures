import java.util.*;

class Node {
	int val;
	Node left;
	Node right;

	Node(int val) {
		this.val = val;
	}
}

public class BST {
	public static void main(String[] args) {
		Node root = null;
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		while(choice < 5) {
			System.out.println("Choose operation to perform: \n1. Insert\n2. Inorder Traversal\n3. Pre-order Traversal\n4. Post-order Traversal");
			choice = sc.nextInt();

			switch(choice) {
				case 1: int data;
						System.out.println("Enter data :");
						data = sc.nextInt();
						root = insert(root, data);
						break;

				case 2: System.out.println("In-order traversal of the tree is :");
						inOrder(root);
						break;

				case 3: System.out.println("Pre-order traversal of the tree is :");
						preOrder(root);
						break;

				case 4: System.out.println("Post-order traversal of the tree is :");
						postOrder(root);
						break;
			}
		}
	}

	private static Node insert(Node root, int data) {
		if(root == null) {
			root = new Node(data);
		} else {
			if(data < root.val) {
				root.left = insert(root.left, data);
			} else if(data > root.val) {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

	private static void inOrder(Node root) {
		Node current = root;
		if(current != null) {
			inOrder(current.left);
			System.out.println(current.val);
			inOrder(current.right);
		}
	}

	private static void preOrder(Node root) {
		Node current = root;
		if(current != null) {
			System.out.println(current.val);
			preOrder(current.left);
			preOrder(current.right);
		}
	}

	private static void postOrder(Node root) {
		Node current = root;
		if(current != null) {
			postOrder(current.left);
			postOrder(current.right);
			System.out.println(current.val);
		}
	}

}
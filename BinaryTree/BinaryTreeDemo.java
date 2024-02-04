package CSCI2110.Lab6;

public class BinaryTreeDemo {
	public static void main(String[] args) {

		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();
		A.makeRoot("A");
		B.makeRoot("B");
		C.makeRoot("C");
		D.makeRoot("D");
		E.makeRoot("E");
		F.makeRoot("F");

		A.attachLeft(B);
		A.attachRight(C);
		B.attachLeft(D);
		B.attachRight(E);
		D.attachLeft(F);

		// test statements 1
		System.out.printf("Height of the tree is: %d\n", BinaryTree.height(A));

		System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(A));

		System.out.println();

		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();

		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();

		System.out.print("Level order:\t");
		BinaryTree.levelOrder(A);
		System.out.println();
		System.out.println();

		System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(A) ? "Yes!" : "No.");

		System.out.println();
		System.out.println();
		System.out.println();


		BinaryTree<String> G = new BinaryTree<String>();
		BinaryTree<String> H = new BinaryTree<String>();
		BinaryTree<String> I = new BinaryTree<String>();
		BinaryTree<String> J = new BinaryTree<String>();
		BinaryTree<String> K = new BinaryTree<String>();
		BinaryTree<String> L = new BinaryTree<String>();
		BinaryTree<String> M  = new BinaryTree<String>();
		G.makeRoot("G");
		H.makeRoot("H");
		I.makeRoot("I");
		J.makeRoot("J");
		K.makeRoot("K");
		L.makeRoot("L");
		M.makeRoot("M");

		G.attachLeft(H);
		G.attachRight(I);
		H.attachLeft(J);
		J.attachLeft(M);
		I.attachRight(L);
		I.attachLeft(K);

		// test statements 2
		System.out.printf("Height of the tree is: %d\n", BinaryTree.height(G));

		System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(G));

		System.out.println();

		System.out.print("Inorder:\t");
		BinaryTree.inorder(G);
		System.out.println();

		System.out.print("Preorder:\t");
		BinaryTree.preorder(G);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(G);
		System.out.println();

		System.out.print("Level order:\t");
		BinaryTree.levelOrder(G);
		System.out.println();
		System.out.println();

		System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(G) ? "Yes!" : "No.");

		System.out.println();
		System.out.println();
		System.out.println();

		BinaryTree<String> N = new BinaryTree<String>();
		BinaryTree<String> O = new BinaryTree<String>();
		BinaryTree<String> P = new BinaryTree<String>();
		BinaryTree<String> Q = new BinaryTree<String>();
		BinaryTree<String> R = new BinaryTree<String>();
		BinaryTree<String> S = new BinaryTree<String>();
		BinaryTree<String> T  = new BinaryTree<String>();
		N.makeRoot("N");
		O.makeRoot("O");
		P.makeRoot("P");
		Q.makeRoot("Q");
		R.makeRoot("R");
		S.makeRoot("S");
		T.makeRoot("T");

		N.attachLeft(O);
		N.attachRight(P);
		O.attachLeft(Q);
		P.attachLeft(R);
		P.attachRight(S);
		S.attachRight(T);

		// test statements 3
		System.out.printf("Height of the tree is: %d\n", BinaryTree.height(N));

		System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(N));

		System.out.println();

		System.out.print("Inorder:\t");
		BinaryTree.inorder(N);
		System.out.println();

		System.out.print("Preorder:\t");
		BinaryTree.preorder(N);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(N);
		System.out.println();

		System.out.print("Level order:\t");
		BinaryTree.levelOrder(N);
		System.out.println();
		System.out.println();

		System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(N) ? "Yes!" : "No.");

	}

}

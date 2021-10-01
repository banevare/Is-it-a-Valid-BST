class IsValidBST {
	final boolean debug = false;
	public class LastElement{
		Integer val = null;
	}
	public boolean isValidBST(TreeNode root) {
		LastElement last = new LastElement();
		return inorderTraversal(root,last);
    }
	public boolean inorderTraversal(TreeNode root, LastElement last) {
		if(debug)System.out.print("the root val is : " +  root.val + " --- ");
		if(debug)System.out.println("the last val is : " + last.val);
        if(root.left != null) {
			if(debug)System.out.println("Went LEFT... ");
			if(!inorderTraversal(root.left,last)){
				if(debug)System.out.println("Line 14 : return FALSE");
				return false;
			}
		}
		if(last.val != null && root.val <= last.val) {
			if(debug)System.out.println("Line 17 : return FALSE");
			return false;
		}
		last.val = root.val;
		if(root.right != null){	
			if(debug)System.out.println("Went RIGHT... ");
			if(!inorderTraversal(root.right,last)){
				if(debug)System.out.println("Line 27 : return FALSE");
				return false;
			}								
		}
		if(debug)System.out.println("Line 30 : return TRUE");
		return true;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		public void printInOrder(int depth){
			// start at root -> traverse to root
			if(this.left != null){
				this.left.printInOrder(depth + 1);	
			}
			for(int i = 0; i < depth; i++){
				System.out.print("    ");
			}
			System.out.println(this.val);
			if(this.right != null){
				this.right.printInOrder(depth + 1);	
			}
		}
	}
	public TreeNode makeTree2Bad(){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(2);
		a.left = b;
		return a;
	}
	public TreeNode makeTree3Good(){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(3);
		a.right = c;
		a.left = b;
		return a;
	}
	public TreeNode makeTree3Bad(){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(2);
		a.right = c;
		a.left = b;
		return a;
	}
	public TreeNode makeTree3Bad2(){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		a.right = c;
		a.left = b;
		return a;
	}
	public TreeNode makeTree5Good(){
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(7);
		a.right = c;
		a.left = b;
		c.right = e;
		b.left = d;
		return a;
	}
	public TreeNode makeTree5Bad(){
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(7);
		a.right = c;
		a.left = b;
		c.right = e;
		c.left = d;
		return a;
	}
	public void test2Bad(){
		TreeNode tree2 = makeTree2Bad();
		boolean b = isValidBST(tree2);
		if(debug)System.out.println("**** TEST2BAD ***: " + b);
		assert(!b);
	}
	public void test3Good(){
		TreeNode tree3 = makeTree3Good();
		if(debug)System.out.println("*** TEST3GOOD ***: " +isValidBST(tree3));
		assert(isValidBST(tree3));

	}
	public void test3Bad(){
		TreeNode tree3 = makeTree3Bad();
		if(debug)System.out.println("**** TEST3BAD ***: " + isValidBST(tree3));
		assert(!isValidBST(tree3));
	}
	public void test3Bad2(){
		TreeNode tree3 = makeTree3Bad2();
		boolean b = isValidBST(tree3);
		if(debug)System.out.println("**** TEST3BAD ***: " + b);
		assert(!b);
	}
	public void test5Good(){
		TreeNode tree5 = makeTree5Good();
		if(debug)System.out.println("*** TEST5GOOD ***: " +isValidBST(tree5));
		assert(isValidBST(tree5));

	}
	public void test5Bad(){
		TreeNode tree5 = makeTree5Bad();
		if(debug)System.out.println("**** TEST5BAD ***: " + isValidBST(tree5));
		assert(!isValidBST(tree5));
	}
	public static void main(String[] args) {
		IsValidBST s = new IsValidBST();
		s.test2Bad();
		s.test3Good();
		s.test3Bad();
		s.test3Bad2();
		s.test5Good();
		s.test5Bad();
	}
}

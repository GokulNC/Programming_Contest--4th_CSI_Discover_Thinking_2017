import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
	
	public static class Tree {
		TreeNode root; 
		
		public Tree(String CEO) {
			root = new TreeNode(CEO);
		}
		
		public TreeNode findChild(String manager) {
			
			TreeNode result = root.find(manager);
			return result;
		}
		
		/*public void insert(String name, String manager) {
			root.insert(name, manager);
		}*/
		
		public TreeNode findLeaf() {
			return root.deepestLeaf();
		}
	}
	
	public static class TreeNode {
		public String name;
		ArrayList<TreeNode> children;
		public int level;
		
		public TreeNode(String name) {
			this.name = name;
			children = new ArrayList<TreeNode>();
			level=0;
		}
		
		public TreeNode find(String query) {
			
			TreeNode result = null;
			
			if(name.equals(query)) return this;
			
			for(TreeNode node: children) {
				result = node.find(query);
				if(result!=null && result.name.equals(query)) return result;
			}
			
			return result;
		}
		
		public void insert(TreeNode node) {
			node.level = level+1;
			children.add(node);
		}
		
		public TreeNode deepestLeaf() {
			if(children.isEmpty()) return this;
			TreeNode deepestLeaf = null, temp;
			int deepestLevel = -1;
			
			
			for(TreeNode node: children) {
				temp = node.deepestLeaf();
				if(temp.level>deepestLevel) {
					deepestLevel = temp.level;
					deepestLeaf = temp;
				}
			}
			
			return deepestLeaf;
		}
	}
	
	public static TreeNode findManager(String manager, HashMap<String, Tree> CEOs) {
		TreeNode result = null;
		for(String CEO: CEOs.keySet()) {
			Tree curr = CEOs.get(CEO);
			result = curr.findChild(manager);
			if(result!=null && result.name.equals(manager)) return result;
		}
		
		return result;
	}
	
	public static void main(String args[]) throws Exception {
		FileReader in = new FileReader("input.txt");
		Scanner sc = new Scanner(in);
		FileWriter out = new FileWriter("output.txt");
		
		HashMap<String, Tree> CEOs = new HashMap<String, Tree>();
		HashMap<String, TreeNode> set = new HashMap<String, TreeNode>();
		
		String temp;
		String[] details = new String[3];
		
		while(sc.hasNext()) {
			temp = sc.nextLine();
			details = temp.split(",");
			
			details[0] = details[0].trim();
			details[2] = details[2].trim();
			
			if(details[2].equals("NOBODY")) {
				Tree tree = new Tree(details[0]);
				CEOs.put(details[0], tree);
			} else {
				TreeNode targetParent = findManager(details[2], CEOs);
				TreeNode child = new TreeNode(details[0]);
				if(targetParent!=null) targetParent.insert(child);
				else CEOs.get(details[2]).root.insert(child);
			}
			
			System.out.println(details[0]);
		}
		
		
		for(String CEO: CEOs.keySet()) {
			Tree ceo = CEOs.get(CEO);
			TreeNode emp = ceo.findLeaf();
			
			out.write(CEO+": "+emp.name+"\n");
		}
		
		sc.close();
		in.close();
		out.close();
		
		//System.out.println("Done!!");
	}
}

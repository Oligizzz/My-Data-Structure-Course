package app.DATASTRUCTURE.Test;

import app.DATASTRUCTURE.HuffmanCoding.Dao.Result;

public class node {
	String rode = "";
	public node left = null;
	public node right = null;
	int value = 1;
	public char c = '^';
	String result = "";

	public node() {
	}

	node(char c) {
		this.c = c;
	}

	public void add() {
		this.value++;
	}

	public void addleft(node a) {
		this.left = a;
	}

	public void addright(node a) {
		this.right = a;
	}

	public void printcode(Result res) {
		if (this.left == null && this.right == null) {
			res.add(this.c + ": " + this.rode + "\n");
			// System.out.println(this.c + ": " + this.rode);
			return;
		} else if (this.left != null && this.right == null) {
			this.left.rode = this.rode + "0";
		} else if (this.left == null && this.right != null) {
			this.right.rode = this.rode + "1";
		} else {
			this.left.rode = this.rode + "0";
			this.right.rode = this.rode + "1";
		}
		this.left.printcode(res);
		this.right.printcode(res);
	}

	public String getResult() {
		return this.result;
	}
}
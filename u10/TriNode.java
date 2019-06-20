package u10;

public class TriNode {
	public TriNode parent; // 父母
	public TriNode lchild; // 孩子
	public TriNode rchild; // 孩子

	public int level; // 层级
	public String name; // 队名
	public int score; // 得分

	public TriNode(TriNode parent, TriNode lchild, TriNode rchild, int level, String name, int score) {
		super();
		this.parent = parent;
		this.lchild = lchild;
		this.rchild = rchild;
		this.level = level;
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "TriNode [parent=" + parent + ", lchild=" + lchild + ", rchild=" + rchild + ", level=" + level
				+ ", name=" + name + ", score=" + score + "]";
	}

}

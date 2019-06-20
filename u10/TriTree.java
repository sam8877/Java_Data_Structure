package u10;

public class TriTree {
	public TriNode root;

	@Override
	public String toString() {
		return null;
	}

	public String toString(TriNode p) {
		String res = "";
		if (p == null) {
			res += "^";
		} else {
			System.out.print(p.name + ":" + p.score);
			if (p.lchild != null || p.rchild != null) {
				System.out.print("(");
				res += toString(p.lchild);
				System.out.print(",");
				res += toString(p.rchild);
				System.out.print(")");
			}
		}
		return res;
	}

}

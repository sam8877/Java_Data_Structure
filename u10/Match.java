package u10;

import u4.queue.LinkedQueue;
import u4.queue.Queue;
import u4.queue.SeqQueue;

/*
 * 用树存储比赛结果
 */
public class Match {
	
	public static void main(String[] args) {
		String[] names = { "1", "2", "3", "4" };
		int[] scores = { 1, 2, 3, 4, 5, 6 };
		Queue<TriNode> matchQueue = new LinkedQueue<>();
		Queue<Integer> scoreQueue = new SeqQueue<>();
		for (int i = 0; i < names.length; i++)
			matchQueue.add(new TriNode(null, null, null, -1, names[i], -1));
		for (int i = 0; i < scores.length; i++)
			scoreQueue.add(scores[i]);
		System.out.println(matchQueue+" "+scoreQueue);
		TriNode champ = null;
		while (!matchQueue.isEmpty() && !scoreQueue.isEmpty()) {
			TriNode p1 = matchQueue.poll();
			p1.score = scoreQueue.poll();
			TriNode p2 = matchQueue.poll();
			p2.score = scoreQueue.poll();
			TriNode p3 = new TriNode(null, p1, p2, -1, null, -1);
			p3.name = p1.score > p2.score ? p1.name : p2.name;
			matchQueue.add(p3);
			p1.parent = p2.parent = p3;
			champ = p3;
			System.out.println(p1+"---"+p2);
		}
		TriTree tree = new TriTree();
		tree.root = champ;
		
		System.out.println(tree);

	}

}

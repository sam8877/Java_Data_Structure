package bst;

/**
 * 二叉查找树
 *
 * @param <K>
 * @param <V>
 */
public class BST<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BST() {
    }

    /**
     * 插入的递归写法
     *
     * @param root
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    private Node<K, V> insertRecursion(Node<K, V> root, K key, V value) {
        if (root == null) return new Node<>(key, value);
        int res = key.compareTo(root.key);
        if (res < 0) {
            root.left = insertRecursion(root.left, key, value);
        } else if (res > 0) {
            root.right = insertRecursion(root.right, key, value);
        } else if (res == 0) {
            root.value = value;
        }
        return root;
    }

    /**
     * 插入的非递归写法
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    private void insertNoRecursion(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            return;
        }
        Node<K, V> p = root;
        Node<K, V> parent = null;
        while (p != null) {
            int res = key.compareTo(p.key);
            if (res == 0) {
                p.value = value;
                return;
            } else if (res < 0) {
                parent = p;
                p = p.left;
                if (p == null)
                    parent.left = new Node<>(key, value);
            } else {
                parent = p;
                p = p.right;
                if (p == null)
                    parent.right = new Node<>(key, value);
            }
        }
    }

    /**
     * 插入，指定是否递归
     *
     * @param key
     * @param value
     * @param recursion
     * @throws Exception
     */
    public void insert(K key, V value, boolean recursion) throws Exception {
        if (key == null) throw new RuntimeException("key不能为空");
        if (recursion) {
            this.insertRecursion(this.root, key, value);
        } else {
            this.insertNoRecursion(key, value);
        }
    }

    /**
     * 查找的递归写法
     *
     * @param key
     * @param from
     * @return
     * @throws Exception
     */
    private Node<K, V> getRecursion(K key, Node<K, V> from) {
        int res = key.compareTo(from.key);
        if (res < 0) {
            return getRecursion(key, from.left);
        } else if (res > 0) {
            return getRecursion(key, from.right);
        } else if (res == 0) {
            return from;
        }
        return null;
    }

    /**
     * 查找的非递归写法
     *
     * @param key
     * @param from
     * @return
     * @throws Exception
     */
    private Node<K, V> getNoRecursion(K key, Node<K, V> from) {
        Node p = from;
        while (p != null) {
            int res = key.compareTo(from.key);
            if (res < 0) {
                p = p.left;
            } else if (res > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 查找，指定是否递归
     *
     * @param key
     * @param recursion
     * @return
     * @throws Exception
     */
    public Node<K, V> get(K key, boolean recursion) {
        if (key == null) return null;
        if (recursion) {
            return this.getRecursion(key, this.root);
        } else {
            return this.getNoRecursion(key, this.root);
        }
    }

    /**
     * 删除指定key的节点 来源：https://www.cnblogs.com/shaonianpi/p/10466593.html
     *
     * @param key
     * @return 返回被删除的节点
     * @throws Exception
     */
    public Node<K, V> delete(K key) throws Exception {
        // 查找key值得节点，如果没有key，则直接返回null
        Node<K, V> node = this.get(key, false);
        if (node == null) return null;
        // 拷贝一份节点
        Node<K, V> ret = new Node<>(node.key, node.value);
        // 左子树的最大节点
        Node<K, V> lmax = this.deleteMax(node.left);
        node.key = lmax.key;
        node.value = lmax.value;
        return ret;
    }

    /**
     * 删除当前节点下的最小节点
     *
     * @param from
     * @return
     */
    private Node<K, V> deleteMin(Node<K, V> from) {
        // from为null或者from左节点为null
        if (from == null || from.left == null) return null;
        Node<K, V> parent = null;
        Node<K, V> p = from;
        while (p.left != null) {
            parent = p;
            p = p.left;
        }
        parent.left = null;
        return parent;

    }

    /**
     * 删除当前节点下的最大节点
     *
     * @param from
     * @return
     */
    private Node<K, V> deleteMax(Node<K, V> from) {
        // from为null或者from左节点为null
        if (from == null || from.right == null) return null;
        Node<K, V> parent = null;
        Node<K, V> p = from;
        while (p.right != null) {
            parent = p;
            p = p.right;
        }
        parent.right = null;
        return parent;

    }

    private Node<K, V> getMin(Node node) {
        if (root == null)
            return null;
        Node<K, V> p = node;
        while (p.left != null)
            p = p.left;
        return p;
    }

    private Node<K, V> getMax(Node node) {
        if (root == null)
            return null;
        Node<K, V> p = node;
        while (p.right != null)
            p = p.right;
        return p;
    }

}

/**
 * @param <K> key
 * @param <V> value
 */
class Node<K extends Comparable<K>, V> implements Comparable<Node<K, V>> {

    public Node<K, V> left;
    public Node<K, V> right;
    public K key;
    public V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node<K, V> o) {
        return key.compareTo(o.key);
    }
}

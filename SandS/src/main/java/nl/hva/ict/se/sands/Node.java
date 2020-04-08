package nl.hva.ict.se.sands;

/**
 * NOTE: You are NOT allowed to implement the Serializable interface!!
 */
public class Node implements Comparable<Node> {
    private Node left;
    private Node right;
    private int weight;
    private Character character;
    public Node linker, linkerBack;

    public Node(int weight, Character c) {
        this.weight = weight;
        this.character = c;
    }

    public Node(Node left, Node right) {
        this.weight = left.weight + right.weight;
        this.left = left;
        this.right = right;
    }


    @Override
    public int compareTo(Node o) {
        if(this.getWeight() == o.getWeight()) {
            if(o.isLeaf()) {
                return -1;
            } else if (this.getCharacter() != null && o.getCharacter() != null)  {
                return this.getCharacter().compareTo(o.getCharacter());
            } else if(this.getCharacter() != null && o.getCharacter() == null) {
                return 1;
            } else {
                return -1;
            }
        }
        return this.getWeight() - o.getWeight();
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getWeight() {
        return weight;
    }
    public void correctWeight(){
        this.weight-=1;
    }

    public Character getCharacter() {
        return character;
    }

    public boolean isLeaf(){
        assert ((left == null) && (right == null)) || ((left != null) && (right != null));
        return (left == null) && (right == null);
    }

}

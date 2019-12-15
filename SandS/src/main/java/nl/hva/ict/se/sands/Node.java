package nl.hva.ict.se.sands;

/**
 * NOTE: You are NOT allowed to implement the Serializable interface!!
 */
public class Node implements Comparable<Node> {
    private Node left;
    private Node right;
    private int weight;
    private Character character;
    private Node linker, linkerBack;

    public Node(int weight, Character c) {
        this.weight = weight;
        this.character = c;
    }

    public Node(Node left, Node right) {
        this.weight = left.weight + right.weight;
        this.left = left;
        this.right = right;
    }

    public Node getLinker(){
        return linker;
    }
    public void setLinker(Node node){
        linker = node;
    }
    public void setLinkerBack(Node node){
        linker.linkerBack = node;
    }

    public Node getLinkerBack(){
        return linkerBack;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
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

    public Character getCharacter() {
        return character;
    }

    public boolean isLeaf(){
        assert ((left == null) && (right == null)) || ((left != null) && (right != null));
        return (left == null) && (right == null);
    }

}

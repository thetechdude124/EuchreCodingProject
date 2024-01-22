public class Node {
    private int ID;
    private Node previous;
    private Node next; 

    public Node(int ID, Node previous, Node next) {
        this.ID = ID;
        this.previous = previous;
        this.next = next;
    }

    public int getID() {return ID;}
    public Node getPrevious() {return previous;}
    public Node getNext() {return next;}

    public void setID(int ID) {this.ID = ID;}
    public void setPrevious(Node previous) {this.previous = previous;}
    public void setNext(Node next) {this.next = next;}
}

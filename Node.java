package EuchreCodingProject;

public class Node {
    private int ID;
    private Member member;
    private Partnership partnership;
    private Node previous;
    private Node next; 

    public Node(int ID, Member member, Node previous, Node next) {
        this.ID = ID;
        this.member = member;
        this.previous = previous;
        this.next = next;
    }

    public Node(int ID, Partnership partnership, Node previous, Node next) {
        this.ID = ID;
        this.partnership = partnership;
        this.previous = previous;
        this.next = next;
    }

    public int getID() {return ID;}
    public Member getMember() {return member;}
    public Partnership getPartnership() {return partnership;}
    public Node getPrevious() {return previous;}
    public Node getNext() {return next;}

    public void setData(Member member) {this.member = member;}
    public void setPrevious(Node previous) {this.previous = previous;}
    public void setNext(Node next) {this.next = next;}
}

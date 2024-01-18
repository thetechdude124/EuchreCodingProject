package EuchreCodingProject;
import java.util.ArrayList;

public class Statistics {
    // Below are custom LinkedLists referred to by their head
    // All the members and partnerships are included in each of the LinkedLists, the purpose of the duplicates is to store sorted members for each stat 
    // There is an array that contains all the stat lists for each member and partnership
    private Node membersByNumGames;          //index0
    private Node membersByWins;              //index1
    private Node membersByLosses;            //index2
    private Node membersByOWins;             //index3
    private Node membersByDWins;             //index4
    private Node membersByOLosses;           //index5
    private Node membersByDLosses;           //index6
    private Node membersByWLRate;            //index7
    private Node membersByAvgScore;          //index8
    private ArrayList<Node> memberStats;
    private Node partnershipsByNumGames;     //index0
    private Node partnershipsByWins;         //index1
    private Node partnershipsByLosses;       //index2
    private Node partnershipsByOWins;        //index3
    private Node partnershipsByDWins;        //index4
    private Node partnershipsByOLosses;      //index5
    private Node partnershipsByDLosses;      //index6
    private Node partnershipsByWLRate;       //index7
    private Node partnershipsByAvgScore;     //index8
    private ArrayList<Node> partnershipStats;
    private Node node;

    public Statistics() {
        this.membersByNumGames = new Node(0, null, null, null);
        this.membersByWins = new Node(0, null, null, null);
        this.membersByLosses = new Node(0, null, null, null);
        this.membersByOWins = new Node(0, null, null, null);
        this.membersByDWins = new Node(0, null, null, null);
        this.membersByOLosses = new Node(0, null, null, null);
        this.membersByDLosses = new Node(0, null, null, null);
        this.membersByWLRate = new Node(0, null, null, null);
        this.membersByAvgScore = new Node(0, null, null, null);
        this.memberStats = new ArrayList<Node>();
        memberStats.add(membersByNumGames);
        memberStats.add(membersByWins);
        memberStats.add(membersByLosses);
        memberStats.add(membersByOWins);
        memberStats.add(membersByDWins);
        memberStats.add(membersByOLosses);
        memberStats.add(membersByDLosses);
        memberStats.add(membersByWLRate);
        memberStats.add(membersByAvgScore);
        this.partnershipsByNumGames = new Node(0, null, null, null);
        this.partnershipsByWins = new Node(0, null, null, null);
        this.partnershipsByLosses = new Node(0, null, null, null);
        this.partnershipsByOWins = new Node(0, null, null, null);
        this.partnershipsByDWins = new Node(0, null, null, null);
        this.partnershipsByOLosses = new Node(0, null, null, null);
        this.partnershipsByDLosses = new Node(0, null, null, null);
        this.partnershipsByWLRate = new Node(0, null, null, null);
        this.partnershipsByAvgScore = new Node(0, null, null, null);
        this.partnershipStats = new ArrayList<Node>();
        partnershipStats.add(partnershipsByNumGames);
        partnershipStats.add(partnershipsByWins);
        partnershipStats.add(partnershipsByLosses);
        partnershipStats.add(partnershipsByOWins);
        partnershipStats.add(partnershipsByDWins);
        partnershipStats.add(partnershipsByOLosses);
        partnershipStats.add(partnershipsByDLosses);
        partnershipStats.add(partnershipsByWLRate);
        partnershipStats.add(partnershipsByAvgScore);
    }

    public Object getMember(int userID) {
        node = membersByNumGames;
        while (node.getID() != userID && node.getNext() != null) {node = node.getNext();}
        if (node.getNext() == null) {return null;}
        return node.getMember();
    }

    public Object getPartnership(int partnershipID) {
        node = membersByNumGames;
        while (node.getID() != partnershipID && node.getNext() != null) {node = node.getNext();}
        if (node.getNext() == null) {return null;}
        return node.getPartnership();
    }

    public Node getMemberRanksByStat(int stat) {
        memberStats.set(stat, memberMergeSort(memberStats.get(stat), memberStats.size(), stat));
        return memberStats.get(stat);
    }

    public Node getPartnershipRanksByStat(int stat) {
        partnershipStats.set(stat, partnershipMergeSort(partnershipStats.get(stat), partnershipStats.size(), stat));
        return partnershipStats.get(stat);
    }

    // This section is for the sorting of any Member LinkedLists
    public void memberAddToEnd(Node tempNode, int ID, Member data) {  
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        } 
        Node newNode = new Node(ID, data, tempNode, null);
        tempNode.setNext(newNode);
    }

    private Node memberMergeSort(Node nodeA, int sortSize, int stat) {
        if (sortSize == 1) {return nodeA;} 
 
        node = nodeA;
        for(int i = 1; i < sortSize/2; i++) {node = node.getNext();}
        Node nodeB = node.getNext();
        node.setNext(null);

        nodeA = memberMergeSort(nodeA, sortSize/2, stat);
        nodeB = memberMergeSort(nodeB, sortSize-(sortSize/2), stat);

        return memberMerge(nodeA, nodeB, stat);
    }

    private Node memberMerge(Node nodeA, Node nodeB, int stat) {
        if (nodeA.getMember().getStats()[stat] < nodeB.getMember().getStats()[stat]) {
            node = new Node(nodeA.getID(), nodeA.getMember(), null, null); 
            nodeA = nodeA.getNext();
        } else {
            node = new Node(nodeB.getID(), nodeB.getMember(), null, null);
            nodeB = nodeB.getNext();
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA.getMember().getStats()[stat] < nodeB.getMember().getStats()[stat]) {
                memberAddToEnd(node, nodeA.getID(), nodeA.getMember());
                nodeA = nodeA.getNext();
            } else {
                memberAddToEnd(node, nodeB.getID(), nodeB.getMember());
                nodeB = nodeB.getNext();
            }
        }

        while (nodeA != null) {
            memberAddToEnd(node, nodeA.getID(), nodeA.getMember());
            nodeA = nodeA.getNext();
        }

        while (nodeB != null) {
            memberAddToEnd(node, nodeB.getID(), nodeB.getMember());
            nodeB = nodeB.getNext();
        }

        return node;
    }

    // This section is for the sorting of any Partnership LinkedLists
    public void partnershipAddToEnd(Node tempNode, int ID, Partnership data) {  
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        } 
        Node newNode = new Node(ID, data, tempNode, null);
        tempNode.setNext(newNode);
    }

    private Node partnershipMergeSort(Node nodeA, int sortSize, int stat) {
        if (sortSize == 1) {return nodeA;} 
 
        node = nodeA;
        for(int i = 1; i < sortSize/2; i++) {node = node.getNext();}
        Node nodeB = node.getNext();
        node.setNext(null);

        nodeA = partnershipMergeSort(nodeA, sortSize/2, stat);
        nodeB = partnershipMergeSort(nodeB, sortSize-(sortSize/2), stat);

        return partnershipMerge(nodeA, nodeB, stat);
    }

    private Node partnershipMerge(Node nodeA, Node nodeB, int stat) {        
        if (nodeA.getPartnership().getStats()[stat] < nodeB.getPartnership().getStats()[stat]) {
            node = new Node(nodeA.getID(), nodeA.getPartnership(), null, null); 
            nodeA = nodeA.getNext();
        } else {
            node = new Node(nodeB.getID(), nodeB.getPartnership(), null, null);
            nodeB = nodeB.getNext();
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA.getPartnership().getStats()[stat] < nodeB.getPartnership().getStats()[stat]) {
                partnershipAddToEnd(node, nodeA.getID(), nodeA.getPartnership());
                nodeA = nodeA.getNext();
            } else {
                partnershipAddToEnd(node, nodeB.getID(), nodeB.getPartnership());
                nodeB = nodeB.getNext();
            }
        }

        while (nodeA != null) {
            partnershipAddToEnd(node, nodeA.getID(), nodeA.getPartnership());
            nodeA = nodeA.getNext();
        }

        while (nodeB != null) {
            partnershipAddToEnd(node, nodeB.getID(), nodeB.getPartnership());
            nodeB = nodeB.getNext();
        }

        return node;
    }
    
}

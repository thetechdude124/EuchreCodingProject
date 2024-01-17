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
        this.membersByNumGames = new Node(0, null, null);
        this.membersByWins = new Node(0, null, null);
        this.membersByLosses = new Node(0, null, null);
        this.membersByOWins = new Node(0, null, null);
        this.membersByDWins = new Node(0, null, null);
        this.membersByOLosses = new Node(0, null, null);
        this.membersByDLosses = new Node(0, null, null);
        this.membersByWLRate = new Node(0, null, null);
        this.membersByAvgScore = new Node(0, null, null);
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
        this.partnershipsByNumGames = new Node(0, null, null);
        this.partnershipsByWins = new Node(0, null, null);
        this.partnershipsByLosses = new Node(0, null, null);
        this.partnershipsByOWins = new Node(0, null, null);
        this.partnershipsByDWins = new Node(0, null, null);
        this.partnershipsByOLosses = new Node(0, null, null);
        this.partnershipsByDLosses = new Node(0, null, null);
        this.partnershipsByWLRate = new Node(0, null, null);
        this.partnershipsByAvgScore = new Node(0, null, null);
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
        Node newNode = new Node(ID, data, null);
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
        Node nodeC;
        
        if (nodeA.getMember().getStats()[stat] < nodeB.getMember().getStats()[stat]) {
            nodeC = new Node(nodeA.getID(), nodeA.getMember(), null); 
            nodeA = nodeA.getNext();
        } else {
            nodeC = new Node(nodeB.getID(), nodeB.getMember(), null);
            nodeB = nodeB.getNext();
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA.getMember().getStats()[stat] < nodeB.getMember().getStats()[stat]) {
                memberAddToEnd(nodeC, nodeA.getID(), nodeA.getMember());
                nodeA = nodeA.getNext();
            } else {
                memberAddToEnd(nodeC, nodeB.getID(), nodeB.getMember());
                nodeB = nodeB.getNext();
            }
        }

        while (nodeA != null) {
            memberAddToEnd(nodeC, nodeA.getID(), nodeA.getMember());
            nodeA = nodeA.getNext();
        }

        while (nodeB != null) {
            memberAddToEnd(nodeC, nodeB.getID(), nodeB.getMember());
            nodeB = nodeB.getNext();
        }

        return nodeC;
    }

    // This section is for the sorting of any Partnership LinkedLists
    public void partnershipAddToEnd(Node tempNode, int ID, Member data) {  
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        } 
        Node newNode = new Node(ID, data, null);
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
        Node nodeC;
        
        if (nodeA.getMember().getStats()[stat] < nodeB.getMember().getStats()[stat]) {
            nodeC = new Node(nodeA.getID(), nodeA.getMember(), null); 
            nodeA = nodeA.getNext();
        } else {
            nodeC = new Node(nodeB.getID(), nodeB.getMember(), null);
            nodeB = nodeB.getNext();
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA.getMember().getStats()[stat] < nodeB.getMember().getStats()[stat]) {
                partnershipAddToEnd(nodeC, nodeA.getID(), nodeA.getMember());
                nodeA = nodeA.getNext();
            } else {
                partnershipAddToEnd(nodeC, nodeB.getID(), nodeB.getMember());
                nodeB = nodeB.getNext();
            }
        }

        while (nodeA != null) {
            partnershipAddToEnd(nodeC, nodeA.getID(), nodeA.getMember());
            nodeA = nodeA.getNext();
        }

        while (nodeB != null) {
            partnershipAddToEnd(nodeC, nodeB.getID(), nodeB.getMember());
            nodeB = nodeB.getNext();
        }

        return nodeC;
    }
    
}

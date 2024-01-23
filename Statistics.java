import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Statistics {
    // Below are custom LinkedLists referred to by their head
    // All the members and partnerships are included in each of the LinkedLists, the purpose of the duplicates is to store sorted members for each stat 
    // There is an array that contains all the stat lists for each member and partnership
    private HashMap<Integer, Member> allMembers;
    private Node[] memberStats;          // holds different ranking lists at each index, specified below
    /*
    membersByNumGames           //index0
    membersByWins               //index1
    membersByLosses             //index2
    membersByOWins              //index3
    membersByDWins              //index4
    membersByOLosses;           //index5
    membersByDLosses;           //index6
    membersByWLRate;            //index7
    membersByAvgScore;          //index8
    */
    private HashMap<Integer, Partnership> allPartnerships;
    private Node[] partnershipStats;    // holds different ranking lists at each index, specified below 
    /*
    partnershipsByNumGames;     //index0
    partnershipsByWins;         //index1
    partnershipsByLosses;       //index2
    partnershipsByOWins;        //index3
    partnershipsByDWins;        //index4
    partnershipsByOLosses;      //index5
    partnershipsByDLosses;      //index6
    partnershipsByWLRate;       //index7
    partnershipsByAvgScore;     //index8
    */
    private Node node;

    public Statistics() {
        this.allMembers = new HashMap<Integer, Member>();
        this.memberStats = new Node[9];

        this.allPartnerships = new HashMap<Integer, Partnership>();
        this.partnershipStats = new Node[9];
    }

    public Member getMember(int userID) {
        if (allMembers.containsKey(userID)) {
            return allMembers.get(userID);
        }
        return null;
    }

    public Partnership getPartnership(int userID) {
        if (allMembers.containsKey(userID)) {
            return allPartnerships.get(userID);
        }
        return null;
    }

    public void addMember(Member member) {
        allMembers.put(member.getUserID(), member);
        for (int i = 0; i <= 9; i++) {
            memberStats[i] = new Node(member.getUserID(), null, memberStats[i]);
        }
    }

    public void addPartnership(Partnership partnership) {
        allPartnerships.put(partnership.getUserID(), partnership);
        for (int i = 0; i <= 9; i++) {
            partnershipStats[i] = new Node(partnership.getUserID(), null, partnershipStats[i]);
        }
    }

    public void checkUsername(String username) {
        Collection<Member> list = allMembers.values();
        for (int i = 0; i < allMembers.size(); i++) {
            allMembers.
        }
        
    }

    public Node getMemberRanksByStat(int stat) {
        memberStats[stat] = memberMergeSort(memberStats[stat], memberStats.length, stat);
        return memberStats[stat];
    }

    public Node getPartnershipRanksByStat(int stat) {
        partnershipStats[stat] = partnershipMergeSort(partnershipStats[stat], partnershipStats.length, stat);
        return partnershipStats[stat];
    }

    private void addToEnd(Node tempNode, int userID) {  
        if (tempNode != null) {
            while (tempNode.getNext() != null) {
                tempNode = tempNode.getNext();
            } 
        }
        Node newNode = new Node(userID, tempNode, null);
        tempNode.setNext(newNode);
    }

    // This section is for the sorting of any Member LinkedLists
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
        if (allMembers.get(nodeA.getID()).getStats()[stat] < allMembers.get(nodeB.getID()).getStats()[stat]) {
            node = new Node(nodeA.getID(), null, null); 
            nodeA = nodeA.getNext();
        } else {
            node = new Node(nodeB.getID(), null, null);
            nodeB = nodeB.getNext();
        }

        while (nodeA != null && nodeB != null) {
            if (allMembers.get(nodeA.getID()).getStats()[stat] < allMembers.get(nodeB.getID()).getStats()[stat]) {
                addToEnd(node, nodeA.getID());
                nodeA = nodeA.getNext();
            } else {
                addToEnd(node, nodeB.getID());
                nodeB = nodeB.getNext();
            }
        }

        while (nodeA != null) {
            addToEnd(node, nodeA.getID());
            nodeA = nodeA.getNext();
        }

        while (nodeB != null) {
            addToEnd(node, nodeB.getID());
            nodeB = nodeB.getNext();
        }

        return node;
    }

    // This section is for the sorting of any Partnership LinkedLists
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
        if (allPartnerships.get(nodeA.getID()).getStats()[stat] < allPartnerships.get(nodeB.getID()).getStats()[stat]) {
            node = new Node(nodeA.getID(), null, null); 
            nodeA = nodeA.getNext();
        } else {
            node = new Node(nodeB.getID(), null, null);
            nodeB = nodeB.getNext();
        }

        while (nodeA != null && nodeB != null) {
            if (allPartnerships.get(nodeA.getID()).getStats()[stat] < allPartnerships.get(nodeB.getID()).getStats()[stat]) {
                addToEnd(node, nodeA.getID());
                nodeA = nodeA.getNext();
            } else {
                addToEnd(node, nodeB.getID());
                nodeB = nodeB.getNext();
            }
        }

        while (nodeA != null) {
            addToEnd(node, nodeA.getID());
            nodeA = nodeA.getNext();
        }

        while (nodeB != null) {
            addToEnd(node, nodeB.getID());
            nodeB = nodeB.getNext();
        }

        return node;
    }
    
}

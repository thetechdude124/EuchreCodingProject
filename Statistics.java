package EuchreCodingProject;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Statistics {
    // All the members and partnerships are included in each of the hashmaps, the purpose of the duplicates is to store sorted members for each stat 
    // There is an array that contains all the stat lists for each member and partnership
    private LinkedHashMap<Integer, Member> membersByWins;                   //index0
    private LinkedHashMap<Integer, Member> membersByLosses;                 //index1
    private LinkedHashMap<Integer, Member> membersByOWins;                  //index2
    private LinkedHashMap<Integer, Member> membersByDWins;                  //index3
    private LinkedHashMap<Integer, Member> membersByOLosses;                //index4
    private LinkedHashMap<Integer, Member> membersByDLosses;                //index5
    private LinkedHashMap<Integer, Member> membersByWLRate;                 //index6
    private LinkedHashMap<Integer, Member> membersByAvgScore;               //index7
    private ArrayList<LinkedHashMap<Integer, Member>> memberStats;
    private LinkedHashMap<Integer, Partnership> partnershipsByWins;         //index0
    private LinkedHashMap<Integer, Partnership> partnershipsByLosses;       //index1
    private LinkedHashMap<Integer, Partnership> partnershipsByOWins;        //index2
    private LinkedHashMap<Integer, Partnership> partnershipsByDWins;        //index3
    private LinkedHashMap<Integer, Partnership> partnershipsByOLosses;      //index4
    private LinkedHashMap<Integer, Partnership> partnershipsByDLosses;      //index5
    private LinkedHashMap<Integer, Partnership> partnershipsByWLRate;       //index6
    private LinkedHashMap<Integer, Partnership> partnershipsByAvgScore;     //index7
    private ArrayList<LinkedHashMap<Integer, Partnership>> partnershipStats;

    public Statistics() {
        this.membersByWins = new LinkedHashMap<Integer, Member>();
        this.membersByLosses = new LinkedHashMap<Integer, Member>();
        this.membersByOWins = new LinkedHashMap<Integer, Member>();
        this.membersByDWins = new LinkedHashMap<Integer, Member>();
        this.membersByOLosses = new LinkedHashMap<Integer, Member>();
        this.membersByDLosses = new LinkedHashMap<Integer, Member>();
        this.membersByWLRate = new LinkedHashMap<Integer, Member>();
        this.membersByAvgScore = new LinkedHashMap<Integer, Member>();
        this.memberStats = new ArrayList<LinkedHashMap<Integer, Member>>();
        memberStats.add(membersByWins);
        memberStats.add(membersByLosses);
        memberStats.add(membersByOWins);
        memberStats.add(membersByDWins);
        memberStats.add(membersByOLosses);
        memberStats.add(membersByDLosses);
        memberStats.add(membersByWLRate);
        memberStats.add(membersByAvgScore);
        this.partnershipsByWins = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByLosses = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByOWins = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByDWins = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByOLosses = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByDLosses = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByWLRate = new LinkedHashMap<Integer, Partnership>();
        this.partnershipsByAvgScore = new LinkedHashMap<Integer, Partnership>();
        this.partnershipStats = new ArrayList<LinkedHashMap<Integer, Partnership>>();
        partnershipStats.add(partnershipsByWins);
        partnershipStats.add(partnershipsByLosses);
        partnershipStats.add(partnershipsByOWins);
        partnershipStats.add(partnershipsByDWins);
        partnershipStats.add(partnershipsByOLosses);
        partnershipStats.add(partnershipsByDLosses);
        partnershipStats.add(partnershipsByWLRate);
        partnershipStats.add(partnershipsByAvgScore);
    }

    public Member getMember(int userID) {return membersByWins.get(userID);}
    public Partnership getPartnership(int partnershipID) {return partnershipsByWins.get(partnershipID);}

}

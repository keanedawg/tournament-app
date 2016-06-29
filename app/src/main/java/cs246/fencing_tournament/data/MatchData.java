package cs246.fencing_tournament.data;

import java.util.List;

/**
 * Created by alanxoc3 on 6/8/16.
 */
public class MatchData {
    private int id1;
    private int p1Score;
    private int id2;
    private int p2Score;
    private int vicId;

    // Default Constructor
    public MatchData() {
        id1 = -1;
        id2 = -1;
        p1Score = 0;
        p2Score = 0;
        vicId = -1;
    }
    // Non Default Constructor
    public MatchData(int Id1, int Id2) {
        id1 = Id1;
        id2 = Id2;
        p1Score = 0;
        p2Score = 0;
        vicId = -1;
    }

    public ContestantData getP1(List<ContestantData> conList) {
        return ContestantData.findById(conList, id1);
    }

    public ContestantData getP2(List<ContestantData> conList) {
        return ContestantData.findById(conList, id1);
    }

    public void applyResults(List<ContestantData> conList) {
        ContestantData con1 = getP1(conList);
        ContestantData con2 = getP2(conList);

        con1.addMatch(this);
        con2.addMatch(this);
    }

    public void setId1(int x){
        id1 = x;
    }
    public void setP1Score(int x){
        p1Score = x;
    }
    public void setId2(int x){
        id2 = x;
    }
    public void setP2Score(int x){
        p2Score = x;
    }
    public void setVicId(int x){
        vicId = x;
    }
    public int getId1(){
        return id1;
    }
    public int getP1Score(){
        return p1Score;
    }
    public int getId2(){
        return id2;
    }
    public int getP2Score(){
        return p2Score;
    }
    public int getVicId(){
        return vicId;
    }
    public void pointP1() {
        if (getP1Score() > 15){
            setP1Score(getP1Score() + 1);
        }
    }
    public void pointP2() {
        if (getP2Score() > 15){
            setP2Score(getP2Score() + 1);
        }
    }
}

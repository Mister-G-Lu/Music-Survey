package project5;

import project5.AllEnum.*;

/**
 * prefference represents as heard and likes count.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class Preference {

    /**
     * the first entry of int[] is total count, second is yes count.
     */
    private int[] heard;
    private int[] likes;


    /**
     * create a prefference type with 0 heard and likes.
     */
    public Preference() {
        heard = new int[2];
        likes = new int[2];
    }


    /**
     * add count to prefferces smartly(sort of).
     * 
     * @param currePerson
     *            current person that has prefferces on.
     */
    public void smartCountAdder(Person currePerson) {
        responseEnum heard = currePerson.getHeard();
        responseEnum like = currePerson.getLike();
        if (heard == responseEnum.YES) {
            addOneYesHeardCount();
        }
        // NO only add to total cound. BLANK add nothing.
        else if (heard == responseEnum.NO) {
            addOneHeardTotalCount();
        }

        if (like == responseEnum.YES) {
            addOneYesLikesCount();
        }
        // NO only add to total cound. BLANK add nothing.
        else if (like == responseEnum.NO) {
            addOneLikesTotalCount();
        }
    }


    /**
     * get the heard count array in this class.
     * 
     * @return retruns heard count array.
     */
    public int[] getHeardCount() {
        return heard;
    }


    /**
     * get the Likes count array in this class.
     * 
     * @return retruns Likes count array.
     */
    public int[] getLikesCount() {
        return likes;
    }


    /**
     * add one to total heard count.
     */
    private void addOneHeardTotalCount() {
        heard[0]++;
    }


    /**
     * add one to total likes count.
     */
    private void addOneLikesTotalCount() {
        likes[0]++;
    }


    /**
     * add one yes to heard count.
     */
    private void addOneYesHeardCount() {
        // yes will add into total count and yes count,
        // no does not.
        addOneHeardTotalCount();
        heard[1]++;
    }


    /**
     * add one yes to likes count.
     */
    private void addOneYesLikesCount() {
        // yes will add into total count and yes count,
        // no does not.
        addOneLikesTotalCount();
        likes[1]++;
    }


    /**
     * get heard count percentage
     * 
     * @return returns a int that * 100 represent percentage
     */
    public int getHeardPercent() {
        double total = heard[0];
        double yes = heard[1];
        return (int)Math.round(yes / total * 100);
    }


    /**
     * get likes count percentage
     * 
     * @return returns a int that * 100 represent percentage
     */
    public int getLikesPercent() {
        double total = likes[0];
        double yes = likes[1];
        return (int)Math.round(yes / total * 100);
    }


    /**
     * check if two prefferences are equal.
     * 
     * @return returns true only if all fields are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(
                "the other prefference cannot be null");
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Preference other = (Preference)obj;
        return this.heard[0] == (other.getHeardCount()[0])
            && this.likes[0] == (other.getLikesCount()[0])
            && this.heard[1] == (other.getHeardCount()[1])
            && this.likes[1] == (other.getLikesCount()[1]);
    }


    /**
     * convert heard and likes into sttring.
     * 
     * @return returns string version of heard and likes.
     */
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Heard(total/yes): " + String.valueOf(heard[0]) + "/" + String
            .valueOf(heard[1]));
        b.append(" Likes(total/yes): " + String.valueOf(likes[0]) + "/" + String
            .valueOf(likes[1]));
        return b.toString();
    }
}

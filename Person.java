package project5;

import project5.AllEnum.*;

/**
 * Person represents major, hobby, answers on single song.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class Person {
    private hobbyEnum hobby;
    private majorEnum major;
    private regionEnum region;
    private responseEnum heard;
    private responseEnum like;


    /**
     * create new person object with major, region and hoby.
     * 
     * @param major
     *            major of person.
     * @param region
     *            region of the person.
     * @param hobby
     *            hobby of the person.
     * @param responses
     *            reponses of the single song made by this person.
     */
    public Person(
        majorEnum major,
        regionEnum region,
        hobbyEnum hobby,
        responseEnum response1,
        responseEnum response2) {
        this.major = major;
        this.region = region;
        this.hobby = hobby;
        // only 2 slots.
        heard = response1;
        like = response2;
    }


    /**
     * get the major of this person.
     * 
     * @return returns the major enum of this person.
     */
    public majorEnum getMajor() {
        return major;
    }


    /**
     * get the hobby of this person.
     * 
     * @return returns the hobby enum of this person.
     */
    public hobbyEnum getHobby() {
        return hobby;
    }


    /**
     * get the region of this person.
     * 
     * @return returns region enum of this person.
     */
    public regionEnum getRegion() {
        return region;
    }


    /**
     * get the first response of this person on single music.
     * 
     * @return returns the first response enum.
     */
    public responseEnum getHeard() {
        return heard;
    }


    /**
     * get the second response of this person on single music.
     * 
     * @return returns the second response enum.
     */
    public responseEnum getLike() {
        return like;
    }


    /**
     * convert the person object into string
     * 
     * @return returns the format: {major, hobby, region, [reponse 1, reponse
     *         2]}
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        builder.append(major + " ");
        builder.append(hobby + " ");
        builder.append(region + " ");
        builder.append("[" + heard + " ");
        builder.append(like + "]}");
        return builder.toString();
    }


    /**
     * convert person info into array.
     * 
     * @return array of info storing in person.
     */
    public Object[] toArray() {
        Object[] tempArray = new Object[5];
        tempArray[0] = major;
        tempArray[1] = region;
        tempArray[2] = hobby;
        tempArray[3] = heard;
        tempArray[4] = like;
        return tempArray;
    }


    /**
     * check whether 2 person are equal.
     * 
     * @return returns true only if all 5 fields are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("the other person cannot be null");
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Person other = (Person)obj;
        return this.major.equals(other.getMajor()) && this.region.equals(other
            .getRegion()) && this.getHobby().equals(other.getHobby())
            && this.heard.equals(other.getHeard()) && this.like.equals(other
                .getLike());
    }

}

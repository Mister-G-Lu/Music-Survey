/**
 * 
 */
package project5;

/**
 * @author Goodwin Lu
 * @version 11/13/2018
 *          Person class.
 */
public class Person {
    private String hobby;
    private String major;
    private String region;
    // the responses tell of all the responses to all the songs.
    private String[] responses;


    /**
     * default constructor.
     * 
     * @param h
     *            the hobby
     * @param m
     *            the major
     * @param r
     *            the responses
     */
    public Person(String h, String m, String r) {
        hobby = h;
        major = m;
        region = r;
        responses = new String[100];
    }


    /**
     * get the hobby
     * 
     * @return
     *         hobby
     */
    public String getHobby() {
        return hobby;
    }


    /**
     * get the major
     * 
     * @return
     *         major
     */
    public String getMajor() {
        return major;
    }


    /**
     * get the region
     * 
     * @return
     *         region
     */
    public String getRegion() {
        return region;
    }


    /**
     * get the response array
     * 
     * @return
     *         responses
     */
    public String[] getResponses() {
        return responses;
    }

}

/**
 * 
 */
package project5;

import java.util.ArrayList;

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
    private ArrayList<String> responses;


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
    public Person(String m, String r, String h) {
        hobby = h;
        major = m;
        region = r;
        responses = new ArrayList<String>();
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
    public ArrayList<String> getResponses() {
        return responses;
    }

    /**
     * add new response. 
     * @param response new response. 
     */
    public void addResponses(String response) {
        responses.add(response);
    }
    
}

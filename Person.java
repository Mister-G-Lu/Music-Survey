/**
 * 
 */
package prj5;

import java.util.ArrayList;
import prj5.AllEnum.*;

/**
 * @author Goodwin Lu
 * @author gengzelyu
 * @version 11/13/2018
 *          Person class.
 */
public class Person {
    private hobbyEnum hobby;
    private majorEnum major;
    private regionEnum region;
    // the responses tell of all the responses to all the songs.
    private ArrayList<responseEnum> responses;


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
        hobby = hobbyHelper(h);
        major = majorHelper(m);
        region = regionHelper(r);
        responses = new ArrayList<responseEnum>();
    }


    /**
     * healper method to choose hobby.
     * 
     * @param hobby
     *            string hobby
     * @return hobbyEnum represents as hobby.
     */
    private hobbyEnum hobbyHelper(String hobby) {
        switch (hobby) {
            case ("sports"):
                return hobbyEnum.SPORTS;
            case ("reading"):
                return hobbyEnum.READ;
            case ("art"):
                return hobbyEnum.ART;
            case ("music"):
                return hobbyEnum.MUSIC;
            // defalt is blank.
            default:
                return hobbyEnum.BLANK;
        }
    }


    /**
     * healper method to choose region.
     * 
     * @param region
     *            string region
     * @return regionEnum represents as horegionbby.
     */
    private regionEnum regionHelper(String region) {
        switch (region) {
            case ("Southeast"):
                return regionEnum.SEUS;
            case ("Northeast"):
                return regionEnum.NEUS;
            case ("United States (other than Southeast or Northwest)"):
                return regionEnum.RESTUS;
            case ("Outside of United States"):
                return regionEnum.OUTUS;
            // defalt is blank.
            default:
                return regionEnum.BLANK;
        }
    }


    /**
     * healper method to choose major.
     * 
     * @param major
     *            string major
     * @return majorEnum represents as major.
     */
    private majorEnum majorHelper(String major) {
        switch (major) {
            case ("Math or CMDA"):
                return majorEnum.MATHCMDA;
            case ("Computer Science"):
                return majorEnum.CS;
            case ("Other Engineering"):
                return majorEnum.OTHERENG;
            case ("other"):
                return majorEnum.OTHER;
            // defalt is blank.
            default:
                return majorEnum.BLANK;
        }
    }


    /**
     * get the hobby
     * 
     * @return
     *         hobby
     */
    public hobbyEnum getHobby() {
        return hobby;
    }


    /**
     * get the major
     * 
     * @return
     *         major
     */
    public majorEnum getMajor() {
        return major;
    }


    /**
     * get the region
     * 
     * @return
     *         region
     */
    public regionEnum getRegion() {
        return region;
    }


    /**
     * get the response array
     * 
     * @return
     *         responses
     */
    public ArrayList<responseEnum> getResponses() {
        return responses;
    }


    /**
     * add new response.
     * 
     * @param response
     *            new response.
     */
    public void addResponses(String response) {
        responses.add(responseHelper(response));
    }


    /**
     * add response helper.
     * 
     * @param response
     *            string response
     * @return returns responseEnum represents as response.
     */
    private responseEnum responseHelper(String response) {
        switch (response) {
            case ("Yes"):
                return responseEnum.YES;
            case ("No"):
                return responseEnum.NO;
            // defalt is blank.
            default:
                return responseEnum.BLANK;
        }
    }


    /**
     * transfer person into string.
     * 
     * @return returns string represents person.
     */
    public String toString() {
        return "{" + major + ", " + region + ", " + hobby + ", " + responses
            + "}";
    }

}

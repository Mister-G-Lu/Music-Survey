/**
 * 
 */
package project5;

import com.sun.syndication.feed.atom.Person;

/**
 * @author Goodwin Lu
 * @version 11/5/2018
 * Calculate the people in a specific region/major/hobby,
 * by accessing their info from their own class
 */
public class RepresentSurvey {
    private LinkedList<T[]> allSongs;
    private int region[];
    private int major[];
    private int hobby[];

    /**
    * represent survey constructor, instantiates the arrays.
    */
    public RepresentSurvey(LinkedList<T[]> temp) {
        allSongs = temp;
        region = int[4];
        major = int[4];
        hobby = int[4];
        for (int i=0; i<4; i++){
            region[i] = 0;
            major[i] = 0;
            major[i] = 0;
                
        }
    }
    
    /**
    * get region array
    * @return
    * region
    */
    public int[] getRegion(){
        return region;
    }
 /**
    * get major array
    * @return
    * major
    */
    public int[] getMajor(){
        return major;
    } 
    /**
    * get hobby array
    * @return
    * hobby
    */
    public int[] getHobby(){
        return hobby;
    }
    
    public enum regionEnum {};
    /**
     * represent via region
     */
    public void representRegion() {
        // Northeast US, Southeast US, the rest of US, outside the US
        
        for (int i = 0; i < allSongs.size(); i++) {
            if(allSongs[4].getRegion() == regionEnum.NEUS){
                major[0]++;
            } if(allSongs[4].getRegion() == regionEnum.SEUS){
                major[1]++;
            } else if(allSongs[4].getRegion() == regionEnum.RESTUS){
                major[2]++;
            }
            else if(allSongs[4].getRegion() == regionEnum.OUTUS){
                major[3]++;
            }
            System.out.println("NE: "+ major[0] + "SE: " + major[1] 
                               + "Rest: " + major[2] + "Outside: "+ major[3]);
        }
    }


    /**
     * represent via hobby
     */
    public void representHobby() {
        // example: reading:0 art:0 sports:50 music:0
        for (int i = 0; i < allSongs.size(); i++) {
            if (allSongs[4].getHobby() == hobbyEnum.READ) {
                hobby[0]++;
            }
            else if (allSongs[4].getHobby() == hobbyEnum.ART) {
                hobby[1]++;
            }
            else if (allSongs[4].getHobby() == hobbyEnum.SPORTS) {
                hobby[2]++;
            }
            else if (allSongs[4].getHobby() == hobbyEnum.MUSIC) {
                hobby[3]++;
            }
        }
    }


    /**
     * represent major
     */
    public void representMajor() {
        // Computer Science, Other Engineering, Math or CMDA, Other
        for (int i = 0; i < allSongs.size(); i++) {
            if (allSongs[4].getMajor() == majorEnum.CS){
                major[0]++;
            }
            else if (allSongs[4].getMajor() == majorEnum.OTHERENG){
                major[1]++;
            }
            else if (allSongs[4].getMajor() == majorEnum.MATHCMDA){
                major[2]++;
            }
            else if (allSongs[4].getMajor() == majorEnum.OTHER){
               major[3]++;
            }
        }
    }
}

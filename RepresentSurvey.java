/**
 * 
 */
package project5;

import com.sun.syndication.feed.atom.Person;

/**
 * @author Goodwin Lu
 * @version 11/5/2018
 */
public class RepresentSurvey {
    private LinkedList<T[]> allSongs;


    public RepresentSurvey(LinkedList<T[]> temp) {
        allSongs = temp;
    }


    /**
     * represent via region
     */
    public void representRegion() {
        // Northeast US, Southeast US, the rest of US, outside the US

        for (int i = 0; i < allSongs.size(); i++) {
            allSongs[4].getRegion();
        }
    }


    /**
     * represent via hobby
     */
    public void representHobby() {
        // example: reading:0 art:0 sports:50 music:0
        int read = 0;
        int art = 0;
        int sports = 0;
        int music = 0;
        for (int i = 0; i < allSongs.size(); i++) {
            if (allSongs[4].getHobby() == hobbyEnum.READ) {
                read++;
            }
            else if (allSongs[4].getHobby() == hobbyEnum.ART) {
                art++;
            }
            else if (allSongs[4].getHobby() == hobbyEnum.SPORTS) {
                sports++;
            }
            else if (allSongs[4].getHobby() == hobbyEnum.MUSIC) {
                music++;
            }
        }
        System.out.println("reading:" + read + " art:" + art + " sports:"
            + sports + " music:" + music);
    }


    /**
     * represent major
     */
    public void representMajor() {
        // Computer Science, Other Engineering, Math or CMDA, Other
        for (int i = 0; i < allSongs.size(); i++) {
            allSongs[4].getMajor();
        }
    }
}

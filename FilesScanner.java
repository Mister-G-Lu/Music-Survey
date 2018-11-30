package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import project5.AllEnum.*;

/**
 * scan files and store into song list.
 * 
 * @author gengzelyu
 * @version 2018.11.29
 */
public class FilesScanner {

    private String surveyFileName;
    private static SongList rawSongList;


    /**
     * create a files scanner that scan song list and survey.
     * 
     * @param args
     *            arguments of song lis file name and survet file name.
     *            the [0]is survey file and [0] is songlist file.
     */
    public FilesScanner(String[] args) throws FileNotFoundException {
        rawSongList = scanFiles(args[0], args[1]);
    }


    /**
     * returns the scanned song list store in this class.
     * 
     * @return retuns scanned song list.
     */
    public SongList getScannedSongList() {
        return rawSongList;
    }


    /**
     * scan files and add data to list.
     * 
     * @param surveyFileName
     *            file name of survey data.
     * @param songListName
     *            file name of song list data.
     * @return returns songlist scanned from files.
     */
    private SongList scanFiles(String surveyFileName, String songListName)
        throws FileNotFoundException {
        // save it for scanner resetter.
        this.surveyFileName = surveyFileName;
        Scanner surveyScanner = null;
        Scanner songListScanner = null;
        surveyScanner = new Scanner(new File(surveyFileName));
        songListScanner = new Scanner(new File(songListName));
        SongList localList = listMaker(surveyScanner, songListScanner);
        return localList;
    }


    /**
     * create list from scanner files.
     * 
     * @param surveyScanner
     *            survey scanner.
     * @param songListScanner
     *            song list scanner.
     * @return returns songlist scanned from files.
     */
    private SongList listMaker(Scanner surveyScanner, Scanner songListScanner)
        throws FileNotFoundException {
        // skip first line.
        // song index in the song list. use in survey scanner to skipp answers.
        int songIndex = 0;
        SongList localList = new SongList();
        Scanner localSurveyFileScanner = surveyScanner;
        // skip first line in song list.
        songListScanner.nextLine();
        surveyScanner.nextLine();
        while (songListScanner.hasNextLine()) {
            SurveyStat songStat = scanSureveyFile(localSurveyFileScanner,
                songIndex);
            Song newSong = songListScanner(songListScanner);
            newSong.setSurveyStatistic(songStat);
            localList.add(newSong);
            localSurveyFileScanner = resetSurveyFileScanner();
            songIndex += 2;
        }
        surveyScanner.close();
        songListScanner.close();
        return localList;
    }


    /**
     * reset survey file scanner.
     * 
     * @return returns new survey file scanner.
     */
    private Scanner resetSurveyFileScanner() throws FileNotFoundException {
        Scanner surveyScanner = new Scanner(new File(surveyFileName));
        surveyScanner.nextLine();
        return surveyScanner;
    }


    /**
     * scan song list file and create song array.
     * 
     * @param songListData
     *            song list scanner.
     * @return returns an array storing song info.
     */
    private Song songListScanner(Scanner scanner) {
        // cant use scanner cause a line is not seperated by space.
        String[] aLine = scanner.nextLine().split(",");
        // create a null survet that will be set in othe class.
        SurveyStat nullSurvey = null;
        // {title, artist, year, genre, survey}
        return new Song(aLine[0].trim(), aLine[1].trim(), aLine[2].trim(),
            aLine[3].trim(), nullSurvey);
    }


    /**
     * scan survey file and create a person class.
     * 
     * @param surveyScanner
     *            surey file scanner.
     * @return returns complete survey statistic of a song.
     */
    private SurveyStat scanSureveyFile(Scanner scanner, int songIndex) {
        // the first line has no data.
        SurveyStat songStat;
        PeopleList people = new PeopleList();
        while (scanner.hasNextLine()) {
            // split a line into string[]
            String[] aLine = scanner.nextLine().replaceAll(",", ", ").split(
                ",");
            String major = aLine[2].trim();
            String region = aLine[3].trim();
            String hobby = aLine[4].trim();
            // skill nth song
            String heard = aLine[5 + songIndex].trim();
            String like = aLine[6 + songIndex].trim();
            // create new peson using helper method.
            Person newbie = personCreateHelper(major, region, hobby, heard,
                like);
            people.add(newbie);
        }
        scanner.close();
        songStat = new SurveyStat(people);
        return songStat;
    }


    /**
     * create new Person type with given string.
     * 
     * @param major
     *            string major
     * @param region
     *            string region.
     * @param hobby
     *            hobby string.
     * @param heard
     *            heard string.
     * @param like
     *            like string.
     * @return
     */
    private Person personCreateHelper(
        String majorString,
        String regionString,
        String hobbyString,
        String heardString,
        String likeString) {
        majorEnum major = majorHelper(majorString);
        regionEnum region = regionHelper(regionString);
        hobbyEnum hobby = hobbyHelper(hobbyString);
        responseEnum heard = preffHelper(heardString);
        responseEnum like = preffHelper(likeString);
        Person newbie = new Person(major, region, hobby, heard, like);
        return newbie;
    }


    /**
     * helper method that convert string prefferece into enum.
     * 
     * @param responseEnum
     *            string prefferece.
     * @return returns one of the response enum.
     */
    private responseEnum preffHelper(String preffString) {
        if (preffString.equals("Yes")) {
            return responseEnum.YES;
        }
        else if (preffString.equals("No")) {
            return responseEnum.NO;
        }
        return responseEnum.BLANK;
    }


    /**
     * helper method that convert string major into enum.
     * 
     * @param majorString
     *            string major.
     * @return returns one of the major enum.
     */
    private majorEnum majorHelper(String majorString) {
        switch (majorString) {
            case "Computer Science":
                return majorEnum.CS;
            case "Other Engineering":
                return majorEnum.OTHERENG;
            case "Math or CMDA":
                return majorEnum.MC;
            case "Other":
                return majorEnum.OTHER;
            default:
                return majorEnum.BLANK;
        }
    }


    /**
     * helper method that convert string region into enum.
     * 
     * @param regionString
     *            string region.
     * @return returns one of the region enum.
     */
    private regionEnum regionHelper(String regionString) {
        switch (regionString) {
            case "Northeast":
                return regionEnum.NEUS;
            case "Southeast":
                return regionEnum.SEUS;
            case "United States (other than Southeast or Northwest)":
                return regionEnum.RESTUS;
            case "Outside of United States":
                return regionEnum.OUTUS;
            default:
                return regionEnum.BLANK;
        }
    }


    /**
     * helper method that convert string hobby into enum.
     * 
     * @param hobbyString
     *            string hobby.
     * @return returns one of the hobby enum.
     */
    private hobbyEnum hobbyHelper(String hobbyString) {
        switch (hobbyString) {
            case "reading":
                return hobbyEnum.READ;
            case "art":
                return hobbyEnum.ART;
            case "sports":
                return hobbyEnum.SPORTS;
            case "music":
                return hobbyEnum.MUSIC;
            default:
                return hobbyEnum.BLANK;
        }
    }
}

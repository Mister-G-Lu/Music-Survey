package project5;

/**
 * a song contains song title, artiest, year, genre.
 * 
 * @author gengzelyu
 *
 */
public class Song {
    private String title;
    private String artist;
    private String year;
    private String genre;
    private SurveyStat survey;


    /**
     * create a song type with 5 entries.
     * 
     * @param songTitle
     *            the tile of song.
     * @param artist
     *            the artist of the song.
     * @param year
     *            the year that the song was made.
     * @param genre
     *            the genre of the song.
     * @param surveyStatistic
     *            the survey statistic of the song.
     */
    public Song(
        String songTitle,
        String artist,
        String year,
        String genre,
        SurveyStat surveyStatistic) {
        this.title = songTitle;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.survey = surveyStatistic;
    }


    /**
     * set the survey statistic.
     * 
     * @param survey
     *            the new survey statistic.
     */
    public void setSurveyStatistic(SurveyStat survey) {
        this.survey = survey;
        if (survey == null) {
            throw new IllegalArgumentException("survey cannot be null.");
        }
    }


    /**
     * get the titile of song.
     * 
     * @return returns title of song.
     */
    public String getTitle() {
        return title;
    }


    /**
     * get the artist of song
     * 
     * @return returns artist of song.
     */
    public String getArtist() {
        return artist;
    }


    /**
     * get the year of the song.
     * 
     * @return returns string of year.
     */
    public String getYear() {
        return year;
    }


    /**
     * get the genre of song.
     * 
     * @return returns genre of song.
     */
    public String getGenre() {
        return genre;
    }


    /**
     * get the survey statistic.
     * 
     * @return returns survey.
     */
    public SurveyStat getSurveyStatistic() {
        return survey;
    }


    /**
     * compare the string in this song with string in other song, regardless
     * case.
     * 
     * @param thisS
     *            the string field in this class.
     * @param otherS
     *            the string field in other class.
     * @return returns int representing the aplhabetical oder.
     *          <0 means this string is smaller than other. 
     *          >0 means this string is bigger than other. 
     *          =0 means have same oder. 
     */
    public int compareTo(String thisS, String otherS) {
        return thisS.toLowerCase().trim().compareTo(otherS.toLowerCase()
            .trim());
    }


    /**
     * convert the data store in fields into string.
     * 
     * @return returns data in string.
     */
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(title + " ");
        b.append(artist + " ");
        b.append(year + " ");
        b.append(genre + " ");
        b.append("\nSURVEY STAT:\n" + survey);
        return b.toString();
    }


    /**
     * check if 2 songs are equal.
     * 
     * @param obj
     *            the other song.
     * @return returns true only if all data fields are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("the other song cannot be null");
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Song other = (Song)obj;
        return this.title.equals(other.getTitle()) && this.artist.equals(other
            .getArtist()) && this.year.equals(other.getYear()) && this.survey
                .equals(other.getSurveyStatistic());
    }
}

package project5;

/**
 * songs list contain basic info of a song and its survey mySong.
 * 
 * @author gengzelyu
 * @version 2018.11.29
 */
public class SongList extends LinkedList<Song> {

    /**
     * create a song list by creating a linked list.
     */
    public SongList() {
        super();
    }


    /**
     * add new song into SongList and check legal of new song.
     * 
     * @param newSong
     *            new song that is needed to add into list.
     */
    @Override
    public void add(Song newSong) {
        checkLegal(newSong);
        add(size, newSong);
    }


    /**
     * check legal of the new entry.
     */
    private void checkLegal(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("new song cannot be null");
        }
        if (song.getSurveyStatistic() == null) {
            throw new IllegalArgumentException(
                "survey statisitc cannot be null");
        }
    }


    /**
     * get song at the given index.
     * 
     * @param index
     *            index of song in songList.
     * @return returns song at index.
     */
    public Song getSong(int index) {
        return this.getData(index);
    }


    /**
     * get the this song list(after sorting).
     * 
     * @return returns this song list.
     */
    private SongList getSongList() {
        return this;
    }


    /**
     * sort song list wiht alphabetical order based on request.
     * 
     * @param request
     *            choose one of String{title, artist, year, genre} as sort
     *            request.
     * @return returns sorted song list based on request
     */
    public SongList insertSort(String request) {
        if (!isEmpty()) {
            assert head != null;
            Node<Song> unsorted = head.next.next;
            assert unsorted != null;
            head.next.setNext(null);
            // insert node.
            while (unsorted.next != null) {
                Node<Song> nodeToInsert = unsorted;
                unsorted = unsorted.next;
                insertStringInOrder(nodeToInsert, request);
            }
            // repositioning head and tail.
            head.setNext(getFirstNode());
            tail.setPrevious(getLastNode());
        }
        return getSongList();
    }


    /**
     * insert song into song list
     * 
     * @param songToInsert
     *            song to be insert.
     * @param request
     *            request of sortion, {title, year, artist, genre}.
     */
    private void insertStringInOrder(
        Node<Song> songToInsert,
        // get string in array with index.
        String request) {
        // uses [index] due to SortedList<Song[]>
        Node<Song> currentNode = head.getNextNode();
        Node<Song> previousNode = null;
        Song mySong = songToInsert.getData();
        Song currSong = currentNode.getData();
        // compare order
        while ((currentNode != null) && (this.compareToHelper(request, mySong,
            currentNode.getData()) > 0)) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();

        }
        // insert order
        if (previousNode != null) {
            previousNode.setNext(songToInsert);
            songToInsert.setNext(currentNode);
        }
        // place it at beginning.
        else {
            songToInsert.setNext(currentNode);
            songToInsert.setPrevious(head);
            head.setNext(songToInsert);
            currentNode.setPrevious(songToInsert);
        }
    }


    /**
     * helper method to call comapreTo in Song class.
     * 
     * @param request
     *            string requst based on what to sort.
     * @param mySong
     *            this song that need to insert.
     * @param currSong
     *            curren song in the list.
     */
    private int compareToHelper(String request, Song mySong, Song currSong) {
        switch (request) {
            // string case is not considered in title, artist, year.
            case "title":
                return mySong.compareTo(mySong.getTitle(), currSong.getTitle(),
                    false);
            case "artist":
                return mySong.compareTo(mySong.getArtist(), currSong
                    .getArtist(), false);
            case "year":
                return mySong.compareTo(mySong.getYear(), currSong.getYear(),
                    false);
            // string case is considered in genre sort.
            case "genre":
                return mySong.compareTo(mySong.getGenre(), currSong.getGenre(),
                    true);
            default:
                throw new IllegalArgumentException(
                    "request must be one of String {title, artist, year, genre");
        }
    }
}

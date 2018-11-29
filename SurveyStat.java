package project5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import project5.AllEnum.*;

/**
 * a type for calculate yes and no numbers in the survey.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class SurveyStat {
    private final static int statListNumEntries = 3;
    /**
     * {major, region, hobby}
     */
    private List<Object> statList;
    /**
     * {CS, OTHERENG, MC, OTHER}
     */
    private List<Prefference> majorList;
    private List<Prefference> regionList;
    private List<Prefference> hobbyList;
    private static PeopleList people;


    /**
     * create SurveyStat object with people list.
     * 
     * @param peopleList
     *            The list that contains raw survey data.
     */
    public SurveyStat(PeopleList peopleList) {
        SurveyStat.people = peopleList;
        initialize();
    }


    /**
     * inialize major, region hobby lists.
     */
    private void initialize() {
        checkInputLegal();
        // iniliaze lists.
        statList = new ArrayList<Object>();
        majorList = new ArrayList<Prefference>();
        regionList = new ArrayList<Prefference>();
        hobbyList = new ArrayList<Prefference>();
        // interate 4 times and add 4 entries, representing 4 indie fields.
        for (int i = 0; i < 4; i++) {
            // create empty prefference before adding to lists.
            Prefference emptyPreff1 = new Prefference();
            Prefference emptyPreff2 = new Prefference();
            Prefference emptyPreff3 = new Prefference();
            // add empty prefferences into lists.
            majorList.add(emptyPreff1);
            regionList.add(emptyPreff2);
            hobbyList.add(emptyPreff3);
        }
        // add small lists into statList
        statList.add(majorList);
        statList.add(regionList);
        statList.add(hobbyList);
        // calculate data in the people list.
        Iterator<Person> iter = people.iterator();
        while (iter.hasNext()) {
            Person nextPerson = iter.next();
            majorCalculator(nextPerson);
            regionCalculator(nextPerson);
            hobbyCalculator(nextPerson);
        }
    }


    /**
     * will throw IllegalArgumentException if people list is null;
     */
    private void checkInputLegal() {
        if (people == null) {
            throw new IllegalArgumentException("people list cannot be null");
        }
    }


    /**
     * check the major choice of person and record responses
     * 
     * @param nextPerson
     *            the next person in list.
     */
    private void majorCalculator(Person nextPerson) {
        switch (nextPerson.getMajor()) {
            case CS:
                addPreffToMajorList(0, nextPerson);
                break;
            case OTHERENG:
                addPreffToMajorList(1, nextPerson);
                break;
            case MC:
                addPreffToMajorList(2, nextPerson);
                break;
            case OTHER:
                addPreffToMajorList(3, nextPerson);
                break;
            // break on blank answer.
            default:
                break;
        }
    }


    /**
     * check the region choice of person and record responses
     * 
     * @param nextPerson
     *            the next person in list.
     */
    private void regionCalculator(Person nextPerson) {
        switch (nextPerson.getRegion()) {
            case NEUS:
                addPreffToRegionList(0, nextPerson);
                break;
            case SEUS:
                addPreffToRegionList(1, nextPerson);
                break;
            case RESTUS:
                addPreffToRegionList(2, nextPerson);
                break;
            case OUTUS:
                addPreffToRegionList(3, nextPerson);
                break;
            // break on blank answer.
            default:
                break;
        }
    }


    /**
     * check the hobby choice of person and record responses
     * 
     * @param nextPerson
     *            the next person in list.
     */
    private void hobbyCalculator(Person nextPerson) {
        switch (nextPerson.getHobby()) {
            case READ:
                addPreffToHobbyList(0, nextPerson);
                break;
            case ART:
                addPreffToHobbyList(1, nextPerson);
                break;
            case SPORTS:
                addPreffToHobbyList(2, nextPerson);
                break;
            case MUSIC:
                addPreffToHobbyList(3, nextPerson);
                break;
            // break on blank answer.
            default:
                break;
        }
    }


    /**
     * add a prefferece count to major list.
     * 
     * @param i
     *            index of list {CS, OTHERENG, MC, OTHER}
     * @param currPerson
     *            current person that has prefferences.
     */
    private void addPreffToMajorList(int i, Person currPerson) {
        Prefference currMajor = majorList.get(i);
        currMajor.smartCountAdder(currPerson);
    }


    /**
     * add a prefferece count to region list.
     * 
     * @param i
     *            index of list {NEUS, SEUS, RESTUS, OUTUS}
     * @param currPerson
     *            current person that has prefferences.
     */
    private void addPreffToRegionList(int i, Person currPerson) {
        Prefference currRegion = regionList.get(i);
        currRegion.smartCountAdder(currPerson);
    }


    /**
     * add a prefferece count to hobby list.
     * 
     * @param i
     *            index of list {READ, ART, SPORTS, MUSIC}
     * @param currPerson
     *            current person that has prefferences.
     */
    private void addPreffToHobbyList(int i, Person currPerson) {
        Prefference currHoby = hobbyList.get(i);
        currHoby.smartCountAdder(currPerson);
    }


    /**
     * get the prefferences by major index.
     * 
     * @param majorIndex
     *            index that you want to get prefferences.
     * @return returns prefferences.
     */
    public Prefference getPreffByMajorIndex(int majorIndex) {
        switch (majorIndex) {
            case 0:
                return (majorList.get(0));
            case 1:
                return (majorList.get(1));
            case 2:
                return (majorList.get(2));
            case 3:
                return (majorList.get(3));
            // null on blank answer.
            default:
                throw new IllegalArgumentException(
                    "int not in range [0:3] is not considered");
        }
    }


    /**
     * get the prefferences by region index.
     * 
     * @param majorIndex
     *            index that you want to get prefferences.
     * @return returns prefferences.
     */
    public Prefference getPreffByRegionIndex(int regionIndex) {
        switch (regionIndex) {
            case 0:
                return (regionList.get(0));
            case 1:
                return (regionList.get(1));
            case 2:
                return (regionList.get(2));
            case 3:
                return (regionList.get(3));
            // null on blank answer.
            default:
                throw new IllegalArgumentException(
                    "int not in range [0:3] is not considered");
        }
    }


    /**
     * get the prefferences by hobby index.
     * 
     * @param majorIndex
     *            index that you want to get prefferences.
     * @return returns prefferences.
     */
    public Prefference getPreffByHobbyIndex(int hobbyIndex) {
        switch (hobbyIndex) {
            case 0:
                return (hobbyList.get(0));
            case 1:
                return (hobbyList.get(1));
            case 2:
                return (hobbyList.get(2));
            case 3:
                return (hobbyList.get(3));
            // null on blank answer.
            default:
                throw new IllegalArgumentException(
                    "int not in range [0:3] is not considered");
        }
    }


    /**
     * check if two SurveyData are equals.
     * 
     * @return returns true only if all data in fields are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        SurveyStat other = (SurveyStat)obj;
        boolean isEqual = true;
        int index = 0;
        while (index < 4 && isEqual) {
            if (!majorList.isEmpty()) {
                isEqual = majorList.get(index).equals(other
                    .getPreffByMajorIndex(index)) && isEqual;
            }
            if (!regionList.isEmpty()) {
                isEqual = regionList.get(index).equals(other
                    .getPreffByRegionIndex(index)) && isEqual;
            }
            if (!hobbyList.isEmpty()) {
                isEqual = hobbyList.get(index).equals(other
                    .getPreffByHobbyIndex(index)) && isEqual;
            }
            index++;
        }
        return isEqual;
    }


    /**
     * convert data in feilds into string.
     * 
     * @return returns fields's data as string.
     */
    public String toString() {
        StringBuilder b = new StringBuilder();
        // major
        b.append("MAJOR:\n[CS:" + majorList.get(0).toString() + ", \n");
        b.append("OTHERENG:" + majorList.get(1).toString() + ", \n");
        b.append("MC:" + majorList.get(2).toString() + ", \n");
        b.append("OTHER:" + majorList.get(3).toString() + "], \n");
        // region
        b.append("REGION:\n[NEUS:" + regionList.get(0).toString() + ", \n");
        b.append("SEUS:" + regionList.get(1).toString() + ", \n");
        b.append("RESTUS:" + regionList.get(2).toString() + ", \n");
        b.append("OUTUS:" + regionList.get(3).toString() + "], \n");
        // hobby
        b.append("HOBBY:\n[READ:" + hobbyList.get(0).toString() + ", \n");
        b.append("ART:" + hobbyList.get(1).toString() + ", \n");
        b.append("SPORTS:" + hobbyList.get(2).toString() + ", \n");
        b.append("MUSIC:" + hobbyList.get(3).toString() + "], \n");
        return b.toString();
    }

}

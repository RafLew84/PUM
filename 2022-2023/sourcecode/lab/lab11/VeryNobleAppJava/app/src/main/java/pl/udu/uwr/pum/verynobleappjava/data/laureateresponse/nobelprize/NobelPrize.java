package pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize;

import java.util.ArrayList;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.Link;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.affiliation.Affiliation;

public class NobelPrize {
    public String awardYear;
    public Category category;
    public CategoryFullName categoryFullName;
    public String sortOrder;
    public String portion;
    public String dateAwarded;
    public String prizeStatus;
    public Motivation motivation;
    public int prizeAmount;
    public int prizeAmountAdjusted;
    public ArrayList<Affiliation> affiliations;
    public ArrayList<Link> links;
}

package pl.udu.uwr.pum.verynobleappjava.data.laureateresponse;

import java.util.ArrayList;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.Birth;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.Death;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.FamilyName;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.FullName;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.GivenName;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.KnownName;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate.Link;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.meta.Meta;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.NobelPrize;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.wiki.Wikidata;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.wiki.Wikipedia;

public class LaureateResponseItem {
    public String id;
    public KnownName knownName;
    public GivenName givenName;
    public FamilyName familyName;
    public FullName fullName;
    public String fileName;
    public String gender;
    public Birth birth;
    public Death death;
    public Wikipedia wikipedia;
    public Wikidata wikidata;
    public ArrayList<String> sameAs;
    public ArrayList<Link> links;
    public ArrayList<NobelPrize> nobelPrizes;
    public Meta meta;
}

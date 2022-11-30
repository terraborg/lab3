package actions;

import characters.Person;
import places.Place;

import java.util.Objects;

final public class Talk implements Action{

    private final Person person;
    private Person lastTarget;

    private final Replics replics;

    public Talk(Person person, boolean isReplicsHasEnd, String... replics) {
        this.person = person;
        this.replics = new Replics(isReplicsHasEnd, replics);
    }

    @Override
    public boolean act() {
        Place place = person.getPlace();
        if(place.getCharacters().size() <=1)
            return false;
        if(!replics.hasReplics())
            return false;
        int i = (int) (place.getCharacters().size()*Math.random());
        Person target = place.getCharacters().get(i);
        while(target.equals(person)) {
            i++;
            target = place.getCharacters().get(i%place.getCharacters().size());
            if(i > place.getCharacters().size() * 2)
                return false;
        }
        replics.getReplic();
        lastTarget = target;
        return true;
    }
    @Override
    public String describe() {
        return  " сказал " + replics.getLastReplic() + " персонажу " + lastTarget.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Talk talk)) return false;
        return Objects.equals(person, talk.person) && Objects.equals(replics, talk.replics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person.toString() + getClass().getName());
    }
}

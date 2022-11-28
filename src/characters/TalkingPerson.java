package characters;

import actions.Talk;
import conditions.Feeling;
import places.Place;

abstract public class TalkingPerson extends Person{
    public TalkingPerson(String name, Place place, Feeling feeling) {
        super(name, place, feeling);
        addAction(createTalkAction());
    }
    abstract protected Talk createTalkAction();
}

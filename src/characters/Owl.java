package characters;

import actions.Move;
import actions.Talk;
import conditions.Feeling;
import places.Place;

public class Owl extends TalkingPerson{
    public Owl(Place place) {
        super("Сова", place, Feeling.NONE);
        addAction(new Move(this));
    }

    @Override
    protected Talk createTalkAction() {
        return new Talk(this,false,"что-то");
    }
}

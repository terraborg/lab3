package characters;

import actions.Look;
import actions.Move;
import actions.Talk;
import conditions.Feeling;
import places.Place;

import java.util.ArrayList;

public class Pooh extends TalkingPerson{
    public Pooh(Place place) {
        super("Пух", place,Feeling.NONE);
        addAction(new Look(this));
        addAction(new Move(this));
    }

    @Override
    protected Talk createTalkAction() {
        int countOfReplics = (int) (Math.random()*4+1);
        ArrayList<String> replics = new ArrayList<String>();
        for(int i = 0; i < countOfReplics; i++)
        {
            replics.add("да");
            replics.add("нет");
        }
        replics.add("да, да");
        replics.add("нет, нет, никогда");
        return new Talk(this,true,replics.toArray(new String[replics.size()]));
    }
}

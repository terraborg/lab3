package characters;

import actions.Action;
import conditions.Condition;
import conditions.Feeling;
import entity.Entity;
import places.Place;

import java.util.ArrayList;

abstract public class Person extends Entity {

    public void addAction(Action action)
    {
        actions.add(action);
    }

    private final ArrayList<Action> actions;

    public Action getLastAction() {
        return lastAction;
    }

    private Action lastAction;

    public Place getPlace() {
        return place;
    }

    private Place place;

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    protected Feeling getFeeling() {
        return feeling;
    }

    private Feeling feeling;

    public Person(String name, Place place, Feeling feeling) {
        super(name);
        this.place = place;
        place.addCharacter(this);
        this.feeling = feeling;
        actions = new ArrayList<>();
    }

    public Condition[] getCondition()
    {
        return new Condition[]{lastAction};
    }

    public boolean act()
    {
        int i = (int) (Math.random() * actions.size());
        var action = actions.get(i);
        while(!action.act())
        {
            i++;
            action = actions.get(i%actions.size());
            if(i > actions.size() * 3)
                return false;
        }
        lastAction = action;
        return true;

    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + getName() + '\'' +
                ", place=" + place.getName() +
                ", feeling=" + feeling +
                '}';
    }

    public void setPlace(Place nextPlace) {
        this.place = nextPlace;
    }
}

package characters;

import actions.Action;
import conditions.Condition;
import conditions.ConditionChecker;
import conditions.Feeling;
import places.Place;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Person{
    public String getName() {
        return name;
    }

    private final String name;

    public void addAction(Action action)
    {
        actions.add(action);
    }

    public ArrayList<Action> getActions() {
        return actions;
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
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(name+getClass().getName(), person.name + person.getClass().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + name + '\'' +
                ", place=" + place.getName() +
                ", feeling=" + feeling +
                '}';
    }

    public void setPlace(Place nextPlace) {
        this.place = nextPlace;
    }
}

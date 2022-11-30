package actions;

import conditions.Condition;

public interface Action extends Condition {
    boolean act();
}

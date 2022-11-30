package conditions;

import characters.Person;

final public class ConditionChecker {

    public void checkCondition(Person person)
    {
        Condition[] condition = person.getCondition();
        for (Condition value : condition) System.out.println("Персонаж " + person.getName() + value.describe());
        System.out.println();
    }
}

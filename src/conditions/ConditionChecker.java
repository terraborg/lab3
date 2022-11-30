package conditions;

import characters.Person;

final public class ConditionChecker {

    public void checkCondition(Person person)
    {
        Condition[] condition = person.getCondition();
        for (Condition value : condition) System.out.println("Персонаж " + person.getName() + value.describe());
        System.out.println();
    }

    @Override
    public String toString() {
        return "ConditionChecher[]";
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

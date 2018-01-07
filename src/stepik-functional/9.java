/*
You need to write your own functional interface (TernaryIntPredicate) and use it with a lambda expression. 
The interface must have a single non-static (and non-default) method test with three int arguments that returns boolean value.
Besides, you need to write a lambda expression with three int arguments using your TernaryIntPredicate.

The lambda expression has to return true if all passed values are different otherwise false. 
The name of the instance is allValuesAreDifferentPredicate. It should be a static field.
*/
@FunctionalInterface
public interface TernaryIntPredicate {
    public boolean test(int one, int two, int three);
}

public static final TernaryIntPredicate allValuesAreDifferentPredicate = new TernaryIntPredicate() {
    @Override
    public boolean test(int one, int two, int three) {
        if(one != two && one != three && two != three) return true;
        return false;
    }
};

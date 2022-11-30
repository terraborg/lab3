package actions;

import java.util.Arrays;
import java.util.Objects;

final public class Replics {
    private final String[] replics;
    private final boolean isReplicsHasEnd;

    private int curReplic;

    private String lastReplic;

    public Replics(boolean isReplicsHasEnd,String... replics) {
        this.replics = replics;
        this.isReplicsHasEnd = isReplicsHasEnd;
        curReplic = 0;
    }

    public boolean hasReplics()
    {
        return curReplic != replics.length;
    }

    public String getReplic() {
        String replic = replics[curReplic];
        curReplic++;
        if(!isReplicsHasEnd)
            curReplic%=replics.length;
        lastReplic = replic;
        return replic;
    }

    public String getLastReplic() {
        return lastReplic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Replics replics1)) return false;
        return isReplicsHasEnd == replics1.isReplicsHasEnd && Arrays.equals(replics, replics1.replics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(replics), isReplicsHasEnd);
    }
}

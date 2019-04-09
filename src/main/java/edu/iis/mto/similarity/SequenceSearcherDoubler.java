package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private int callCounter;

    public SequenceSearcherDoubler() {
        this.callCounter = 0;
    }

    @Override public SearchResult search(int key, int[] seq) {
        SearchResult.Builder builder = SearchResult.builder();
        callCounter++;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == key) {
                return builder.withFound(true).withPosition(i).build();
            }

        }
        return builder.withFound(false).build();
    }

    public int getCallCounter() {
        return callCounter;
    }

}

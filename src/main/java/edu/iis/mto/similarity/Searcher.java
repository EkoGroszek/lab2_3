package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class Searcher implements SequenceSearcher {
    private boolean found;
    private int position;

    public Searcher(boolean foundStatus, int elemPosition) {
        found = foundStatus;
        position = elemPosition;
    }

    public boolean isFound() {
        return found;
    }

    public int getPosition() {
        return position;
    }

    @Override public SearchResult search(int key, int[] seq) {
        return null;
    }
}

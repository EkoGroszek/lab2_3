import edu.iis.mto.search.SearchResult;
import edu.iis.mto.similarity.SequenceSearcherDoubler;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SimilarityFinderTest {

    @Test public void testCalculateJackardSimilarityWithBothEmptySequences() {
        int[] seq1 = new int[0];
        int[] seq2 = new int[0];
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());

        double testValue = 1.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assert.assertThat(result, is(testValue));
    }

    @Test public void testCalculateJackardSimilarityWithBothSameSequences() {
        int[] seq1 = {32, 213, 313};
        int[] seq2 = {32, 213, 313};
        SimilarityFinder similarityFinder = new SimilarityFinder((key, seq) -> {
            if (key == seq[0] || key == seq[1] || key == seq[2])
                return SearchResult.builder().withFound(true).build();
            return SearchResult.builder().withFound(false).build();
        });

        double testValue = 1.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assert.assertThat(result, is(testValue));
    }

    @Test public void testCalculateJackardSimilarityWithDifferentSequences() {
        int[] seq1 = {32, 213, 313};
        int[] seq2 = {1, 3, 35};
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());

        double testValue = 0.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assert.assertThat(result, is(testValue));
    }

    @Test public void testCalculateJackardSimilarityWithCallCounting() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3};
        SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);
        similarityFinder.calculateJackardSimilarity(seq1, seq2);

        int testValue = 3;
        int result = sequenceSearcherDoubler.getCallCounter();

        Assert.assertThat(result, is(testValue));
    }

    @Test public void testCalculateJackardSimilarityWithDifferentLengthSequences() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3, 6, 7, 8};
        SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);

        double testValue = (double) seq1.length;
        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double result = sequenceSearcherDoubler.getCallCounter();

        Assert.assertThat(result, is(testValue));
    }

    @Test public void testCalculateJackardSimilarityWithOneEmptySequence() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {};
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());

        double testValue = 0.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assert.assertThat(result, is(testValue));
    }

}

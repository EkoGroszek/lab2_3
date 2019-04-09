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
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());

        double testValue = 1.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assert.assertThat(result, is(testValue));
    }

}

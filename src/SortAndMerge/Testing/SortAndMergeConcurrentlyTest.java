package Testing;

import main.SortAndMergeConcurrently;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortAndMergeConcurrentlyTest {
    private final SortAndMergeConcurrently sortAndMerge = new SortAndMergeConcurrently();

    @ParameterizedTest
    @MethodSource("getInputArrays")
    @DisplayName("Sort and Merge using thread objects")
    void testSortAndMergeUsingThreads(final int[] arr) throws InterruptedException {
        sortAndMerge.setArray(arr);
        sortAndMerge.sortAndMergeUsingThreads();
    }

    private static Stream<Arguments> getInputArrays() {
        return Stream.of(
                Arguments.of(new int[]{2,29,3,1,5,2,7,6,8,0,3}),
                Arguments.of(new int[]{3,4,6,2,6,32,7}),
                Arguments.of(new int[]{7,34,8,3,6356,2})
        );
    }
}

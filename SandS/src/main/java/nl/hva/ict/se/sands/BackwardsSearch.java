package nl.hva.ict.se.sands;

public class BackwardsSearch {
    private int amountOfComparisons = 0;
    /**
     * Returns index of the right most location where <code>needle</code> occurs within <code>haystack</code>. Searching
     * starts at the right end side of the text (<code>haystack</code>) and proceeds to the first character (left side).
     * @param needle the text to search for.
     * @param haystack the text which might contain the <code>needle</code>.
     * @return -1 if the <code>needle</code> is not found and otherwise the left most index of the first
     * character of the <code>needle</code>.
     */
    int findLocation(String needle, String haystack) {

        int N = haystack.length();
        int M = needle.length();
        int r = 256;
        int[] right = new int[r];

        for (int c = 0; c < r ; c++) {
            right[c] = -1;
        }

        for (int k = 0; k < M; k++) {
            right[needle.charAt(k)] = k;
        }

        int skip;
        amountOfComparisons = 0;
        for (int i = N-M; i > 0 ; i -= skip)
        {
            skip = 0;
            for (int j = 0; j < M; j++)  {
                amountOfComparisons++;
                if (needle.charAt(j) != haystack.charAt(i+j))
                {
                    skip = j - right[haystack.charAt(i+j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }

            if (skip == 0) {
                System.out.println("Number of comparisons: " + amountOfComparisons);
                return i;
            }
        }

        System.out.println("Number of comparisons: " + amountOfComparisons);
        return -1;

    }

    /**
     * Returns the number of character compared during the last search.
     * @return the number of character comparisons during the last search.
     */
    int getComparisonsForLastSearch() {
        return amountOfComparisons;
    }

}

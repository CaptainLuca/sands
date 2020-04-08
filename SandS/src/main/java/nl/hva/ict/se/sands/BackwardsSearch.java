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
    int findLocation(String pat, String txt) {

        int n = txt.length();
        int m = pat.length();
        int r = 256;
        int[] left = new int[r];

        for (int c = 0; c < r; c++) {
            left[c] = pat.length();
        }

        for (int j = pat.length() - 1; j >= 0; j--) {
            left[pat.charAt(j)] = j;
        }

        int skip;
        amountOfComparisons = 0;
        for (int i = n-m; i >= 0; i -= skip)
        {
            skip = 0;
            for (int j = 0; j <= m-1; j++)  {
                amountOfComparisons++;
                if (pat.charAt(j) != txt.charAt(i+j))
                {
                    skip = Math.min(m, left[txt.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
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

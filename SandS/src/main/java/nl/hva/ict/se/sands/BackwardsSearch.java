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

        int text = haystack.length();
        int pattern = needle.length();
        int r = 256;
        int[] left = new int[r];

        for (int c = 0; c < r ; c++) {
            left[c] = needle.length();
        }

        for (int k = needle.length() - 1; k >= 0; k--) {
            left[needle.charAt(k)] = k;
        }

        int skip;
        amountOfComparisons = 0;


        for (int i = text-pattern; i >= 0 ; i -= skip)
        {
            skip = 0;
            for (int j = 0; j <= pattern -1; j++)  {
                amountOfComparisons++;
                if (needle.charAt(j) != haystack.charAt(i+j))
                {
//                    skip = j - left[haystack.charAt(i+j)];
                    skip = Math.min(pattern, left[haystack.charAt(i+j)]);
//                    System.out.println("Skip: " + skip)
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

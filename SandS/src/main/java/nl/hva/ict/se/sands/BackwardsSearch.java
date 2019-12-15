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

        int index = haystack.length() - needle.length();
        boolean found = false;

        System.out.println(haystack.charAt(index));
        while(!found){

            if(index < 0){
                break;
            }
            char letter = haystack.charAt(index);

            if(!needle.contains(Character.toString(letter))){
                amountOfComparisons++;
                index = index - needle.length();
            } else if (needle.contains(Character.toString(letter))){
                if(needle.charAt(0) != letter) {
                    amountOfComparisons++;
                    index--;
                } else {
                    for(int i = 0; i < needle.length(); i++){
                        amountOfComparisons++;
                        if(!(needle.charAt(i) == haystack.charAt(index + i))){
                            index -= needle.length() - i;
                            break;
                        }
                        if(i == needle.length() - 1){
                            found = true;
                            return index;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void setAmountOfComparisons(int amountOfComparisons) {
        this.amountOfComparisons = amountOfComparisons;
    }

    /**
     * Returns the number of character compared during the last search.
     * @return the number of character comparisons during the last search.
     */
    int getComparisonsForLastSearch() {
        return amountOfComparisons;
    }

}

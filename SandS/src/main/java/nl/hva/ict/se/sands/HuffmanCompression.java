package nl.hva.ict.se.sands;

import java.io.InputStream;
import java.util.*;

public class HuffmanCompression {
    private final String text;
    public Character[] CHARACTERS = {'a', 'b', 'c','d', 'e', 'f','g', 'h', 'i','j', 'k', 'l','m', 'n', 'o','p', 'q', 'r','s', 't', 'u','v', 'w', 'x','y', 'z'};
    public HuffmanCompression(String text) {
        this.text = text;
    }

    public HuffmanCompression(InputStream input) {
        Scanner sc = new Scanner(input);
        sc.useDelimiter("\\Z"); // EOF marker
        text = sc.next();
    }

    /**
     * Returns the compression ratio assuming that every characters in the text uses 8 bits.
     * @return the compression ratio.
     */
    public double getCompressionRatio() {
        return 0.0;
    }

    /**
     * Compresses the text that was provided to the constructor.
     * @return
     */
    public String compress() {
        return "";
    }

    /**
     * Returns the root of the compression tree.
     * @return the root of the compression tree.
     */
    Node getCompressionTree() {
        return null;
    }

    /**
     * Returns a Map<Character, String> with the character and the code that is used to encode it.
     * For "aba" this would result in: ['b' -> "0", 'a' -> "1"]
     * And for "cacbcac" this would result in: ['b' -> "00", 'a' -> "01", 'c' -> "1"]
     * @return the Huffman codes
     */
    Map<Character, String> getCodes() {
        //Maak een map waar de frequentie van alle characters in de string wordt opgeslagen

        //Deze map moet uitendelijk op een of andere manier omgezet
        Map<Character, Integer> preCodeMap = new TreeMap<>(); //Treemap is misschien voordelig omdat keys op alfabetische volgorde worden opgeslagen
        //worden in Map<Character, String>
        for(int i = 0; i< text.length(); i++){
            char ch = text.charAt(i);
            if(!preCodeMap.containsKey(ch)){
                preCodeMap.put(ch, 1);
            }else{
                int value = preCodeMap.get(ch);
                preCodeMap.put(ch, ++value);
            }
        }
        //Bewerk de map zodat alle characters in de string/bovenstaande map een binaire code krijgen toegewezen (meest
        //voorkomende) Hier roep je dus de createCodeRec methode aan. (Dit is een recursieve methode)
        createCodeRec(new Node(1, 'X'), new HashMap<>(), "XXX");



        //Return een Map<Character, String> -> a, 1(vaakst voorkomende getal)   b,0  (3 symbolen)
        //Return een Map<Character, String>trice -> b, 00  a,01   c,1(vaakst vorkomende getal)  (3 symbolen)
        return null;
    }
    //Recursieve methode die bits maakt van frequenties in een Map
    private static void createCodeRec(Node node, Map<Character, String> map, String s) {
        if (node.getLeft() == null && node.getRight() == null) {
            map.put(node.getCharacter(), s);
            return;
        }
        createCodeRec(node.getLeft(), map, s + '0');
        createCodeRec(node.getRight(), map, s + '1' );
    }

}

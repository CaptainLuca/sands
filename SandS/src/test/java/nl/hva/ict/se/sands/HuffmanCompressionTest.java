package nl.hva.ict.se.sands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HuffmanCompressionTest {
    HuffmanCompression compressor;

    @BeforeEach
    public void setup() {
        compressor = new HuffmanCompression(getClass().getResourceAsStream("/edu/princeton/cs/algs4/Huffman.java"));
    }

    @Test
    public void checkWeightSimple() {
        compressor = new HuffmanCompression("aba");

        Node compressionTree = compressor.getCompressionTree();

        assertEquals(3, compressionTree.getWeight());

        Node left = compressionTree.getLeft();
        Node right = compressionTree.getRight();
        assertEquals(1, right.getWeight());
        assertEquals(2, left.getWeight());
    }
    @Test
    public void checkWeightSample2() {
        compressor = new HuffmanCompression("aaabbbbcdefghijkfadlmnopqrstuvwxyz");

        Node compressionTree = compressor.getCompressionTree();

        assertEquals(29, compressionTree.getWeight());

        Node left = compressionTree.getLeft();
        Node right = compressionTree.getRight();
    }
    @Test
    public void checkWeightSample3() {
        compressor = new HuffmanCompression("aaaaaaaabbbbbb");

        Node compressionTree = compressor.getCompressionTree();

        assertEquals(14, compressionTree.getWeight());

        Node left = compressionTree.getLeft();
        Node right = compressionTree.getRight();
    }

    @Test
    public void checkUniqueCharacter() {
        // Handle Linux/Mac and Windows end-of-line characters, 86 and 87 are both ok.
        int numberOfChars = compressor.getCodes().size();
        assertTrue(numberOfChars == 86 || numberOfChars == 87, "You appear to have some very strange end-of-line configuration on your machine!");
    }

    @Test
    public void checkSimpleCompressionRatio() {
        compressor = new HuffmanCompression("abracadabra");
        //eerst 24 bits
        //met huffmancompressie: blijkbaar 3 aba: 101
        //a:1 b:0
        assertEquals(0.125,compressor.getCompressionRatio(), 0.0001);
    }

}
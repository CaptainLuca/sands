package nl.hva.ict.se.sands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {
    HuffmanCompression compressor;

    @BeforeEach
    public void setup() {
        compressor = new HuffmanCompression("abbcccddddeeee");
    }

    @Test
    public void test1(){
        compressor.compress();
    }

}


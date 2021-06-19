package io.algoexpert.easy.caesarcipherencryptor;

public class Main {
    private class ASCII{
        public static final int Z = 122;
        public static final int A = 97;
    }

    private static char shiftChar(char c, int times){
        int ascii = (int) c;
        int nextAscii = ascii + times % 26;

        if(nextAscii > ASCII.Z)
            nextAscii = ASCII.A + (nextAscii - ASCII.Z) - 1;

        return (char) nextAscii;
    }

    public static String caesarCypherEncryptor(String str, int key) {

        char [] split = str.toCharArray();
        for(int i=0; i < split.length; i++)
            split[i] = shiftChar(split[i], key);

        return new String(split);
    }
}

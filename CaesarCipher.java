/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] shifted;
	private int shift;

    public CaesarCipher() {

    }

    public CaesarCipher(int num){
        shift=num;
        shifted = new char[26];

        for(int i = 0; i<alphabet.length; i++)
        {
            shifted[(i+shift)%alphabet.length]=alphabet[i];
        }

    }

    public String encrypt(String message){

        String newMessage = "";
        boolean found = false;

        for(int i = 0;i<message.length(); i++)
        {
            for(int let = 0; let< alphabet.length; let++)
            {
                if(message.charAt(i) == alphabet[let])
                {
                    newMessage+=shifted[let];
                    found = true;
                }
            }
            if(!found)
                newMessage+=message.charAt(i);

            found = false;
        }

        return newMessage;
    }

    public String decrypt(String message){
        String newMessage = "";
        boolean found = false;

        for(int i = 0;i<message.length(); i++)
        {
            for(int let = 0; let< shifted.length; let++)
            {
                if(message.charAt(i) == shifted[let])
                {
                    newMessage+=alphabet[let];
                    found = true;
                }
            }
            if(!found)
                newMessage+=message.charAt(i);

            found = false;
        }

        return newMessage;

    }

    public void shifter(int num){
        shift=num;

        for(int i = 0; i<alphabet.length; i++)
        {
            shifted[(i+shift)%alphabet.length]=alphabet[i];
        }
    }


}
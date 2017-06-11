package blockcipher;

import java.util.Scanner;

public class BlockCipher {

	public static void main(String[] args) {
		

	    String str = "Information Secutiry";
	    String result = "", result_print = "";
	    String decode_result = "", decode_result_print = "";
	    String result_reverse = "", result_reverse_print = "";
	    String decode_result_flip = "", decode_result_flip_print = "";
	    String result_scrambler = "", result_scrambler_print = "", temp_scrambler = "";;
	    String decode_After_Swap = "", decode_After_Swap_print = "";
	    String cipher_text = "", decipher_text = "";
	    int j = 1;
	    
	    Scanner in = new Scanner(System.in);		      
	    System.out.println("Enter the Sender Message: ");
	    str = in.nextLine();
	    
	    char[] messChar = str.toCharArray();
	    
	    


	    for (int i = 0; i < messChar.length; i++) {
	        String temp= "00000000" + Integer.toBinaryString(messChar[i]);
	        result += temp.substring(temp.length()- 8, temp.length());
	        result_print += temp.substring(temp.length()- 8, temp.length()) + " ";
	    }

	       
	    System.out.println("\nStep 1: Encryption");
	    System.out.println("Step 2: The Binary Format of input "  + str + result_print);
	    
	    
	    messChar = result.toCharArray();
	    int length = (result.length()+1)/8;
	    int x = 0;
	    for(int i = 0; i<length ; i++)
	    {
	    	 for(int k = x+7 ; k>=0+x;k--)
	    	 {
	    		 if(k == x)
	    		 {
	    			 if(messChar[k] == '0')
	 		    	{
	 		    		messChar[k] = '1';
	 		    	}
	 		    	else
	 		    		messChar[k] = '0';
	    		 }
	    		 	
	    		 result_reverse +=messChar[k];
	    		 result_reverse_print +=messChar[k];
	    		 
	    	 }
	    	 result_reverse_print += " "; 
	    	 x = x+8;
	    }
	 
	    System.out.println("Step 3: Replace '1' With '0' and '0' with '1'   :" + result_reverse_print);
    
	    
	    String scrambler = "",scrambler_print = "",temp = "",final_scram = "",temp1 = "",final_scram_print = ""; 
	    length = result_reverse.length()/64;
	    j = 0;
	    int k =0;
	    for(int i =1 ;i<=length;i++)
	    {
		    scrambler = result_reverse.substring(j,j+64);
		    scrambler_print = result_reverse_print.substring(k,k+72);
		    	    for(int m = 0;m<10;m++)
		    	    {
		    	    	int l = 0,p=0;
		    	    	
		    	    		temp = scrambler.substring(56,64) + scrambler.substring(0,56);
		    	    		temp1 = scrambler_print.substring(63,72) + scrambler_print.substring(0,63);
		    	    		l = l+8;
		    	    		p = p+9;
		    	    	//}
		    	    scrambler = temp;
		    	   
		    	    scrambler_print = temp1;
		    	   
		    	    }
		    	    final_scram += scrambler;
		    	    final_scram_print += scrambler_print;
		    	    j = j+64;
		    	    k = k+72;
	    }
	    
	    if(result_reverse.length()%64 > 0)
	    {
	    	length = result_reverse.length();
	    	int length1 = result_reverse_print.length();
	    	
	    	scrambler = result_reverse.substring((result_reverse.length()/64*64),length);
	    	scrambler_print = result_reverse_print.substring((result_reverse_print.length()/72)*72,length1);
	    	int ln = scrambler.length()/8;
	    	for(int m = 0;m<10;m++)
    	    {

    	    	for(int n=0;n<ln;n++)
    	    	{
    	    		temp = scrambler.substring(scrambler.length()-8,scrambler.length()) + scrambler.substring(0,scrambler.length()-8);
    	    		temp1 = scrambler_print.substring(scrambler_print.length()-9,scrambler_print.length()) + scrambler_print.substring(0,scrambler_print.length()-9);
    	    	}
    	    scrambler = temp;
    	    scrambler_print = temp1;
    	    }
    	    final_scram += scrambler;
    	    final_scram_print += scrambler_print;
	    }
	    
	    System.out.println("Step 5: Encyrption Scrambler: " +final_scram_print);
	  
	    
	    for (int i = 0; i < final_scram.length()/8; i++) {

	        int a = Integer.parseInt(final_scram.substring(8*i,(i+1)*8),2);
	        cipher_text += (char)(a);
	    }
	    
	    System.out.println("Step 6: ciphertext: "+cipher_text);
	    
	   
	    System.out.println("\n\nStep 7: Decryption");
	    messChar = cipher_text.toCharArray();
		 
	    for (int i = 0; i < messChar.length; i++) {
	        temp= "00000000" + Integer.toBinaryString(messChar[i]);
	        decode_result += temp.substring(temp.length()- 8, temp.length());
	        decode_result_print += temp.substring(temp.length()- 8, temp.length()) + " ";
	    }
	    
	    System.out.println("Step 8: The Binary format for cipher : " + decode_result_print);
	    
	 
	    scrambler = "";scrambler_print = "";temp = "";final_scram = "";temp1 = "";final_scram_print = ""; 
	    length = decode_result.length()/64;
	    j = 0;
	    k =0;
	    for(int i =1 ;i<=length;i++)
	    {
		    scrambler = decode_result.substring(j,j+64);
		    scrambler_print = decode_result_print.substring(k,k+72);
		    	    for(int m = 0;m<10;m++)
		    	    {
		    	    	int l = 0,p=0;
		    	    		temp = scrambler.substring(8,64) + scrambler.substring(0,8);
		    	    		temp1 = scrambler_print.substring(9,72) + scrambler_print.substring(0,9);
		    	    scrambler = temp;
		    	   
		    	    scrambler_print = temp1;
		    	   
		    	    }
		    	    final_scram += scrambler;
		    	    final_scram_print += scrambler_print;
		    	    j = j+64;
		    	    k = k+72;
	    }
	    
	    if(decode_result.length()%64 > 0)
	    {
	    	length = decode_result.length();
	    	int length1 = decode_result_print.length();
	    	
	    	scrambler = decode_result.substring((decode_result.length()/64*64),length);
	    	scrambler_print = decode_result_print.substring((decode_result_print.length()/72)*72,length1);
	    	int ln = scrambler.length()/8;
	    	for(int m = 0;m<10;m++)
    	    {

    	    	for(int n=0;n<ln;n++)
    	    	{
    	    		temp = scrambler.substring(8,scrambler.length()) + scrambler.substring(0,8);
    	    	 temp1 = scrambler_print.substring(scrambler_print.length()-9,scrambler_print.length()) + scrambler_print.substring(0,scrambler_print.length()-9);
    	    	 temp1 = scrambler_print.substring(9,scrambler_print.length()) + scrambler_print.substring(0,9);
    	    	}
    	    scrambler = temp;
    	    scrambler_print = temp1;
    	    }
    	    final_scram += scrambler;
    	    final_scram_print += scrambler_print;
	    }
	    
	   
	    System.out.println("Step 9: Decryption scrambler: " +final_scram_print);
	 
	    String decode_result_reverse = "", decode_result_reverse_print = "";
	    messChar = final_scram.toCharArray();
	    length = (final_scram.length()+1)/8;
	    x = 0;
	    for(int i = 0; i<length ; i++)
	    {
	    	 for(k = x+7 ; k>=0+x;k--)
	    	 {
	    		 if((k+1)%8 == 0)
	    		 {
	    			 if(messChar[k] == '0')
	 		    	{
	 		    		messChar[k] = '1';
	 		    	}
	 		    	else
	 		    		messChar[k] = '0';
	    		 }
	    		 	
	    		 decode_result_reverse +=messChar[k];
	    		 decode_result_reverse_print +=messChar[k];
	    		 
	    	 }
	    	 decode_result_reverse_print += " "; 
	    	 x = x+8;
	    }
	    
	    System.out.println("Step 10: Replace '1' With '0' and '0' with '1': " + decode_result_reverse_print);
	    
	    
	    
	    for (int i = 0; i < decode_result_reverse.length()/8; i++) {

	        int a = Integer.parseInt(decode_result_reverse.substring(8*i,(i+1)*8),2);
	        decipher_text += (char)(a);
	    }
	    
	    System.out.println("Step 11: Deciphertext: "+decipher_text);
	    

}

}

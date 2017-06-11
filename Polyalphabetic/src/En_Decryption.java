
package InfoSec;

public class En_Decryption {
		
			char Normal[] = new char[26];
			char c1[] = new char[26];
			char c2[] = new char[26];
			char c = 'a';
			//char letter;
			//int wait, 
			int keycount = 1, count = 0;
			String plaintext = "bob, i love you";
			String ciphertext = "";


			for (int x = 0; x<26; x++) {
				Normal[x] = c;
				c++;
			}

			c = 'f';
			for (int x = 0; x<26; x++) {
				c1[x] = c;
				if (c == 'z')
				{
					c = 'a';
				}
				else
					c++;
			}

			c = 't';
			for (int x = 0; x<26; x++) {
				c2[x] = c;
				if (c == 'z')
				{
					c = 'a';
				}
				else
					c++;
			}


			System.out.print("PT: ");
			for (int i = 0; i<26; i++)
			{
				System.out.print(Normal[i]+"  ");
			}
			System.out.println();
			
			System.out.print("C1: ");
				for (int i = 0; i<26; i++)
				{
					System.out.print(c1[i]+"  ");
				}
			System.out.println();;

			System.out.print("C2: ");
				for (int i = 0; i<26; i++)
				{
					System.out.print(c2[i]+"  ");
				}
				System.out.println();

				System.out.println();
			System.out.println("Plain Text :  " +plaintext);


			System.out.println("**********************************Encryption**********************************");
			for (int i = 0; i<plaintext.length(); i++)
			{
				if (keycount>2)
					keycount = 1;

				char letter = plaintext.charAt(count);
				if (letter<'a' || letter >'z')
				{
					ciphertext = ciphertext + plaintext.charAt(count);
					count++;
				}
				else 
				{
					if (keycount == 1)
					{

						for (int j = 0; j < 26; j++)
						{
							if (plaintext.charAt(count) == Normal[j])
							{
								ciphertext = ciphertext + c1[j];
								count++;
								break;
							}
						}
					}

					if (keycount == 2)
					{

						for (int j = 0; j < 26; j++)
						{
							if (plaintext.charAt(count) == Normal[j])
							{
								ciphertext = ciphertext + c2[j];
								count++;
								break;
							}
						}
					}

					keycount++;
				}
			}

			System.out.println("\nAfter Encryption,\nCipher text:  "+ciphertext+"\n");


			System.out.println("**********************************Decryption**********************************");

			System.out.print("Cipher text:  "+ ciphertext);
			keycount = 1;
			count = 0;
			String Final_text = "";

			for (int i = 0; i<ciphertext.length(); i++)
			{
				if (keycount>2)
					keycount = 1;

				char letter = ciphertext.charAt(count);
				if (letter<'a' || letter >'z')
				{
					Final_text = Final_text + ciphertext.charAt(count);
					count++;
				}
				else
				{
					if (keycount == 1)
					{

						for (int j = 0; j < 26; j++)
						{
							if (ciphertext.charAt(count) == c1[j])
							{
								Final_text = Final_text + Normal[j];
								count++;
								break;
							}
						}
					}

					if (keycount == 2)
					{

						for (int j = 0; j < 26; j++)
						{
							if (ciphertext.charAt(count) == c2[j])
							{
								Final_text = Final_text + Normal[j];
								count++;
								break;
							}
						}
					}

					keycount++;
				}
			}
			System.out.print("\n\nAfter Decryption,\nFinal text:  "+Final_text);

			//cin >> wait;

		}

	}

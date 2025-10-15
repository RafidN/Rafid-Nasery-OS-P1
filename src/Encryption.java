import java.io.PrintStream;
import java.util.Scanner;

public class Encryption {

    private static String passKey = null;

    public static void main(String[] args)
    {
        try (Scanner in = new Scanner(System.in); PrintStream out = new PrintStream(System.out, true))
        {
            while(in.hasNextLine())
            {
                String line = in.nextLine().trim();
                if (line.isEmpty())
                    continue;

                String command;
                String argument;

                int findFirstSpace = line.indexOf(' ');
                if(findFirstSpace == -1)
                {
                    command = line.toUpperCase();
                    argument = "";
                }
                else
                {
                    command = line.substring(0, findFirstSpace).toUpperCase();
                    argument = line.substring(findFirstSpace + 1).trim();
                }

                switch (command)
                {
                    case "PASS":
                    case "PASSKEY":
                        passKey = argument;
                        out.println("RESULT");
                        break;

                    case "ENCRYPT":
                        if (passKey == null)
                        {
                            out.println("ERROR Password not set");
                        }
                        else
                        {
                            try {
                                out.println("RESULT " + cipherText(argument, passKey));
                            }
                            catch (Exception e){
                                out.println("ERROR " + e.getMessage());
                            }
                        }
                        break;

                    case "DECRYPT":
                        if (passKey == null)
                        {
                            out.println("ERROR Password not set");
                        }
                        else
                        {
                            try
                            {
                                out.println("RESULT " + decipherText(argument, passKey));
                            }
                            catch (Exception e)
                            {
                                out.println("ERROR " + e.getMessage());
                            }
                        }
                        break;


                    case "QUIT":
                        return;

                    default:
                        out.println("ERROR Unkown command");
                }
            }

        }
    }

    static String cipherText(String str, String key)
    {
        StringBuilder cipher_text= new StringBuilder();

        for (int i = 0; i < str.length(); i++)
        {
            char plain = Character.toUpperCase(str.charAt(i));
            char k = Character.toUpperCase(key.charAt(i % key.length()));
            int x = (plain - 'A' + (k - 'A')) % 26;

            x += 'A';

            cipher_text.append((char) (x));
        }
        return cipher_text.toString();
    }
    static String decipherText(String cipher_text, String key)
    {
        StringBuilder orig_text = new StringBuilder();

        for (int i = 0 ; i < cipher_text.length(); i++)
        {
            char cipher = Character.toUpperCase(cipher_text.charAt(i));
            char k = Character.toUpperCase(key.charAt(i % key.length()));
            int x = (cipher - 'A' - (k - 'A') + 26) % 26;

            orig_text.append((char)(x + 'A'));
        }
        return orig_text.toString();
    }

}

import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.err.println("Must include an output file for logs");
            return;
        }

        String logFile = args[0];

        try
        {
            Process logger = Runtime.getRuntime().exec("java Logger " + logFile);
            Process encryption = Runtime.getRuntime().exec("java Encryption");

            PrintStream log = new PrintStream(logger.getOutputStream(), true);
            PrintStream enc = new PrintStream(encryption.getOutputStream(), true);

            Scanner encInput = new Scanner(encryption.getInputStream());
            Scanner userInput = new Scanner(System.in);

            log.println("START Driver Started");
            while(true)
            {
                System.out.println("Command (password/encrypt/decrypt/quit): ");
                String command = userInput.nextLine().trim().toLowerCase();

                if(command.equals("quit"))
                {
                    enc.println("QUIT");
                    enc.flush();
                    log.println("QUIT");
                    log.flush();
                    break;
                }
                else if (command.equals("password"))
                {
                    System.out.println("Enter password (alphabetic characters only): ");
                    String password = userInput.nextLine().trim().toUpperCase();
                    enc.println("PASSKEY " + password);
                    enc.flush();
                    log.println("PASSKEY set");
                    log.flush();

                    if(encInput.hasNextLine())
                    {
                        System.out.println(encInput.nextLine());
                    }
                }
                else if (command.equals("encrypt") || command.equals("decrypt"))
                {
                    System.out.println("Enter text to " + command + ": ");
                    String text = userInput.nextLine().trim().toUpperCase();
                    enc.println(command.toUpperCase() + " " + text);
                    enc.flush();
                    if(encInput.hasNextLine())
                    {
                        System.out.println(encInput.nextLine());
                    }
                }
                else
                {
                    System.out.println("Unable to handle that command, please try again.");
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Driver error: " + e.getMessage());
        }

    }
}

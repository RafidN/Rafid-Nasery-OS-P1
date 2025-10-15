import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Logger {
    public static void main(String[] args)
    {
        String logFile = args[0];
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (Scanner in = new Scanner(System.in); BufferedWriter out = new BufferedWriter(new FileWriter(logFile, true)))
        {
            while(in.hasNextLine())
            {
                String line = in.nextLine();
                if ("QUIT".equals(line))
                {
                    break;
                }

                String action;
                String message;
                int findFirstSpace = line.indexOf(' ');
                if(findFirstSpace == -1)
                {
                    action = line.trim();
                    message = "";
                }
                else
                {
                    action = line.substring(0, findFirstSpace).trim();
                    message = line.substring(findFirstSpace + 1).trim();
                }

                String currentDateTime = LocalDateTime.now().format(fmt);
                out.write(currentDateTime + " [" + action + "] " + message);
                out.newLine();
                out.flush();
            }
        }
        catch (Exception e)
        {
            System.err.println("Logger error: " + e.getMessage());
        }
    }
}

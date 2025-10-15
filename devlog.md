### Oct 6 2025, 11:56 AM

#### First Look at the Project

In all honesty I felt pretty confident about the project requirements and exactly what
I needed to do after the project discussion class, but have forgotten most of it. I know that 
I thought that the Logger and Encryption programs seemed trivial, and I will begin facing trouble 
when it comes to creating the Driver with all the Console ASCII UI, Java Processes, and input 
validation.

For now, I just wanted to get this project started so that I can visit this when I have more time
with the git repository and devlog already set up.


### Oct 15 2025, 2:21PM

#### Read the Logger Requirements, Time to Implement

Looking at the logger file, it seems like a basic standalone program that takes a file as an input
argument for logs to be written to, and looks for "QUIT" to be called to quit logging. A lot of what 
is going on within the logger is just formatting the data to match what is on the slides.

#### This Session's Goals:

Complete the logger, test it, and maybe begin looking at the requirements for the encryption if
I have time.

#### Notes During Development:

- I needed to look into how to an easy way to get the DateTime to match the required format, found
that I can use a the DateTimeFormatter and LocalDateTime together from java's libraries
- I'm not sure how much error handling is expected from me in the Logger, so I am just putting 
everything in a try catch and making obvious checks
- I've completed the Logger program and decided to test it, I've kept the output of the file in 
this repository named "logTest.txt". I ran the following:
```bash 
javac ./src/Logger.java
java ./src/Logger.java logTest.txt
START Logging started
ACTION Something is taking place
QUIT
``` 
- Output inside of logTest.txt looks accurate to the project requirements.
- Now reading the encryption program requirements, it seems like the action and message are broken
apart in the same way as in my Logger program (by the first whitespace), and it just needs to 
respond to various different actions. The hardest part of this will be implementing the Vigenere 
cipher which the professor mentioned isn't too bad either.
- Looking through the wiki for the vignere cipher seemed interesting but unhelpful. I ended up
going to GeeksForGeeks for a better explanation and code snippet.
- Since the implementation found involved generating a key of equal length to the text, I need to alter
the way the key is used so that any length key can work
- Got the vignere cipher working and tested by running the following:
```bash 
javac ./src/Encryption.java
java ./src/Encryption.java logTest.txt
ENCRYPT HELLO
PASSKEY KEY
ENCRYPT HELLO
DECRYPT RIJVS
QUIT
``` 
- The outputs I got were:
```bash
ERROR Password not set 
RESULT
RESULT RIJVS
RESULT HELLO
```

### Oct 15 2025, 4:32PM

#### SESSION REFLECTION

Did I encounter any problems you have not already wrote about?
- I think I documented most of the problems I faced in the above section, but I did notice that 
when creating a PASSKEY in the Encryption program, you get an output with an empty RESULT, not
sure if this is viable but I remember noticing the same thing with the professors implementation 
in class. Actually now looking at the project-1 document I see that this is expected behavior, but
maybe it shouldn't be.

Did I accomplish my goal for this session?
- Absolutely, I completed both the Logger and Encryption java files, although I knew ahead of time
that this would be the easy part as its very basic java programs with system input. The logger file
only took me about 30-40 mins, but I did get stuck on the vigenere cipher portion of the Encryption
program due to some bugs when referencing the GeeksForGeeks implementation of it, and hope that my
fix still counts as a vignere cipher.

What am I thinking about doing next time?
- Next session I hope to complete the Driver program. Now that I've completed the Logger and
Encryption programs, I see where the Driver program is heading with using the input/outputs of
the Encryption program as input into the Logger. It has been a while since I worked with Java
Processes (1.5 years) but I did use the C/C++ equivalents extensively in Programming in Unix 
(CS337). 

## Technical problem

There're some customer records in a text file (input.txt) -- one customer per line, JSON lines formatted. 
We invite any customer within 100km of our Dublin office for some food and drinks on us. 
This program reads the full list of customers and output the names and user ids of matching customers (within 100km), 
sorted by User ID (ascending) to output.txt.


## How to run the program

You need to have Java 11 and Maven installed.
Compile and run /src/main/java/com/intercom/main/Application class

If no command line arguments found - input will be taken from **input.txt** file, output - to **output.txt**

You could pass file name (ex. "mycustomers.txt") as the first command line argument(file should be placed in /CustomerDinner) - 
then it will be the input for the program.

Emily Evans
CISC320 Project 2 Hurried Herding

Inside your readme.txt file, make sure you clearly explain the algorithmic 
runtime of your program in terms of Big O. For full credit, you must be able 
to justify your program's complexity as average case O(c*log(c)+r).

For my project, I used a hashmap to store the Cow's ID as the key. To access each cow's values, I used methods
created in my Cow class that I could call based on the action given. Initially, I had to parse through each line
to create the Cow in the hashmap. Once I created the Cow, I had to assign it to a Cow variable so that I could
change the value if needed based on the action of M or W. My program works on the average time case because it
directly pulls from the hashmap the key that I need and updates it's value, instead of trying to use a for loop 
which is what my initial idea was. 
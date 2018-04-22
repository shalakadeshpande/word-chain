Word Chain Solver : 
Two words are connected by a word chain if it is possible to change one into the other by making a series of single-character changes, such that every intermediateform is also a word. 
For example, CAT and DOG are connected with a word chain because CAT, COT, COG and DOG are all words. DEMONIC and UMBRELLA are not.

Write a program that takes a list of words (for example /usr/share/dict/words on a unix system or download the file from : https://github.com/dwyl/english-words/blob/master/words.txt if you are using windows) and then reads pairs of words on stdin and prints 'YES' if the words are connected by a chain, and 'NO' if they are not. If YES, the words in the word chain should be listed out on the console. The program should take the path to the word list from a file, and should then loop, reading pairs of whitespace-delimited words from the file and printing 'YES' or 'NO.'


## Steps to execute
Execute mainApp.java in src/main/java to start the program
## Resources needed
Uses words.txt file in resources folder as Dictionary source

# Algorithms and Constructs

## Project structure
- Controllers 
  - Serve as data manipulation adding and removing from the lists 
- Entities 
  - Objects that represent the data required like readers and books, etc.
- Factories
  - Responsible for the creation of the entities
- GUI
  - Screen printing for options
- Utils
  - Classes accountable for loading and saving files, date format, and number validation

## Code justification
- Starting from the loading of a file, the Factory creates the objects regarding the type and information. This way, it is easy because it already has all the items in the files before loaded during the program's loading. 
- The controls make an interface between the lists and the interface, which facilitates the entities' interaction and manipulation.

## File structure
- The file format is CSV because it is a standard format and works for different programming languages; thus, regardless of which language the program will be, the files will remain useful.

## Data Structures and Algorithms

- **Module Title**: Data Structures and Algorithms.
- **Assignment Type**: Practical Individual Assignment.
- **Project Title**: Library System.
- **Project Date**: September 2020.
- **Assignment Compiler**: Amilcar Aponte.

### Module Learning Outcomes Assessed
- Develop and implement custom data structures and algorithms for a wide variety of application specific tasks, taking performance and system resources into consideration.
- Utilise a variety of different data structures available such as lists, queues, stacks and trees and be able to develop searching and traversal algorithms to traverse through such data structures, including those designed by other team members.
- Gather, recognise and assess relevant task-specific information to identify and address the limitations and pitfalls of developing and deploying data structures and algorithms across a wide range of scenarios in the best way for all stakeholders.
# Assignment Introduction
- A library has come to you as a developer and outlined that currently they do not have any software to track the different titles they have in stock, users of the library and borrowings. They have asked you to develop a system which will allow them to do this. The library doesn’t have a budget for a database, so your solution must implement a text file based system to ensure persistency of the data.
# Specific Requirements
- The library system must include the following entities:
  - Book: To model all data relevant to the books. ID, title, author and/or any other piece of information that you consider relevant.
  - Reader: To model all data relevant to the users of the library. ID, name, address and/or any other piece of information that you consider relevant.
- When the program is executed, it must automatically load onto memory the data that exists on the text files(s) in the form of objects. Books, readers and any other entity that you include in your design (e.g. borrowings).

# Algorithms and Constructs
- Consider your user to be an employee from the library. After all the data has been loaded, the user should be presented with the following options.
  - Search for a specific book by title and/or author name.
  - List all books by title and/or author name alphabetical order.
  - Search for a specific reader by name and/or ID.
  - List all readers by alphabetical and/or ID order.
  - Register that a reader has borrowed a book.
  - If a book is borrowed and another reader wants to borrow it, allow the user to add that
reader to a waiting list (queue).
  - Register that a reader has returned a book.
  - If a book is returned and has a waiting queue, display to the user the next reader
waiting for that book.
  - For a specific reader, list the books that they have borrowed.
- In order to perform these tasks, you should implement APPROPRIATE constructs and data
structures. The use of the Java Collections Framework is allowed, except for Queues. Your
implementation of any queue structure must be CUSTOM MADE for your application.
- You must implement CUSTOM MADE searching and/or sorting algorithms. Even though, the
use of built-in Java Collections classes is allowed, searching and/or sorting algorithms must be your own.
- This is a command line program, and the use of graphic user interfaces is not allowed (i.e.
JavaSwing, JavaFX, GUI builders, etc.).

# Deliverables
- You must submit your full Eclipse/NetBeans project with all source code and data text files in
a zip named after your student number. This compressed folder should be submitted to
Moodle.
- One page document PDF document including
  - Explanation of the structure of your code.
  - Short justification for your logic design decisions.
  - Explanation of the structure of the text files used to ensure data persistency.

# Algorithms and Constructs
- Specific book by title and/or author name.
- Specific reader by name and/or ID.
- All books by title and/or author name alphabetical order.
- All readers by alphabetical and/or ID order.
- New borrowings and returns.
- Adding readers to a waiting list the book is borrowed.
- Comment code.
- PDF document including explanation of code structure, design justifications and
text file structure.

# PROG 1400 - ASSIGNMENT 4

## POLYMORPHISM & INTERFACES

---------

**Assignment Value: 11% of overall course mark.**

**Due Date: See due dates designated on the Assignment 4 dropbox on Brightspace.**

**Late submissions will receive the standard late submission penalty as stated in the course outline.**

**Assignment Instructions:**
Use Eclipse to create a Java Swing UI application, to demonstrate your understanding of polymorphism, interfaces, simple file I/O and basic Regex validation.

**Submissions:**
You will submit your program code for this assignment via dropbox on Brightspace.

**All files required to run the project (Main(), external files/folders like images, text files, etc.) must be included in the upload.**

**Evaluation:**
To insure the greatest chance of success on this assignment, be sure to check the marking rubric contained at the end of this document or in Brightspace. The rubric contains the criteria your instructor will be assessing when marking your assignment.

### Program - Poly Pengunins - Animal Tracking App

#### Design and Coding

Each Animal in the system shares a common attribute of Species. Make sure your classes do not duplicate any code by using Java inheritance and/or aggregation to share common attributes/methods, or define additional classes to capture differences. Your solution should include at least one interface, and show which classes implement it.

Some guidelines:

- Constructor methods should be included for all classes that have them.
- Your solution must include at least one example of inheritance.
- Your solution must include at least one example of an interface.
- Your solution must include at least one example of an abstract class.
- Proper line indicators denoting inheritance, association,  and interfaces should be included wherever required.

#### Program Requirements

Use Java and Java Swing to create a simple graphical Antarctic Animal Tracking program, to demonstrate your understanding of polymorphism, interfaces, simple file I/O and basic Regex validation.

Researchers at an Antarctic wildlife research facility need an application to help them keep track of penguins, sea lions and walruses. All animals in the study are outfitted with a tracking device that holds GPS information on its movements over time.

The application will use a simple UI that allows the researchers to record the species, sex, weight and GPS information of each animal captured. GPS data will be added to a GPS Log text file. Presumably a future enhancement to the program will be to save animal data to a database, but for now, all animals will be saved to a list in memory.

Both the saved animal entries from the list and the GPS data from file can be displayed as a report in the program.

Each animal observed has some distinct characteristics that are entered for only that species:

- For penguins only, the program needs to track blood pressure (double).
- For sea lions only it needs to track the number of spots each has (integer).
- For walrus only, their dental health “good”, “average” or ”poor” (String).

#### Data Validation Rules

- Weight must be a whole number greater than 0.
- GPS coordinates for latitude must range from -90 to 90 and have 7 places after the decimal.
- GPS coordinates for longitude must range from -180 to 180 and have 7 places after the decimal.
- There must be a space between latitude and longitude values.
- Penguins: Blood Pressure must be double greater than 0.
- Seal Lions: Number of Spots must be a whole number greater than 0.

#### Screen Descriptions

##### Data Entry Screen

The data entry screen will allow the user to enter all details for an observed animal of any of the three species. Species and gender will be displayed in as combobox choices (Penguin, Sea Lion and Walrus for species, Male and Female for Gender). Weight in Kg should only accept whole numbers in a textfield. For penguins and sea lions, their blood pressure (double) or number of spots (integer) values use textfields, while for walrus dental health will be displayed in a combobox. Appropriate labels for the species-specific should be displayed no matter which species is being entered.

GPS coordinates can be added into a textfield. When the Add GPS button is clicked, the entered GPS value will be validated via Regex. If it is valid, it will be added to the GPS textarea list.

When the Add Entry button is clicked, your program should use regular expressions to validate all user-entered data to ensure proper values. If any information is missing or invalid, display an error message indicating what is wrong. If all information is valid, create the selected animal object as its specific type, and add to a super-typed list that should hold all animal types in a single list. Once an animal entry has been saved, the screen should clear, to allow entry of the next animal.

At any time, the View Reports button will move the user to the Reports screen.

##### Reports Screen

The Reports screen should have a title label, which will display the title of the currently viewed report. The text area for displaying report data should be disabled.
The screen should include three buttons:

- **Show New Entries** – Will print to screen all attributes for all animals that have been entered in this session. (ie. Stored in memory)
- **Show GPS Logs** – Will read all GPS locations from the GPS Log text file, and print all to screen.
- **Back** – Will clear the report screen and return the user to the Data Entry screen.

#### Program Structure

Your program must use inherited classes for the program Frame and each of the two screens (as Panels), as well as for other objects used in the system.

Your program must include an interface called **ILoggable**, which will be used to write GPS data, to either the GPS Log file, or to the console (for debugging purposes). The interface must be implemented by each of the three animal types (write to file), and on your GPS class (write to console).

Each of your classes should make proper use of constructors, getter and setter methods, as well as any standard methods you deem necessary.

Your solution should also include at least one example of an abstract class and at least one abstract/override method. Examples of static properties or methods should also be included.

#### Sample Screenshots

##### Data Entry screen at startup

![Image1](https://i.postimg.cc/fRJ3YDTk/Picture1.png)

##### Data Entry screen, after adding data, before pressing Add GPS button

![Image2](https://i.postimg.cc/DzG8Y6GT/Picture2.png)

##### Data Entry screen, after adding data and AFTER pressing Add GPS button

![Image3](https://i.postimg.cc/5ys0Fkhw/Picture3.png)

##### Data Entry screen, after adding all valid data and pressing Add Entry button

![Image4](https://i.postimg.cc/v8hDjc4c/Picture4.png)

##### Data Entry screen, after adding a new record with multiple GPS entries

![Image5](https://i.postimg.cc/TYPhXfbQ/Picture5.png)

##### Reports screen, when first opened

![Image6](https://i.postimg.cc/6qWqqNmW/Picture6.png)

##### Reports screen, displaying New Entries Report (data from all animals added during this session).

![Image7](https://i.postimg.cc/rmLK64Gt/Picture7.png)

##### Reports screen, displaying GPS Logs Report (data retrieved from GPS Log text file).

![Image8](https://i.postimg.cc/Y9fjtS8D/Picture8.png)

##### Examples of some failed validation messages

![Image9](https://i.postimg.cc/htzjfspd/Picture9.png)

![Image10](https://i.postimg.cc/bNFryWHP/Picture10.png)

![Image11](https://i.postimg.cc/qMmhtzr9/Picture11.png)

### Rubric

![Rubric1](https://i.postimg.cc/brpgvsPZ/image.png)
![Rubric2](https://i.postimg.cc/Vkrqmjt7/image.png)

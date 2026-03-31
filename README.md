# Java-Project-24BAI10048
### JAVA Project | VITyarthi


---


## Student Information


| Field | Details |
|---|---|
| **Student Name** | *Sarthak Verma* |
| **Registration Number** |  *24BAI10048*|
| **Language** | *Java* |
| **Course** | *CSE2006 - Programming in Java* |
| **Data Storage** | *Java Object Serialization (.ser)* |


---


## About This Project

This repository contains the complete submission for the Personal Resource & Study Manager, a console-based Java application designed to help track and manage educational materials.

This project is a professional-grade Object-Oriented Java application designed to track educational materials like books and video lectures. The application allows users to store details about books and video lectures, monitor their completion progress, and seamlessly save their data between sessions. It serves as a practical demonstration of core Object-Oriented Programming (OOP) principles, including Abstraction, Inheritance, Polymorphism, and File I/O using Java Serialization.

This repository organizes code into specific packages (model, service, main) which encompasses multiple classes to handle different types of study resources and the interactive command-line (terminal) interface.


---


## Repository Structure


```

Java-Project-24BAI10048/
│
├── src/                                   -> Source code root
│   └── StudyManager/                      -> Base Package
│       ├── model/                         -> Data structures (The "What")
│       │   ├── StudyResource.java
│       │   ├── Book.java
│       │   └── VideoLecture.java
│       │
│       ├── service/                       -> Logic & Persistence (The "How")
│       │   └── DataHandler.java
│       │
│       └── main/                          -> Entry point (The "Run")
│           └── StudyManagerPro.java
│
├── data/                                  -> Persistent storage folder
│   └── study_data.ser                     -> Generated serialized data
│
└── README.md                              -> This documentation

```


---


## Package Descriptions & Architecture


### 1. src.StudyManager.model

The foundational core blueprint for all study materials. It implements Serializable to allow data persistence.

- **StudyResource (Abstract) :** The foundational blueprint implementing `Serializable`.
- **Book & VideoLecture :** Subclasses that extend the base resource with type-specific attributes like `author` or `url`.


---


### 2. src.StudyManager.service

Inherits from `StudyResource` and extends it to accommodate physical or digital reading materials. Handles the "heavy lifting" behind the scenes.

- **DataHandler :** Isolated logic for saving and loading the `ArrayList` to the `data/` directory. This ensures the UI never interacts directly with the file system.


---


### 3. src.StudyManager.main

The interaction layer.

- **StudyManagerApp :** Contains the main menu loop and user input handling. It coordinates between the user and the services.


---


### 4. StudyManager (Main Application Class)

- **Features :**
	- **In-Memory Storage :** Uses an `ArrayList<StudyResource>` to hold data during execution.
	- **Persistent Storage :** Utilizes `ObjectOutputStream` and `ObjectInputStream` to save and load the ArrayList to/from `study_data.ser`.
	- **Analytics :** Calculates and displays overall progress as a percentage based on completed versus total resources.
	- **Data Management :** Allows for targeted searching by subject or performing a complete factory reset of the local `.ser` file.


---


## How to Run the Application


### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your system.
- A terminal or command prompt.


### Step 1 — Clone the repository

```bash
git clone https://github.com/igsarthak/Java-Project-24BAI10048.git
cd Java-Project-24BAI10048
```


### Step 2 — Compile the Modular Code

Navigate to the `src` directory and compile the main application. Java will automatically find the related classes in the other packages :

```bash
javac StudyManager/main/StudyManagerPro.java
```


### Step 3 — Create Data Directory

Ensure a `data` folder exists in your root directory (the application looks for this specific path :

```bash
mkdir data
```


### Step 4 — Run the application

Execute the compiled StudyManager class :

```bash
java StudyManager
```


---


### Step 5 — Interact with the Menu

Upon launching, the system will automatically attempt to load any previous data. You will be presented with an interactive menu :

- **Add a Book :** Prompts for title, subject, author, and page count.
- **Add a Video Lecture :** Prompts for title, subject, URL, and duration.
- **View All Resources & Progress :** Displays your complete library and calculates your completion percentage.
- **Search by Subject :** Filters your library by a specific topic.
- **Mark Resource as Completed :** Flags a specific title as finished to update your progress metrics.
- **Reset all data :** Safely deletes the `study_data.ser` file to give you a clean slate.
- **Exit :** Serializes and saves your current session data before closing the program.


## Dependencies


| Dependency | Used For | Notes |
|---|---|---|
| `java.util.ArrayList` | Dynamic data storage | Part of the standard Java Collections Framework |
| `java.util.Scanner` | Console input handling | Part of standard `java.util` package |
| `java.io.*` | File saving and loading | Used for `Serializable`, Input/Output Streams, and `File` operations |



---


## Tested On

- Windows
- Standard Java standard execution environment (Java 11+)

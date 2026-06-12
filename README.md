# Hibernate LOB Mapping Demo

## Overview

This project demonstrates how to work with Large Objects (LOBs) in Hibernate using the `@Lob` annotation. It shows how to store and retrieve image files (BLOB) and text files (CLOB) from a relational database using Hibernate ORM.

## Features

* Store image files as BLOB (Binary Large Object)
* Store text files as CLOB (Character Large Object)
* Retrieve image and text data from the database
* Hibernate ORM with annotation-based configuration
* MySQL database integration
* Transaction management using Hibernate

## Technologies Used

* Java
* Hibernate ORM
* JPA Annotations
* MySQL
* Maven
* Eclipse IDE

## Project Structure

### Entity Class

`StudentTable`

* `sId` - Primary Key
* `name` - Student Name
* `image` - BLOB data stored as byte array
* `textdoc` - CLOB data stored as character array

### Store LOB Data

`LaunchLOBs.java`

This class:

1. Reads an image file using `FileInputStream`
2. Reads a text file using `FileReader`
3. Converts image data into a byte array
4. Converts text data into a character array
5. Stores both files in the database using Hibernate

### Retrieve LOB Data

`LaunchRetriveLOBs.java`

This class:

1. Fetches LOB data from the database
2. Retrieves image and text content
3. Creates a new image file from BLOB data
4. Creates a new text file from CLOB data

## Entity Mapping

```java
@Entity
@Table
public class StudentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    private String name;

    @Lob
    private byte[] image;

    @Lob
    private char[] textdoc;
}
```

## Workflow

### Insert Operation

```text
Image File
     |
     v
  byte[]
     |
     v
 Database (BLOB)

Text File
     |
     v
  char[]
     |
     v
 Database (CLOB)
```

### Retrieve Operation

```text
Database (BLOB/CLOB)
        |
        v
   Hibernate Entity
        |
        v
 Image File / Text File
```

## Learning Outcomes

* Understanding BLOB and CLOB concepts
* Using the `@Lob` annotation in Hibernate
* Handling binary and character large objects
* Reading and writing files in Java
* Persisting large object data using Hibernate ORM
* Retrieving and reconstructing files from database records

## Author

**Naresh Yelamoni**

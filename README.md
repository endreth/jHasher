![GitHub release (latest by date)](https://img.shields.io/github/v/release/endreth/jHasher) ![GitHub](https://img.shields.io/github/license/endreth/jHasher) ![GitHub top language](https://img.shields.io/github/languages/top/endreth/jHasher?style=plastic) ![GitHub all releases](https://img.shields.io/github/downloads/endreth/jHasher/total)

# jHasher v1.0.2

![github1](https://user-images.githubusercontent.com/104054427/227722419-6464aaf7-7a3e-4e3f-884b-06a48f872cc1.png)

### A Java-based software implementing modern and traditional cryptographic hash functions.

The jHasher software is capable of calculating hash values for files and directories, and comparing them. It is a user-friendly, platform-independent, easily extensible, intuitive, and convenient tool for this purpose. jHasher was developed in Java (Java JDK 18), an object-oriented language that guarantees platform independence. It employs the Model View Controller (MVC) pattern to ensure extensibility and scalability with additional hash functions. jHasher implements multi-threaded hashing functions using the Abstract Factory Pattern. The Graphical User Interface (GUI) of jHasher was created using the JavaFX API (JavaFX 18), which provides visually appealing and user-friendly interfaces. The Apache Maven project management tool and the IntelliJ IDEA development environment were used to build jHasher and run tests.

jHasher includes 32 salted and unsalted hash functions, including traditional functions like MD2, MD5, and SHA-1, as well as more advanced and secure functions such as Blake2, Argon2, and BCrypt. With jHasher, users can generate unique hash values for texts and passwords by breaking the input data into one or more parts. Users can also obtain a unique hash value for a single directory or even an entire directory (master hash), or generate separate hash values for each file in a directory. jHasher also allows users to compare files or directories using the generated hash values.

The current version of JHasher is 1.0.2 (last major update: 2023.02.23).
### Requirements
GNU/Linux, Microsoft Windows, or macOS (tested on Windows 10)<br>
JRE (JDK 11 or later) (preferably 18+)<br>
### Usage

Get the JAR artifact [HERE](https://github.com/endreth/jHasher/blob/master/jHasher-1.0.2.jar)! (You must have JRE installed!)

Running jHasher from the command line:
```
$ java -jar jHasher-1.0.2.jar
```

### Hash functions (in current version)
[recommended for texts/passwords: &star;; for files and directories: &starf;]
- <b>Non-salted</b>
    - SHA-1 family (SHA-1, SHA-224, SHA-256, SHA-384, SHA-512) &star; &starf;
    - SHA-3 family (SHA3-224, SHA3-256, SHA3-384, SHA3-512) &star; &starf;
    - MD family (MD2, MD5) &star; &starf; (MD2 slow!)
    - Blake family (Blake2b, Blake3) &star;
    - TIGER &star;
- <b>Salted</b>
    - SHA-1 family (SHA-1, SHA-224, SHA-256, SHA-384, SHA-512) &star; &starf;
    - SHA-3 family (SHA3-224, SHA3-256, SHA3-384, SHA3-512) &star; &starf;
    - MD family (MD2, MD5) &star; &starf; (MD2 slow!)
    - Blake family (Blake2b, Blake3) &star; &starf;
    - Argon family (Argon2id) &star;
    - PBKDF2 &star;
    - TIGER &star;
    - BCrypt &star;
    - SCrypt &star;

<details open>
<summary><b>Usage details</b> [Tab functions]</summary><br>

In the current version of the program, the following options are available:

• <b>['Text']</b> Hashing of passwords and texts. The string size is limited to 5000 characters. There are 18 salted and 14 unsalted functions to choose from. The input string can be split by a separator, converted to lowercase, and normalized by removing accents and diacritical marks. A single hash fingerprint is generated if the Line-by-Line option is not selected.

• <b>['File']</b> Hashing of a file. The file size is limited to 3 GB. There are 13 salted and 13 unsalted functions to choose from. It does not include functions designed for password hashing (which use permutation or are inherently salted, e.g. BCrypt, SCrypt). A single hash fingerprint is generated for the selected file.

• <b>['Directory']</b> Hashing of the 1st level of a directory (non-recursive). The size of individual files is limited to 3 GB. There are 13 salted and 13 unsalted functions to choose from. It does not include functions designed for password hashing (which use permutation or are inherently salted, e.g. BCrypt, SCrypt). A single hash fingerprint is generated for the selected directory. It will hash the items in the directory and calculate a master hash (top hash) based on the "hash list" principle.

• <b>['Multiple Files (Dirs)']</b> Hashing of the 1st level of a directory (non-recursive). The size of individual files is limited to 3 GB. 13 salted and 13 unsalted functions can be selected. It does not include functions designed for password hashing (which use permutation or are inherently salted, e.g. BCrypt, SCrypt). One hash fingerprint is generated for each file in the directory. The directory may contain "infinitely many" files.

• <b>['Compare Files']</b> Hashing of two files and comparison of their fingerprints. The file size is limited to 3 GB. 13 salted and 13 unsalted functions can be selected. It does not include functions designed for password hashing (which use permutation or are inherently salted, e.g. BCrypt, SCrypt). One hash fingerprint is generated for each file, and their values are compared. If the fingerprints match, they are marked in red; if not, they are marked in green.

• <b>['Compare Dirs']</b> Hashing of the 1st level of two directories (non-recursive). The size of individual files is limited to 3 GB. 13 salted and 13 unsalted functions can be selected. It does not include functions designed for password hashing (which use permutation or are inherently salted, e.g. BCrypt, SCrypt). One hash fingerprint is generated for each file, and their values are compared. If the fingerprints match, they are marked in red; if not, they are marked in green. The directory may contain "infinitely many" files.

</details>

<details open>
<summary><b>Acknowledgment</b></summary><br>
The hash implementations used in this program are sourced from a variety of libraries and APIs, including the <a href="https://docs.oracle.com/en/java/javase/18/security/java-cryptography-architecture-jca-reference-guide.html#GUID-2BCFDD85-D533-4E6C-8CE9-29990DEB0190">Java Cryptography Extension (JCE-JCA)</a>, the <a href="https://www.bouncycastle.org/">Bouncy Castle Crypto API</a>, the <a href="https://docs.spring.io/spring-security/reference/">Spring Security API</a>, as well as proprietary code developed by <a href="https://github.com/rctcwyvrn">Rctcwyvrn (Lily)</a> and <a href="https://github.com/phxql">Phxql (Moritz Halbritter)</a>.<br> 
An acknowledgement should be made to <a href="https://igazsagugyi-szakerto.hu/">Tamás M. Fülöp</a> (forensic IT expert) and <a href="https://github.com/dandidev">Roland Dandi</a> (Java programmer) for their invaluable guidance and support throughout the project, as well as for their valuable insights shared during discussions. Last, acknowledgement should be made to <a href="https://github.com/mouse0w0">Mouse0w0</a> for creating the DaraculaFX theme.<br> 
The projects of <a href="https://github.com/tedsmith/quickhash">QuickHash</a> and <a href="https://github.com/jonelo/jacksum">Jacksum</a> should also be mentioned, as they provided valuable inspiration and ideas that contributed to the development of this project. 
    
</details>

![github2](https://user-images.githubusercontent.com/104054427/227724910-a71f13dc-76ed-4a86-9e2a-61253ee4dead.png)
The UI design was created with [Balsamiq Wireframes](https://balsamiq.com/).

# Hugo to Joomla conversion tool.

This utility takes a joomla database and converts all the content into md markup files. It changes any URLs that are
in Joomla internal format and converts them to a suitable form (assuming you had SEO friendly links on before).

Hugo Joomla has been tested by converting http://www.thecoderscorner.com from Joomla to Hugo. As per the hugo
author, I found that I spent more time working around Joomla than with it.

In order to use this utility you will need to move any statically served content into the Hugo static directory.
Check carefully there are no compromised PHP files in that structure before copying! Better still turn off all
scripting in that location.

## Running the conversion utility

Check that you have Java 8 installed. Either take the binary package or build from source. You can check your
java version using the following command:

    java --version

Should return something like:

    java version "1.8.0_102"
    Java(TM) SE Runtime Environment (build 1.8.0_102-b14)

WARNING: !!this process will overwrite all existing files with the same names. Ensure you have a backup before running!!
If you take the binary package, just navigate to the directory and type:

    java -jar .\hugo-joomla-0.1-SNAPSHOT.jar -dburl <url> -dbuser <user> -dbpass <password> -outdir <output dir>

Where
 dburl is the jdbc URL. Example "jdbc:mysql://localhost:3306/your_dbname". For local connection on 3306 to your_dbname
 dbuser is a user that can read from the database
 dbpass is the password for the user
 outdir optional, defaults to current dir. Where to write the content files.

## Building from source

Pull down this git repo and run the install task. The jar will be in the target directory
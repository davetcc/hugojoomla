# Hugo to Joomla conversion tool.

Converts a joomla database into a series of md markup files in the TOML format suitable for use in Hugo content manager.
It changes any URLs that are in Joomla internal format into joomla SEO friendly format (assuming you had SEO friendly
links on before converting).

Hugo Joomla is been tested by attempting to convert http://www.thecoderscorner.com from Joomla to Hugo. As per the hugo
author, I found that I spent more time working around Joomla than with it. I'm now all but complete converting
over, what's remaining is more to do with learning Hugo than anything else. At the moment, all articles will be ported
over as the type "blog".

Designed for use with the static Hugo CMS: http://hugo.go.io

In order to use this utility you will need to move any statically served content (images, media, etc) into the Hugo static directory.
Check carefully there are no compromised PHP files in that structure before copying! Better still turn off all
scripting in that location.

At the moment this project always converts all nested categories into menus in the front matter, based on an example
at this site (https://github.com/vjeantet/hugo-menu-show) . You'll potentially need to alter your template along similar
lines to that site if you have nested categories. If you did not have nested categories then a new version with an option
that flattens out categories, to create a single level site will soon be available.

## Running the conversion utility

Check that you have Java 8 installed. You can check your java version using the following command:

    java --version

The above command should return something like:

    java version "1.8.0_102"
    Java(TM) SE Runtime Environment (build 1.8.0_102-b14)

You can use the packaged version that is available from the releases page. Building from source is not required.
Should you wish to build from source, you will need apache maven, any recent version should be good enough.
Ensure the maven bin directory is on your path. At this point in the project top level directory type:

    mvn install

Once this is complete there will be a target directory, and in there will be a jar file.

Either way change to the application directory and run as follows:

    java -jar .\hugo-joomla-0.1-SNAPSHOT.jar -dburl <url> -dbuser <user> -dbpass <password> -outdir <dir> -dbext <prefix>

** WARNING: !!this process will overwrite all existing files with the same names. Ensure you have a backup before running!!**


Where
 * dburl is the jdbc URL. Example "jdbc:mysql://localhost:3306/your_dbname". For local connection on 3306 to your_dbname
 * dbuser is a user that can read from the database
 * dbpass is the password for the user
 * outdir optional, defaults to current dir. Where to write the content files.
 * dbext the extension used for joomla tables in the db. Eg: tcc would be tcc_tablename

## Building from source

Pull down this git repo and run the install task. The jar will be in the target directory
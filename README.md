# Joomla to Hugo conversion tool.

Converts a joomla database into a series of md markup files in the TOML format suitable for use in Hugo content manager
[http://hugo.go.io]

This conversion utility will change any URLs that are in Joomla internal format into joomla SEO friendly format
(assuming you had SEO friendly links on before converting). If you did not have SEO friendly links turned on, your 
conversion will not be automatic, as you will have to map all the Joomla URLS.

HTML Joomla articles are converted to markdown with the https://github.com/furstenheim/copy-down to ensure compatibility with hugo > 6.0 which is not rendering HTML content by default anymore.

Hugo Joomla is tested by converting an older Joomla 3 site I had from Joomla to Hugo.  With the latest release, 
I believe it should be fully functional for most people. My blog [https://www.thecoderscorner.com] is an example of a 
site converted with this utility.


There is a more detailed article on my website that may be helpful before starting:
[https://www.thecoderscorner.com/team-blog/joomla-cms/moving-to-hugo-from-joomla/].

In order to use this utility you will need to move any statically served content (images, media, etc) into the Hugo 
static directory before proceeding, keep the same directory structure as you had on Joomla. At this point I recommend
that you check carefully there are no compromised PHP files in that structure before copying!

At the moment this project always converts all nested categories into menus in the front matter, there are examples of
this both on the Hugo site [https://gohugo.io/extras/menus/] and also there is an example at this site 
(https://github.com/vjeantet/hugo-menu-show). 

If you used nested categories, you'll probably have to make changes to the template to support it. Otherwise, you probably
just need to remove the reference to the root category in the top level categories and away you go!

In addition all content is currently converted as type "blog".

## Running the conversion utility

Check that you have at least Java 8 installed. You can check your java version using the following command:

    java --version

The above command should return something like:

    java version "1.8.0_102"
    Java(TM) SE Runtime Environment (build 1.8.0_102-b14)

I have tested that the process at least runs on Java versions through to 16.

You can use the packaged version that is available from the releases page. 
[releases page](https://github.com/davetcc/hugojoomla/releases)

Change into the application directory and run the command as follows:

    java -jar .\hugo-joomla-0.1-SNAPSHOT.jar -dburl <url> -dbuser <user> -dbpass <password> -outdir <dir> -dbext <prefix>

** WARNING: !!this process will overwrite all existing files with the same names. Ensure you have a backup before running!!**


Where
 * dburl is the jdbc URL. Example "jdbc:mysql://localhost:3306/your_dbname". For local connection on 3306 to your_dbname
 * dbuser is a user that can read from the database
 * dbpass is the password for the user
 * outdir optional, defaults to current dir. Where to write the content files.
 * dbext the extension used for joomla tables in the db. Eg: tcc would be tcc_tablename
 * buildtags optional, defaults to true. Turn on or off processing of tags.
 * htmltomarkdown optional, defaults to true. Turn on or off HTML article content conversion to markdown.

## Building from source

Pull down the master branch from this github project in order to start.
You will also need apache maven, any recent version should be good enough.
Ensure the maven bin directory is on your path. At this point in the project top level directory type:

    mvn install

Once this is complete there will be a target directory, and in there will be a jar file.

## Deveopers and notes on contributing

Please raise a PR with the change. Check https://github.com/joomlaext/hugojoomla/actions/runs/1177286827 for CI pipeline result before merging ;-)

For particularly large scale changes, it's best to raise an issue first.

# XNAT Plugin 101 Example

Welcome to the XNAT Plugin 101 Example.
This briefest of examples demonstrates:
* A small build.gradle file
* One java file that creates a plugin that logs the existence of the plugin and nothing else
* One configuration file for logging to control that aspect

## Build The Example
In this the 101 folder, clean and build the plugin jar
    ./gradlew clean xnatPluginJar
Examine jar that is created; look at text in three of the files:
    cp build/libs/xnat-plugin-101-7.8.9.jar /tmp
    mkdir /tmp/x
    pushd /tmp/x
    jar xf ../xnat-plugin-101-7.8.9.jar
    find . -type f

## Install the Plugin
1. Copy build/libs/xnat-plugin-101.7.8.9.jar to the XNAT plugins folder
2. Stop and start tomcat
3. Examine the log output in the XNAT logs folder (logs/plugin-101.log). You should see one log message announcing that XNAT is creating the Plugin101 configuration class
4. Log in to your XNAT as an administrator and look for the plugin
4.1. Select Administer --> Site Administration
4.2 Look in the left flap and select Installed Plugins
4.3 View the information concerning the 101 plugin

## Review the Source Code
### build.gradle
These are items to notice
* This plugin is built on XNAT version 1.8.2.2
* The version of this plugin is 7.8.9
* Building the plugin relies on Maven Central as well as a Maven repository hosted by the XNAT team
* A small number of values are computed and go into the jar manifest. Other examples will fill this out further.

### settings.gradle
This file contains the name of the root project. In this case: xnat-plugin-101

### src/main/java/org/unicorn/xnatx/plugin/Plugin101.java
This is the java file with the plugin code. Please note:
* The XnatPlugin annotation
    - Declares this is a plugin with an identifier (value) and name (text)
    - Declares the location of the configuration file for logging
 * Logs messages in the default constructor. You can find the output in the logfile at run time

### src/main/resources/META-INF/resources/plugin-101-logback.xml
This is the configuration file used by logback for this class. Please note:
* This file is located in src/main/resources/META-INF/resources in the code repository. That will translate to  META-INF/resources in the jar file.
* There is an &lt;appender&gt; element which defines properties for the log file itself.
* There is a &lt;logger&gt; element that links the plugin class to the log file.


# XNAT Plugin 102 Example

Plugin 102 extends Plugin 101:
* Adds a class that can accept EventService events and log them

## Build The Example
In this the 102 folder, clean and build the plugin jar
    ./gradlew clean xnatPluginJar

## Install the Plugin
1. Copy build/libs/xnat-plugin-102-0.1.0.jar to the XNAT plugins folder
2. Stop and start tomcat
3. Examine the log output in the XNAT logs folder (logs/plugin-102.log). You should see one log message announcing that XNAT is creating the Plugin102 configuration class
4. Log in to your XNAT as an administrator and look for the plugin
4.1. This plugin can be installed with Plugin 101. They should not have conflicts.

## Review the Source Code
### build.gradle
These are items to notice
* The version of this plugin is 0.1.0

### settings.gradle
This file contains the name of the root project. In this case: xnat-plugin-102

### src/main/java/org/unicorn/xnatx/plugin/Plugin102.java
This is the java file with the plugin code. Please note:
 * Instantiates the EventListener object in the Plugin102 constructor

### src/main/java/org/unicorn/xnatx/listeners/DefaultEventServiceListener.java
This is the java class that listens for events and logs them.

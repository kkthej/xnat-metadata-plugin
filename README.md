# XNAT MetadataPlugin inspired from TemplatePlugin #

This is the XNAT Metadata Plugin. It provides customized UI pages in the new project page and the index page.

> **Note:** Search throughout your new plugin project for the string "TODO:". This has been added
 in comments throughout the template project to help you find areas you may need to modify or 
 remove for your particular plugin project. Once you have created your own plugin project from
 this template, you can remove all of the "TODO:" comments. 

 

# Building #

To build the XNAT metadata plugin:

1. If you haven't already, clone this repository and cd to the newly cloned folder.
1. Build the plugin: `./gradlew jar` (on Windows, you can use the batch file: `gradlew.bat jar`). This should build the plugin in the file **build/libs/xnat-metadata-plugin-1.0.0-SNAPSHOT-xpl.jar** (the version may differ based on updates to the code).
1. Copy the plugin jar to your plugins folder: `cp build/libs/xnat-metadata-plugin-1.0.0-SNAPSHOT-xpl.jar /data/xnat/home/plugins`

You'll end up repeating the second step pretty frequently. You can clean out the `build` folder with the `clean` task, which can be run on its own or with other tasks. For example, as separate tasks:

```
./gradlew clean
./gradlew jar
```

You can also combine these into a single command:

```
./gradlew clean jar
```

Also, [build.gradle](build.gradle) includes this statement:

```
compileJava.dependsOn project.tasks["xnatDataBuilder"]
```

That means that any task that depends on `compileJava` (which any of the `jar` tasks do) automatically triggers `xnatDataBuilder` as well, so running `xnatPluginJar` ends up running `xnatDataBuilder` automatically. You may still want to run `xnatDataBuilder` on its own sometimes, just to inspect any code that's generated from your data-type schemas.

# xnat-metadata-plugin


This is a simple implementation to show how to load a java file dynamically to current runtime and execute it

This code will start a new thread which will scan a location (can be provided as command line argument) every 5 sec,
and compile/load in to system class loader. 


How to Run:
 java DynaLoader /tmp/myfiles   : This is the location you need to drop custom java files to load
 Put some custom implementation .java files in /tmp/myfiles
 Wait for 5 sec. Now you can see files are loaded.
 Now you can type "say hello". Which will run all the implementation of HelloInterface
 
Custom Java Files:
 Needs to be implementation of HelloInterface. See PluginLoaderTask.java for more details how to load
 This is done just as an example, feel free to add more interfaces as needed.
 
 
 Improvement Areas:
 
 1. Currently this code will load files which do not have any package defined. Need to make it more reliable to load any package 
    See: PluginLoaderTask.java for more details
    
 2. Currently this code scan a directory every 5 seconds, we can make it event driven by using File System Watcher
 
 3. Currently I load plugin to System class loader which is not secure. 

package com.test.designpatterns.plugins;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class PluginLoaderTask implements Runnable{
	
	String sourceDir;
	List<String> loadedClass = new ArrayList<String>();
	List<String> compiledFiles = new ArrayList<String>();
	
	public PluginLoaderTask(String s) {
		this.sourceDir = s;
	}
	
	public void run(){
		
		while(true){
			try{
				Thread.sleep(5000L);
				
				File source = new File(sourceDir);
				List<File> files = new ArrayList<File>();
				List<File> classes = new ArrayList<File>();
				
				//compile all java files
				for(File file : source.listFiles()){
					if(file.getName().endsWith(".java") && !compiledFiles.contains(source.getName())){
						files.add(file);
						compiledFiles.add(file.getName());
					}
				}
				if(files.size() > 0){
					this.compile(files);
				}
				//load all class files
				for(File file : source.listFiles()){
					if(file.getName().endsWith(".class")){
						classes.add(file);
					}
				}
				this.load(classes);
				
				
			}catch(Exception e){
				System.out.println("Error while loading plugin,  recreate a better one:"+ e.getMessage());
			}
			
		}
	}
	
	/**
	 * Convert .java to .class
	 * @param files
	 * @throws IOException
	 */
	private void  compile(List<File> files) throws IOException{
		    
			
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		    StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
		    Iterable<? extends JavaFileObject> compilationUnits = fileManager
		        .getJavaFileObjectsFromFiles(files);
		    JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
		        null, compilationUnits);
		    boolean success = task.call();
		    fileManager.close();
		    
	}
	
	/**
	 * Load all classes implements HelloInterface
	 * TODO: We need to make it more reliable to load any class in any package. Right now only file with no package will only work
	 * 
	 * @param files
	 * @throws MalformedURLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private void load(List<File> files) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		 ClassLoader cl = Thread.currentThread().getContextClassLoader();
		 
		for(File f: files){
			if(f.getName().endsWith(".class") && !loadedClass.contains(f.getName())){
				 URL url = f.toURL();
				 URL[] urls = new URL[]{url};
				 Object obj = cl.loadClass(f.getName().replace(".class", "")).newInstance();
				 if(obj instanceof HelloInterface){
					 HelloProviders.addProvider((HelloInterface)obj);
					 System.out.println("Loaded "+ ((HelloInterface)obj).getProviderName());
				 }else{
					 //Add more classes if you want
				 }
				 loadedClass.add(f.getName());
					
				
			}
		}
		
		
	}
	
	

}

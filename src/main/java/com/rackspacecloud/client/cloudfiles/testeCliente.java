package com.rackspacecloud.client.cloudfiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.http.HttpException;

import com.rackspacecloud.client.cloudfiles.*;

public class testeCliente {
	public static void main (String args[])  throws HttpException, IOException{
		
			try{
					
					String containerName;
					containerName = "ContainerCloudFiles";
					
					FilesClient client = new FilesClient();
					
					client.login();
					
					File input = new File("");
			        JFileChooser fc = new JFileChooser();
			        fc.showOpenDialog(null);
			        input = fc.getSelectedFile();
			        String fileName = fc.getName(input);

	List<FilesContainer> containers = client.listContainers();
	for (FilesContainer cont : containers){
		System.out.println("Container: " + cont.getName());
	}

			        if(client.containerExists(containerName)){
			        	client.storeObjectAs(containerName, input,"application/octet-stream", fileName);	
			        }
			        else{
			        	client.createContainer(containerName);
			        	client.storeObjectAs(containerName, input,"application/octet-stream", fileName);
			        }
					
					//client.deleteObject(containerName, fileName);
					//client.deleteContainer(containerName);
	        }catch (Exception e) {
				e.printStackTrace();
			}
	}
			
}

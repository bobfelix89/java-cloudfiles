package com.rackspacecloud.client.cloudfiles;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.http.HttpException;

import com.rackspacecloud.client.cloudfiles.FilesClient;

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
			        String fileName = "TesteArquivo";
					
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

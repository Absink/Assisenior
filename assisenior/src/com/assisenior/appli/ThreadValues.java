package com.assisenior.appli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.assisenior.service.DetectionChuteService;
import com.assisenior.service.HeartMonitoringService;

public class ThreadValues extends Thread {
	
	public ThreadValues() {
		super();
	}
	
	public void run() {
		System.out.println("[ASSISENIOR] START APPLICATION");
		while(true) {
			//System.out.println("Lecture du fichier");
			try {
				// Lecture dans le fichier de données dataShared.csv
				// ATTENTION - PATH A MODIFIER !!!
				String file = "C:/Users/Olivier/Documents/workspace-sts-3.9.3.RELEASE/assisenior/assisenior/WebContent/resources/dataShared.csv";
				BufferedReader fichierSource = new BufferedReader(new FileReader(file));
				
				String values;
				while((values = fichierSource.readLine())!= null) {
					String[] value = values.split(";");
					if(value[0].equals("rythmeCardiaque")) {
						HeartMonitoringService.controlHeartBeat(Integer.parseInt(value[1]));
					}
					if(value[0].equals("detectChute")) {
						DetectionChuteService.controlChute(Integer.parseInt(value[1]), Integer.parseInt(value[2]), Integer.parseInt(value[3]));
					}
				}
				fichierSource.close();  
					
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
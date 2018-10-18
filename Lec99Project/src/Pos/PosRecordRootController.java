package Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PosRecordRootController implements Initializable{

	@FXML TextArea txt;
	@FXML Button refresh;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void handleCancel(ActionEvent event) {
		Platform.exit();
	}
	
	public void handleRefresh(ActionEvent event) {
		
		File file = new File("./Pos.txt");
		
		txt.clear();
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String a =scan.nextLine();
				
				txt.appendText(a+"\n");
				
			}
		} catch (FileNotFoundException e) {
			
		}
		
	}
	
}

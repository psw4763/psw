package Pos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class PosRootController implements Initializable {

	
	
	@FXML RadioButton rdoHot;
	@FXML RadioButton rdoIce;
	@FXML RadioButton rdoShot;
	@FXML RadioButton rdoNoShot;
	@FXML RadioButton rdoSmall;
	@FXML RadioButton rdoTall;
	@FXML RadioButton rdoLarge;
	
	@FXML ToggleGroup MenuGroup;
	@FXML ToggleButton btEs;
	@FXML ToggleButton btAme;
	@FXML ToggleButton btMocha;
	@FXML ToggleButton btLatte;
	@FXML ToggleButton btCappu;
	@FXML ToggleButton btWhite;
	
	ToggleGroup rdoGroup;
	@FXML ToggleGroup ShotGroup;
	@FXML ToggleGroup SizeGroup;
	
	@FXML TextField menuOrder;
	@FXML TextField temOrder;
	@FXML TextField shotOrder;
	@FXML TextField sizeOrder;
	@FXML TextField totalOrder;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		MenuGroup = new ToggleGroup();
		btEs.setToggleGroup(MenuGroup);
		btAme.setToggleGroup(MenuGroup);
		btMocha.setToggleGroup(MenuGroup);
		btLatte.setToggleGroup(MenuGroup);
		btCappu.setToggleGroup(MenuGroup);
		btWhite.setToggleGroup(MenuGroup);
		
			MenuGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				@Override
				public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					
					String menuData = newValue.getUserData().toString();
					menuOrder.setText(menuData);
					totalOrder.setText(menuOrder.getText()+temOrder.getText()+shotOrder.getText()+sizeOrder.getText());
					
				}
			});
		
			
		rdoGroup = new ToggleGroup();
		rdoHot.setToggleGroup(rdoGroup);
		rdoIce.setToggleGroup(rdoGroup);
		
		rdoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				
					String temData = newValue.getUserData().toString();
					temOrder.setText(" /"+temData);
					totalOrder.setText(menuOrder.getText()+temOrder.getText()+shotOrder.getText()+sizeOrder.getText());
				
			}
		});
		
		
		ShotGroup = new ToggleGroup();
		rdoShot.setToggleGroup(ShotGroup);
		rdoNoShot.setToggleGroup(ShotGroup);
		
		ShotGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				
				String shotData = newValue.getUserData().toString();
				shotOrder.setText(" /"+shotData);
				totalOrder.setText(menuOrder.getText()+temOrder.getText()+shotOrder.getText()+sizeOrder.getText());
				
			}
		});
		
		
		SizeGroup = new ToggleGroup();
		rdoSmall.setToggleGroup(SizeGroup);
		rdoTall.setToggleGroup(SizeGroup);
		rdoLarge.setToggleGroup(SizeGroup);
		
		SizeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				
				String sizeData = newValue.getUserData().toString();
				sizeOrder.setText(" /"+sizeData);
				totalOrder.setText(menuOrder.getText()+temOrder.getText()+shotOrder.getText()+sizeOrder.getText());
				
			}
		});
		
	}
	
	public void handleCancel(ActionEvent event) {
		Platform.exit();
	}
	
	
	
	public void handleOrder(ActionEvent event) throws IOException {
		
		SimpleDateFormat DateType = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String DateTime = DateType.format(new Date());
		
		String data = "주문내역 : ("+DateTime+") "+totalOrder.getText();
		
		
		try {
			File file = new File("./Pos.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			
				bufferedWriter.write(data);
				bufferedWriter.newLine();
				
				bufferedWriter.flush();
				bufferedWriter.close();
		
		}catch(IOException e) {
			
		}
		
		
			
	}
	
	
}



















package com.payroll;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TableViewApp{
	@FXML ListView<String> list1;
	@FXML ListView<String> list2;
	private ObservableList<String> obList1;
	private ObservableList<String> oblist2;
	
	 public void initialize() {
	    	obList1 = FXCollections.observableArrayList();
	    	obList1.add("asasas");
	    	obList1.add("dsadas");
	    	list1.setItems(obList1);
	    }
}
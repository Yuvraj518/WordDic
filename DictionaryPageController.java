package com.example.worddic;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {
    @FXML
    TextField search,add1,add2,find;
    private DictionarySaver db;

    @FXML
    public void search(MouseEvent e) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        //db.serializeHashMap();
        db.deserilizeHashMap();
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(add1.getText().equals("") || add2.getText().equals("")){
            alert.setContentText("Enter word");
            alert.showAndWait();
        }
        else {
            if (db.getDlist().containsKey(search.getText().toLowerCase())) {
                alert.setContentText("word is present");
            } else {
                alert.setContentText("word is not present");
            }
            alert.showAndWait();
        }
    }
    @FXML
    public void Add(MouseEvent e) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        db.deserilizeHashMap();
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(add1.getText().equals("") || add2.getText().equals("")){
            alert.setContentText("Enter word");
            alert.showAndWait();
        }
        else {
            db.getDlist().put(add1.getText().toLowerCase(), add2.getText());
            db.serializeHashMap();
            alert.setContentText("New Word is Added");
            alert.showAndWait();
        }
    }
    @FXML
    public void Find(MouseEvent e) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        db.deserilizeHashMap();
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(add1.getText().equals("") || add2.getText().equals("")){
            alert.setContentText("Enter word");
            alert.showAndWait();
        }
        else {
            if (db.getDlist().containsKey(find.getText())) {
                alert.setContentText(db.getDlist().get(find.getText().toLowerCase()));
                alert.showAndWait();
            }
        }
    }
}

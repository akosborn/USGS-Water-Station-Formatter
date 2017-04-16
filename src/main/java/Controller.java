import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller
{
    public TextField fileName;
    private File inputCSV;
    private String outputCSVDirectory = "/home/andrew/Desktop/";
    private String outputCSVName = "station-formatted";

    public void openFile(ActionEvent actionEvent)
    {
        FileChooser chooser = new FileChooser();

        //Create and add extension filter for .csv
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("(CSV files (*.csv)", "*.csv");
        chooser.getExtensionFilters().add(extensionFilter);

        //Show file chooser dialog
        inputCSV = chooser.showOpenDialog(new Stage());
    }

    public void outputPath(ActionEvent actionEvent)
    {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        outputCSVDirectory = directoryChooser.showDialog(new Stage()).getAbsolutePath();
    }

    public void format(ActionEvent actionEvent)
    {
        File outputFile = new File(outputCSVDirectory + "/" + outputCSVName + ".csv");
        OpenCSV.formatCSV(inputCSV, outputFile);
    }

    public void setFileName(KeyEvent keyEvent)
    {
        outputCSVName = fileName.getCharacters().toString();
    }
}

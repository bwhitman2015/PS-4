package Address;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Address {
	import java.io.IOException;

	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Scene;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.BorderPane;
	import javafx.stage.Stage;

	public class MainApp extends Application {

	    private Stage primaryStage;
	    private BorderPane rootLayout;

	    @Override
	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("AddressApp");

	        initRootLayout();

	        showPersonOverview();
	    }

	    /**
	     * Initializes the root layout.
	     */
	    public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Shows the person overview inside the root layout.
	     */
	    public void showPersonOverview() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            // Set person overview into the center of root layout.
	            rootLayout.setCenter(personOverview);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Returns the main stage.
	     * @return
	     */
	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}
	public class DateUtil {

	    /** The date pattern that is used for conversion. Change as you wish. */
	    private static final String DATE_PATTERN = "dd.MM.yyyy";

	    /** The date formatter. */
	    private static final DateTimeFormatter DATE_FORMATTER = 
	            DateTimeFormatter.ofPattern(DATE_PATTERN);

	    /**
	     * Returns the given date as a well formatted String. The above defined 
	     * {@link DateUtil#DATE_PATTERN} is used.
	     * 
	     * @param date the date to be returned as a string
	     * @return formatted string
	     */
	    public static String format(LocalDate date) {
	        if (date == null) {
	            return null;
	        }
	        return DATE_FORMATTER.format(date);
	    }

	    /**
	     * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN} 
	     * to a {@link LocalDate} object.
	     * 
	     * Returns null if the String could not be converted.
	     * 
	     * @param dateString the date as String
	     * @return the date object or null if it could not be converted
	     */
	    public static LocalDate parse(String dateString) {
	        try {
	            return DATE_FORMATTER.parse(dateString, LocalDate::from);
	        } catch (DateTimeParseException e) {
	            return null;
	        }
	    }

	    /**
	     * Checks the String whether it is a valid date.
	     * 
	     * @param dateString
	     * @return true if the String is a valid date
	     */
	    public static boolean validDate(String dateString) {
	        // Try to parse the String.
	        return DateUtil.parse(dateString) != null;
	    }

}

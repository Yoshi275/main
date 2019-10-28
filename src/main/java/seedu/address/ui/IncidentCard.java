package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.incident.Incident;

/**
 * An UI component that displays information of an {@code Incident}.
 */
public class IncidentCard extends UiPart<Region> {

    private static final String FXML = "IncidentListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     */

    public final Incident incident;

    @FXML
    private HBox cardPane;
    @FXML
    private Label operator;
    @FXML
    private Label incidentLocation;
    @FXML
    private Label dateTime;
    @FXML
    private Label id;
    @FXML
    private Label incidentId;
    @FXML
    private Label callerNumber;
    @FXML
    private Label description;
    @FXML
    private Label status;


    public IncidentCard(Incident incident, int displayedIndex) {
        super(FXML);
        this.incident = incident;
        id.setText(displayedIndex + ". ");
        incidentId.setText("Incident #" + incident.getIncidentId().getId());
        dateTime.setText("created on " + incident.getDateTime().toString());
        operator.setText("Filed by: " + incident.getOperator().getName().toString() + " ("
                + incident.getOperator().getUsername() + ")");
        incidentLocation.setText("District: " + String.valueOf(incident.getDistrict().districtNum));
        callerNumber.setText("Caller: " + incident.getCallerNumber().toString());
        description.setText(incident.getDesc().toString());

        // status label setup
        String statusString = incident.getStatus().toString();
        status.setText(statusString);
        status.setStyle(getBackgroundColourBasedOnValue(statusString) + "; -fx-font-weight: bold; -fx-border-width: 2.5"
                + "; -fx-border-color: black");
    }

    /**
     * Returns fxml background colour string based on the status of the incident.
     * Incomplete drafts - CRIMSON
     * Complete drafts - SANDYBROWN
     * Submitted reports - DARKGREEN
     * @return
     */
    private String getBackgroundColourBasedOnValue(String targetString) {
        switch(targetString) {
        case "Incomplete Draft":
            return "-fx-background-color:CRIMSON";
        case "Complete Draft":
            return "-fx-background-color:SANDYBROWN";
        case "Submitted":
            return "-fx-background-color:DARKGREEN";
        default:
            return "-fx-background-color:BLACK";
        }

    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        IncidentCard card = (IncidentCard) other;
        return id.getText().equals(card.id.getText())
                && incident.equals(card.incident);
    }
}

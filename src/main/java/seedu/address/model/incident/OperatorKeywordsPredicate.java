package seedu.address.model.incident;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.person.Name;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class OperatorKeywordsPredicate implements Predicate<Incident> {
    private final List<String> keywords = new ArrayList<>();

    public OperatorKeywordsPredicate(Name operatorKeywords) {
        this.keywords.add(operatorKeywords.toString());
    }

    @Override
    public boolean test(Incident incident) {
        return keywords
                .stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(incident.getOperator().getName().toString(),
                        keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof OperatorKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((OperatorKeywordsPredicate) other).keywords)); // state check
    }

    public String getPredicate() {
        return keywords.toString();
    }
}

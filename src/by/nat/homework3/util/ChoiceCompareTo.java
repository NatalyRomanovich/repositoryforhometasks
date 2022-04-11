package by.nat.homework3.util;

public enum ChoiceCompareTo {
    COMPARE_TO_BY_AUTHORS_SURNAME("Sort by author's surname"),
    COMPARE_TO_BY_AUTHORS_NAMES("Sort by author's name"),
    COMPARE_TO_BY_AUTHORS_MIDDLE_NAME("Sort by author's middle name");

    private String descriptionOfMethod;

    ChoiceCompareTo() {
    }

    ChoiceCompareTo(String descriptionOfMethod) {
        this.descriptionOfMethod = descriptionOfMethod;
    }

    public String getDescriptionOfMethod() {
        return descriptionOfMethod;
    }
}

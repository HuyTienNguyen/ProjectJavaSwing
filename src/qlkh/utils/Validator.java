package qlkh.utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import qlkh.entities.ValidatorItem;

/**
 * @author Sahan Dissanayake. (http://www.github.com/Disapamok);
 */
public class Validator {

    private Border defaultBorder = new JTextField().getBorder();
    private Border defaultBorder1 = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0);

    private Object ErrorComponent;
    private Map<String, String> errors = new HashMap<>();
    private int MIN = 1, MAX = 2;
    private boolean fails = false;
    private String fieldName = "field_name", ruleValue = "value";
    private static Map<String, String> errorMessages = new HashMap<>();
    private static List<ValidatorItem> listValidatorItem = new ArrayList<>();
    private static Border errorBorder = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0), 2);
    private static final String TYPES_INTEGER = "Integer";
    private static final String TYPES_FLOAT = "Float";
    private static final String TYPES_DOUBLE = "Double";
    private static final String RULE_MIN_NUMBER = "minNumber";
    private static final String RULE_MAX_NUMBER = "maxNumber";

    public Validator(List<ValidatorItem> items) throws Exception {
        for (ValidatorItem item : items) {
            String ruleString = item.getRule(), field = item.getName();
            Object component = item.getField();
            String[] rules = splitRules(ruleString);

            for (String rule : rules) {
                String ruleStr = getRule(rule), value = getValue(component);

                boolean ruleError = false;
                int ruleVal = 0;
                String typesCompare = "";

                switch (ruleStr) {
                    case "required":
                        ruleError = isNull(value);
                        break;
                    case "number":
                        ruleError = isntNumber(value);
                        break;
                    case TYPES_INTEGER:
                        ruleError = isntInteger(value);
                        break;
                    case TYPES_FLOAT:
                        ruleError = isntFloat(value);
                        break;
                    case TYPES_DOUBLE:
                        ruleError = isntDouble(value);
                        break;
                    case "min":
                        int min = ruleVal = getRuleValue(rule);
                        typesCompare = isComparisionNumber(rules, rule);
                        if (typesCompare.equals("")) {
                            ruleError = length(value, min, MIN);
                        } else {
                            ruleStr = RULE_MIN_NUMBER;
                            ruleError = compareWithTypes(value, min, typesCompare, MIN);
                        }
                        break;
                    case "max":
                        int max = ruleVal = getRuleValue(rule);
                        typesCompare = isComparisionNumber(rules, rule);
                        if (typesCompare.equals("")) {
                            ruleError = length(value, max, MAX);
                        } else {
                            ruleStr = RULE_MAX_NUMBER;
                            ruleError = compareWithTypes(value, max, typesCompare, MAX);
                        }
                        ruleError = length(value, max, MAX);
                        break;
                    case "regex":
                        String regexCode = getRegexValue(rule);
                        ruleError = isntRegex(value, regexCode);
                        break;
                    case "confirmed":
                     
                        // get the second item to confirm with the number one item
                     ValidatorItem   itemConfirm = getItemConfirm(items, item);
                        if (itemConfirm == null) {
                            ruleError = true;
                        } else {
                            Object itemObject = item.getField();
                            Object itemConfirmObject = itemConfirm.getField();
                            // get Error if the name of two object not match to each other
                            ruleError = isntConfirmedValue(getValue(itemObject), getValue(itemConfirmObject));
                        }
                        break;

                    default:
                        throw new Exception("Validation rule : " + rule + " is not supported yet.");
                }

                if (ruleError == true) {
                    fails = true;
                    String error = getMessage(ruleStr, field, ruleVal);
                    errors.put(getName(component), getMessage(ruleStr, field, ruleVal));
                    break;
                }
            }

        }
    }

    private String[] splitRules(String ruleString) {
        if (ruleString.contains("|")) {
            String[] solitted = ruleString.split("\\|");
            return solitted;
        }
        String[] defaultRule = {ruleString};
        return defaultRule;
    }

    private Border getErrorBorder() {
        return errorBorder;
    }

    public static void setErrorBorder(Border Border) {
        errorBorder = Border;
    }

    public Border getDefaultBorder() {
        return defaultBorder;
    }

    private static boolean isTextField(Object component) {
        return component.getClass() == JTextField.class;
    }

    private static boolean isCombo(Object component) {
        return component.getClass() == JComboBox.class;
    }

    private static boolean isPassField(Object component) {
        return component.getClass() == JPasswordField.class;
    }

    private static boolean isTextArea(Object component) {
        return component.getClass() == JTextArea.class;
    }

    private boolean isLabelComponent(Object component) {
        return component.getClass() == JLabel.class;
    }

    private boolean isNull(String value) {
        return (value == null || value.equals(""));
    }

    private boolean isntNumber(String value) {
        if (isNull(value)) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean length(String text, int lenght, int mode) {
        if (isNull(text)) {
            return false;
        }
        if (mode == MIN) {
            return text.length() < lenght;
        } else {
            return text.length() > lenght;
        }
    }

    private boolean compareWithTypes(String value, int min, String typeCompare, int mode) {
        if (isNull(value)) {
            return false;
        }
        switch (typeCompare) {
            case TYPES_INTEGER:
                try {
                    int number = Integer.parseInt(value);
                    return (mode == MIN ? number < min : number > min);
                } catch (Exception e) {
                    return true;
                }
            case TYPES_FLOAT:
                try {
                    float number = Float.parseFloat(value);
                    return (mode == MIN ? number < min : number > min);
                } catch (Exception e) {
                    return true;
                }
            case TYPES_DOUBLE:
                try {
                    double number = Double.parseDouble(value);
                    return (mode == MIN ? number < min : number > min);
                } catch (Exception e) {
                    return true;
                }

        }
        return false;
    }

    private boolean isntRegex(String value, String regexCode) {
        if (value.matches(regexCode)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isntInteger(String value) {
        if (isNull(value)) {
            return true;
        }
        try {
            Integer.parseInt(value);
            return false;
        } catch (NumberFormatException e) {
        }
        return true;

    }

    private boolean isntFloat(String value) {
        if (isNull(value)) {
            return true;
        }
        try {
            Float.parseFloat(value);
            return false;
        } catch (NumberFormatException e) {
        }
        return true;

    }

    private boolean isntDouble(String value) {
        if (isNull(value)) {
            return true;
        }
        try {
            Double.parseDouble(value);
            return false;
        } catch (NumberFormatException e) {
        }
        return true;

    }

    public boolean isFails() {
        return fails;
    }

    public boolean isPasses() {
        return !fails;
    }

    private String isComparisionNumber(String[] rules, String rule) {
        String types = "";
        for (String rule1 : rules) {
            if (rule1.equals(TYPES_INTEGER)) {
                types = TYPES_INTEGER;
                break;
            } else if (rule1.equals(TYPES_FLOAT)) {
                types = TYPES_FLOAT;
                break;
            } else if (rule1.equals(TYPES_DOUBLE)) {
                types = TYPES_DOUBLE;
                break;
            }
            if (rule1.equals(rule)) {
                types = "";
                break;
            }
        }
        return types;
    }

    private boolean isntConfirmedValue(String itemConfirm, String item) {

        if (itemConfirm.equals(item)) {
            return false;
        } else {
            return true;
        }
    }

    private ValidatorItem getItemConfirm(List<ValidatorItem> items, ValidatorItem item) {
        // get Name of second field to match with number 1 field
        String nameItemConfirm = item.getName() + "_confirmation";
        for (ValidatorItem item1 : items) {
            // if exists second field with name equals nameItemConfirm
            if (item1.getName().equals(nameItemConfirm)) {
                // return second field
                return item1;
            }
        }
        // return null
        return null;
    }

    private static JTextField getTextField(Object component) {
        return (JTextField) component;
    }

    private static JComboBox getCombo(Object component) {
        return (JComboBox) component;
    }

    private static JPasswordField getPwdField(Object component) {
        return (JPasswordField) component;
    }

    private static JTextArea getTextAreaField(Object component) {
        return (JTextArea) component;
    }

    private JLabel getTextLabel(Object component) {
        return (JLabel) component;
    }

    private String getRule(String rule) {
        return (rule.contains(":") ? rule.split(":")[0] : rule);
    }

    private int getRuleValue(String rule) throws Exception {
        if (isntNumber(rule) && rule.contains(":")) {
            return Integer.parseInt(rule.split(":")[1]);
        } else {
            throw new Exception("Validator rule '" + rule + "' required a correct integer value for the validation. Ex: " + rule + ":5.");
        }
    }

    private String getRegexValue(String rule) throws Exception {
        if (isntNumber(rule) == true && rule.contains(":") == true) {
            return rule.split(":")[1];
        } else {
            throw new Exception("Validator rule '" + rule + "' required a correct integer value for the validation. Ex: " + rule + ":5.");
        }
    }

    private void setBorder(Object component, boolean isError, String error) {
        if (ErrorComponent != component) {
            if (isTextField(component)) {
                getTextField(component).setBorder((isError) ? getErrorBorder() : getDefaultBorder());

            } else if (isLabelComponent(component)) {
                getTextLabel(component).setText((isError) ? error : "");
                getTextLabel(component).setForeground((isError) ? Color.red : Color.red);
            } else if (isCombo(component)) {
                getCombo(component).setBorder((isError) ? getErrorBorder() : getDefaultBorder());
            } else if (isPassField(component)) {
                getPwdField(component).setBorder((isError) ? getErrorBorder() : getDefaultBorder());
            }
        }
        if (isError) {
            ErrorComponent = component;
        }
    }

    private String getValue(Object component) throws Exception {
        String value = null;
        if (isTextField(component)) {
            value = getTextField(component).getText();
        } else if (isPassField(component)) {
            value = new String(getPwdField(component).getPassword());
        } else if (isCombo(component)) {
            value = getCombo(component).getSelectedItem().toString();
        } else if (isTextArea(component)) {
            value = getTextAreaField(component).getText();
        } else {
            throw new Exception("This component couldn't be validated.");
        }
        return value;
    }

    private Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public static void setErrorMessages(Map<String, String> errorMessages) {
        Validator.errorMessages = errorMessages;
    }

    public static List<ValidatorItem> setRules(List<Object> components, Map<String, String> mapRules) throws Exception {
        List<ValidatorItem> listItem = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : mapRules.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            // Create  a validatorItem if the component has declared inside its request

            for (Object obj : components) {
                if (key.equals(getName(obj))) {
                    listItem.add(new ValidatorItem(value, obj, getName(obj)));
                }
            }
        }
        return listItem;

    }

    private static String getName(Object component) throws Exception {
        String value = null;
        if (isTextField(component)) {
            value = getTextField(component).getName();
        } else if (isPassField(component)) {
            value = new String(getPwdField(component).getName());
        } else if (isCombo(component)) {
            value = getCombo(component).getName();
        } else if (isTextArea(component)) {
            value = getTextAreaField(component).getName();
        } else {
            throw new Exception("This component couldn't be validated.");
        }
        return value;
    }

    private Map<String, String> getDefaultMessages() {
        Map<String, String> map = new HashMap();
        map.put("required", "The " + fieldName + " is required.");
        map.put("min", "Minimum length for " + fieldName + " is " + ruleValue + ".");
        map.put("max", "Maximum length for " + fieldName + " is " + ruleValue + ".");
        map.put("confirmed", "The " + fieldName + " confirmation does not match.");
        map.put("minNumber", "Minimum Value for " + fieldName + " is " + ruleValue + ".");
        map.put("maxNumber", "Maximum Value for " + fieldName + " is " + ruleValue + ".");
        map.put("number", "Text must be a valid number for the " + fieldName + " field.");
        map.put("regex", "Text must be a valid pattern  for the " + fieldName + " field.");
        map.put(TYPES_INTEGER, "Please enter a Integer number in " + fieldName + " field.");
        map.put(TYPES_FLOAT, "Please enter a Float number in " + fieldName + " field.");
        map.put(TYPES_DOUBLE, "Please enter a Double number in  " + fieldName + " field.");

        return map;
    }

    private String getMessage(String rule, String field, int value) throws Exception {
        // Get List Responses if have message is declare in FormRequese
        Map<String, String> msgs = getErrorMessages().isEmpty() ? getDefaultMessages() : getErrorMessages();
        // Get List default message
        Map<String, String> defaultMessage = getDefaultMessages();
        // Get errResponses mesage
        String customErrorResponse = msgs.get(field + "." + rule);
        String defaultErrorResponse = defaultMessage.get(rule);
        String errResponse = "";
        // Assign value to error response
        errResponse = (isNull(customErrorResponse) == false ? customErrorResponse : defaultErrorResponse);
        if (isNull(errResponse)) {
            throw new Exception("No defined message for validation rule : " + rule + ".");
        }

        // Return  error Responses with replacing either not replacing name field
        return replaceShortcodes(errResponse, field, value);
    }

    private String replaceShortcodes(String pureMsg, String field, int value) {
        pureMsg = pureMsg.replaceAll(fieldName, field);
        pureMsg = pureMsg.replaceAll(ruleValue, value + "");
        return pureMsg;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}

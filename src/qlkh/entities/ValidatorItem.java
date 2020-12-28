package qlkh.entities;

/**
 * @author Sahan Dissanayake (Disapamok)
 * www.sahan.xyz
 * https://github.com/disapamok
 * https://twitter.com/disapamok
 */
public class ValidatorItem {

    private  String rule;
    private   Object component;
    private  String name;

    public ValidatorItem(String arg_rule, Object arg_component, String arg_name) {
        this.rule = arg_rule;
        this.component = arg_component;
        this.name = arg_name;
    }


    public ValidatorItem() {
        
    }   

    public ValidatorItem(Object component) {
        this.component = component;
    }

    
    public String getRule() {
        return this.rule;
    }

    public Object getField() {
        return this.component;
    }

    public String getName() {
        return this.name;
    }
}

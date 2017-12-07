package plantparent.core.utils.validation;

import org.apache.commons.lang3.StringUtils;

public class ApiParameterValidator {

    //TODO make this more elaborate
    private static final String LOCATION_PATTERN = "\\w*";

    public static boolean isValidLocation(String location){
        if(StringUtils.isEmpty(location)) return false;
        return location.matches(LOCATION_PATTERN);
    }
}

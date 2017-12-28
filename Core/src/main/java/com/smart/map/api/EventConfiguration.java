package com.smart.map.api;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class EventConfiguration extends Configuration {
    // TODO: implement service configuration
@NotEmpty
private String dateFormat;

public String getDateFormat() {
    return dateFormat;
}

}

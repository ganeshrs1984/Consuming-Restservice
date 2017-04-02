
package com.pricing.request.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "import_designation_description"
})
public class Handling {

    @JsonProperty("import_designation_description")
    private String importDesignationDescription;

    @JsonProperty("import_designation_description")
    public String getImportDesignationDescription() {
        return importDesignationDescription;
    }

    @JsonProperty("import_designation_description")
    public void setImportDesignationDescription(String importDesignationDescription) {
        this.importDesignationDescription = importDesignationDescription;
    }

}

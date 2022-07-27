package com.parata.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


/**
 * @author MFU
 * 8/23/2020
 */

@lombok.Data
@Builder
public class PPWidgets {

    @JsonProperty
    private String widgetId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String displayName;
    @JsonProperty
    private String machinePermissions;
    @JsonProperty
    private String lastActionDoneBy;
    @JsonProperty
    private String enabled;
    @JsonProperty
    private String lastActionDoneOn;
    @JsonProperty
    private String lastActionDone;

}








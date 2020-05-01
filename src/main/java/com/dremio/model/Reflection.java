package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reflection implements BaseModel {
    private String entityType = "reflection";
    private String datasetId;
    private String name;
    private boolean enabled;
    private String type;/*["AGGREGATION", "RAW"]*/
    private String partitionDistributionStrategy;/*["CONSOLIDATED", "STRIPED"]*/
    private String[] measureFields;
    private String[] displayFields;
    private String[] partitionFields;
    private String[] sortFields;
    private String[] dimensionFields;

}

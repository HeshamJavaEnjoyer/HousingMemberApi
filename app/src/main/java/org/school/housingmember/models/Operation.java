package org.school.housingmember.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operation {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("category_id")
    @Expose
    public String categoryId;
    @SerializedName("amount")
    @Expose
    public String amount;
    @SerializedName("details")
    @Expose
    public String details;
    @SerializedName("actor_id")
    @Expose
    public String actorId;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("actor")
    @Expose
    public Object actor;

}

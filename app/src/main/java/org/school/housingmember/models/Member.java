package org.school.housingmember.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("mobile")
    @Expose
    public String mobile;
    @SerializedName("national_number")
    @Expose
    public String nationalNumber;
    @SerializedName("family_members")
    @Expose
    public String familyMembers;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("token")
    @Expose
    public String token;
    @SerializedName("token_type")
    @Expose
    public String tokenType;
    @SerializedName("refresh_token")
    @Expose
    public String refreshToken;
    @SerializedName("image_url")
    @Expose
    public String imageUrl;
    @SerializedName("tower_name")
    @Expose
    public String towerName;

}


/*1
//public class Member {
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("email")
//    @Expose
//    public String email;
//    @SerializedName("mobile")
//    @Expose
//    public String mobile;
//    @SerializedName("national_number")
//    @Expose
//    public String nationalNumber;
//    @SerializedName("family_members")
//    @Expose
//    public String familyMembers;
//    @SerializedName("gender")
//    @Expose
//    public String gender;
//    @SerializedName("admin_id")
//    @Expose
//    public Integer adminId;
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("image_url")
//    @Expose
//    public String imageUrl;
//
//
*/
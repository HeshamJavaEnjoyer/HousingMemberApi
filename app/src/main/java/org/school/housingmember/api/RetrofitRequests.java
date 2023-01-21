package org.school.housingmember.api;

import org.school.housingmember.models.Advertisement;
import org.school.housingmember.models.BaseResponse;
import org.school.housingmember.models.Category;
import org.school.housingmember.models.Member;
import org.school.housingmember.models.Operation;
import org.school.housingmember.models.User;
import org.school.housingmember.models.special_respond.AuthResponse;
import org.school.housingmember.models.special_respond.PasswordChangeResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitRequests {
      /*Categories
        Operations
        Advertisements
        */
      @GET("advertisements")
      Call<BaseResponse<Advertisement>> GET_Advertisements_CALL();

    //THE GET REQUEST -------------------------------------
    /*-
    @GET("users")
    Call<BaseResponse<User>> GET_USERS_CALL();

     */

    @GET("categories")
    Call<BaseResponse<Category>> GET_CATEGORIES_CALL();
        /*2
    @GET("employees")
    Call<BaseResponse<Employee>> GET_EMPLOYEES_CALL();

 */

    @GET("operations")
    Call<BaseResponse<Operation>> GET_OPERATION_CALL();
    //--------------------------------------------------------------------------

//    //**################################THIS FOR USER
//    //CREATE REQUEST
//    @POST("users")
//    @Multipart
////    @FormUrlEncoded
//    Call<BaseResponse<User>> CREATE_USERS_FULL_CALL(@Part("name") String name, @Part("email") String email, @Part("mobile") String mobile, @Part("national_number") String national_number, @Part("family_members") int family_members, @Part("gender") char gender, @Part() MultipartBody.Part imagePart);
//
//    //UPDATE REQUEST -- !Path('id')! as parameter
//    @Multipart
//    @FormUrlEncoded
//    @POST("users/{id}")
//    Call<BaseResponse<User>> UPDATE_USERS_FULL_CALL(@Path("id") int id, @Field("name") String name, @Field("email") String email, @Field("mobile") String mobile, @Field("national_number") String national_number, @Field("family_members") int family_members, @Field("gender") char gender, @Part("image") MultipartBody.Part imagePart);
//
//    //here without editing the pic
//    @FormUrlEncoded
//    @POST("users/{id}")
//    Call<BaseResponse<User>> UPDATE_USERS_NO_PIC_CALL(@Path("id") int id, @Field("name") String name, @Field("email") String email, @Field("mobile") String mobile, @Field("national_number") String national_number, @Field("family_members") int family_members, @Field("gender") char gender);
//
//    //DELETE REQUEST this is to delete a user by it id
//    @DELETE("users/{id}")
//    Call<BaseResponse<User>> DELETE_USER_CALL(@Path("id") int id);
//
//    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


    //#######THIS FOR EMPLOYEES
    //#######THIS FOR CATEGORY
    //#######THIS FOR Operation

    //
    /*later
    @GET("categories")
    Call<BaseResponse<Category>> GET_CATEGORIES_CALL();

    @GET("employees")
    Call<BaseResponse<Employee>> GET_EMPLOYEES_CALL();

    @GET("operations")
    Call<BaseResponse<Operation>> GET_OPERATION_CALL();

 */


    //LOGIN REQUEST FOR ADMIN========================
    @FormUrlEncoded
    @POST("auth/login")
    Call<BaseResponse<Member>> POST_Login_Call(@Field("email") String email, @Field("password") String password);

    //Logout REQUEST===========WORKS
    @GET("auth/logout")
    Call<BaseResponse<Member>> GET_Logout();

    //**################################***PASSWORD THINGS
    @FormUrlEncoded
    @POST("auth/forget-password")
    Call<AuthResponse<User>> Post_Forget_password(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("auth/reset-password")
    Call<AuthResponse<User>> Post_Reset_password(@Field("mobile") String mobile, @Field("code") String code, @Field("password") String password, @Field("password_confirmation") String password_confirmation);


    //**##Now Change Password
    @FormUrlEncoded
    @POST("auth/change-password")
    Call<PasswordChangeResponse> POSTChangePassword(@Field("current_password") String current_password, @Field("new_password") String new_password, @Field("new_password_confirmation") String new_password_confirmation);
    //**********************************************************************************************************************************


}

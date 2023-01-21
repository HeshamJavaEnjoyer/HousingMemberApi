package org.school.housingmember.api.controllers;

import android.util.Log;

import androidx.annotation.NonNull;

import org.school.housingmember.Prefs.AppSharedPreferences;
import org.school.housingmember.api.controllers.manger.ApiBaseController;
import org.school.housingmember.api.controllers.manger.ApiController;
import org.school.housingmember.interfaces.ProcessCallback;
import org.school.housingmember.models.BaseResponse;
import org.school.housingmember.models.Member;
import org.school.housingmember.models.User;
import org.school.housingmember.models.special_respond.AuthResponse;
import org.school.housingmember.models.special_respond.PasswordChangeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
// STOPSHIP: 1/8/2023 => ✔✔✔
public class AuthApiController extends ApiBaseController {
    private static final String TAG = "AuthApiController";
    //lets make a singleton
    public AuthApiController() {
    }

    private static AuthApiController Instance;

    public static AuthApiController getInstance(){
        if (Instance == null) {
            Instance = new AuthApiController();
        }
        return Instance;
    }

    public void login(String email, String password, ProcessCallback callback){
        Call<BaseResponse<Member>> call = ApiController.getInstance().getRetrofitRequests().POST_Login_Call(email,password);
        call.enqueue(new Callback<BaseResponse<Member>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Member>> call, @NonNull Response<BaseResponse<Member>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AppSharedPreferences.getInstance().save(response.body().object);// here we save the Member and his token in our AppSharedPreferences ==>so we could use his token in the headers
                    Log.d("TAG", "onResponse() returned: " + response.body().object.name+" "+response.body().object.towerName);
                    callback.onSuccess(response.body().message);
                }else {
                   generalErrorMessage(response,callback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Member>> call, @NonNull Throwable throwable) {
                callback.onFailure("Something went wrong while login process");
            }
        });
    }

    public void logout(ProcessCallback processCallback){
        Call<BaseResponse<Member>> call = ApiController.getInstance().getRetrofitRequests().GET_Logout();
        call.enqueue(new Callback<BaseResponse<Member>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Member>> call, @NonNull Response<BaseResponse<Member>> response) {
                if ((response.isSuccessful() || (response.code() == 200 || response.code()== 401))){
                    AppSharedPreferences.getInstance().clear();
                    processCallback.onSuccess("Logged Out Successfully");
                }else {
                    generalErrorMessage(response,processCallback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Member>> call, @NonNull Throwable throwable) {
                processCallback.onFailure("Server Error 500");
            }
        });
    }


    //Password Authorization
    public void forget_password(String mobilePhone, ProcessCallback processCallback) {
        Log.d(TAG, "forget_password() mobilePhone returned: " + mobilePhone);
        Call<AuthResponse<User>> call = ApiController.getInstance().getRetrofitRequests().Post_Forget_password(mobilePhone);
        call.enqueue(new Callback<AuthResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse<User>> call, @NonNull Response<AuthResponse<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    processCallback.onSuccess("Done Your Mobile is Received =>" + response.body().message);
                } else {
                    generalErrorMessage(response,processCallback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AuthResponse<User>> call, @NonNull Throwable throwable) {
                processCallback.onFailure("ServerError 500");
                Log.d(TAG, "onFailure() called with: call = [" + call + "], throwable = [" + throwable + "]");
            }
        });
    }

    public void reset_password(String mobilePhone, String code, String newPass, String newPassConfirm, ProcessCallback processCallback) {
        Call<AuthResponse<User>> call = ApiController.getInstance().getRetrofitRequests().Post_Reset_password(mobilePhone, code, newPass, newPassConfirm);
        call.enqueue(new Callback<AuthResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse<User>> call, @NonNull Response<AuthResponse<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    processCallback.onSuccess("reset successfully =>" + response.body().message);
                } else {
                    generalErrorMessage(response,processCallback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AuthResponse<User>> call, @NonNull Throwable throwable) {
                processCallback.onFailure("ServerError 500");
            }
        });
    }

    public void change_password(String currentPass, String newPass, String newPassConfirm, ProcessCallback processCallback) {
        Call<PasswordChangeResponse> call = ApiController.getInstance().getRetrofitRequests().POSTChangePassword(currentPass, newPass, newPassConfirm);
        call.enqueue(new Callback<PasswordChangeResponse>() {
            @Override
            public void onResponse(@NonNull Call<PasswordChangeResponse> call, @NonNull Response<PasswordChangeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    processCallback.onSuccess("changed successfully =>" + response.body().message);
                } else {
                    generalErrorMessage(response,processCallback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PasswordChangeResponse> call, @NonNull Throwable throwable) {
                processCallback.onFailure("ServerError 500");
            }
        });
    }


}

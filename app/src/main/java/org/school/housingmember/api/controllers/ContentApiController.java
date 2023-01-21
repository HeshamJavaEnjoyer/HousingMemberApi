package org.school.housingmember.api.controllers;


import androidx.annotation.NonNull;
import org.school.housingmember.api.controllers.manger.ApiBaseController;
import org.school.housingmember.api.controllers.manger.ApiController;
import org.school.housingmember.interfaces.ListCallback;
import org.school.housingmember.models.Advertisement;
import org.school.housingmember.models.BaseResponse;
import org.school.housingmember.models.Category;
import org.school.housingmember.models.Operation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//almost like the Repository
public class ContentApiController extends ApiBaseController {
    //ApiBaseController have no great need yet

    private final ApiController apiController;

    public ContentApiController() {
        apiController = ApiController.getInstance();
    }


    //* ME CREATED A SINGLE TONE
    private static ContentApiController Instance;

    public static ContentApiController getInstance() {
        if (Instance == null) {
            Instance = new ContentApiController();
        }
        return Instance;
    }
    //* ME CREATED A SINGLE TONE

    // now with the act method to process fetching Data
    //-----------------------

    /*-
    public void getUsers(ListCallback<User> callback) {
        Call<BaseResponse<User>> call = apiController.getRetrofitRequests().GET_USERS_CALL();
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<User>> call, @NonNull Response<BaseResponse<User>> response) {
                if (response.code() == 200 && response.body() != null) {
                    callback.onSuccess(response.body().list); //the( var => list ) refer to whats in The BaseResponse
                } else {
                    generalErrorMessageForContent(response,callback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<User>> call, @NonNull Throwable t) {
                callback.onFailure("Something went wrong while fetching Data");
            }
        });
    }
    */

    public void getCategories(ListCallback<Category> callback) {
        Call<BaseResponse<Category>> call = apiController.getRetrofitRequests().GET_CATEGORIES_CALL();
        call.enqueue(new Callback<BaseResponse<Category>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Category>> call, @NonNull Response<BaseResponse<Category>> response) {
                if (response.code() == 200 && response.body() != null) {
                    callback.onSuccess(response.body().list); //the( var => list ) refer to whats in The BaseResponse
                } else {
                    generalErrorMessageForContent(response,callback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Category>> call, @NonNull Throwable t) {
                callback.onFailure("Something went wrong while fetching Data");
            }
        });
    }

    /*-
    public void getEmployees(ListCallback<Employee> callback) {
        Call<BaseResponse<Employee>> call = apiController.getRetrofitRequests().GET_EMPLOYEES_CALL();
        call.enqueue(new Callback<BaseResponse<Employee>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Employee>> call, @NonNull Response<BaseResponse<Employee>> response) {
                if (response.code() == 200 && response.body() != null) {
                    callback.onSuccess(response.body().list); //the( var => list ) refer to whats in The BaseResponse
                } else {
                    generalErrorMessageForContent(response,callback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Employee>> call, @NonNull Throwable throwable) {
                callback.onFailure("Something went wrong while fetching Data");
            }
        });
    }
    */

    public void getOperation(ListCallback<Operation> callback) {
        Call<BaseResponse<Operation>> call = apiController.getRetrofitRequests().GET_OPERATION_CALL();
        call.enqueue(new Callback<BaseResponse<Operation>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Operation>> call, @NonNull Response<BaseResponse<Operation>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().list);
                } else {
                    generalErrorMessageForContent(response,callback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Operation>> call, @NonNull Throwable throwable) {
                callback.onFailure("Something went wrong while fetching Data");
            }
        });
    }

    public void getAdvertisements(ListCallback<Advertisement> callback) {
        Call<BaseResponse<Advertisement>> call = apiController.getRetrofitRequests().GET_Advertisements_CALL();
        call.enqueue(new Callback<BaseResponse<Advertisement>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Advertisement>> call, @NonNull Response<BaseResponse<Advertisement>> response) {
                if (response.code() == 200 && response.body() != null) {
                    callback.onSuccess(response.body().list); //the( var => list ) refer to whats in The BaseResponse
                } else {
                    generalErrorMessageForContent(response,callback);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Advertisement>> call, @NonNull Throwable throwable) {
                callback.onFailure("Something went wrong while fetching Data statusCode :500");
            }
        });
    }

}

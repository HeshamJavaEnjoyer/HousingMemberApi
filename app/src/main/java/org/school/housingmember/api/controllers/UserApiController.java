package org.school.housingmember.api.controllers;


public class UserApiController {
    //let's create singleton

    private static UserApiController Instance;
    public UserApiController() {
    }

    public static synchronized UserApiController getInstance() {
        if (Instance == null) {
            Instance = new UserApiController();
        }
        return Instance;
    }

    private void doSom(){

    }
    /*=
    public void create_user(String name, String email, String mobile, String national_number, int family_members, char gender, byte[] imagePart, ProcessCallback processCallback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), imagePart);
        MultipartBody.Part file = MultipartBody.Part.createFormData("image", "image-file", requestBody);
        Call<BaseResponse<User>> call = ApiController.getInstance().getRetrofitRequests().CREATE_USERS_FULL_CALL(name, email, mobile, national_number, family_members, gender, file);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<User>> call, @NonNull Response<BaseResponse<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    processCallback.onSuccess("user created successfully " + response.body().message);
                } else {
                    if (response.body() != null){
                        Log.i("TAG", "onResponse: "+response.body().message + "=> "+response.body().status);
                    }
                    processCallback.onFailure("failed to create a new user!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<User>> call, @NonNull Throwable throwable) {
                processCallback.onFailure("something went wrong!");
            }
        });
    }

    public void update_user(int id , String name, String email, String mobile, String national_number, int family_members, char gender, byte[] imagePart, ProcessCallback processCallback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), imagePart);
        MultipartBody.Part file = MultipartBody.Part.createFormData("image", "image-file", requestBody);
        Call<BaseResponse<User>> call = ApiController.getInstance().getRetrofitRequests().UPDATE_USERS_FULL_CALL(id,name,email,mobile,national_number,family_members,gender,file);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<User>> call, @NonNull Response<BaseResponse<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    processCallback.onSuccess("updated successfully =>"+response.body().message);
                } else {
                    processCallback.onFailure("failed to update user!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<User>> call, @NonNull Throwable throwable) {
                processCallback.onFailure("something went wrong!");
            }
        });
    }

    public void update_user_no_pic(int id , String name, String email, String mobile, String national_number, int family_members, char gender, ProcessCallback processCallback) {
        Call<BaseResponse<User>> call = ApiController.getInstance().getRetrofitRequests().UPDATE_USERS_NO_PIC_CALL(id,name,email,mobile,national_number,family_members,gender);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<User>> call, @NonNull Response<BaseResponse<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    processCallback.onSuccess("updated successfully =>"+response.body().message);
                } else {
                    processCallback.onFailure("failed to update user!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<User>> call, @NonNull Throwable throwable) {
                processCallback.onFailure("something went wrong!");
            }
        });
    }

    public void delete_user(int id, ProcessCallback callback) {
        Call<BaseResponse<User>> call = ApiController.getInstance().getRetrofitRequests().DELETE_USER_CALL(id);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<User>> call, @NonNull Response<BaseResponse<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess("user deleted successfully =>"+response.body().message);
                } else {
                    callback.onFailure("failed to delete user!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<User>> call, @NonNull Throwable throwable) {
                callback.onFailure("something went wrong!");
            }
        });
    }

 */
}

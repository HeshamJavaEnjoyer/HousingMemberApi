package org.school.housingmember.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.snackbar.Snackbar;

import org.school.housingmember.R;
import org.school.housingmember.ad_dialog.AdInfoDialog;
import org.school.housingmember.adapters.adv_adapter.AdvertisementAdapter;
import org.school.housingmember.adapters.category_adapter.CategoryAdapter;
import org.school.housingmember.api.controllers.AuthApiController;
import org.school.housingmember.api.controllers.ContentApiController;
import org.school.housingmember.enums.DialogType;
import org.school.housingmember.interfaces.ListCallback;
import org.school.housingmember.interfaces.ProcessCallback;
import org.school.housingmember.logout_tools.DialogListener;
import org.school.housingmember.logout_tools.LogoutDialog;
import org.school.housingmember.models.Advertisement;
import org.school.housingmember.models.Category;
import org.school.housingmember.views.password_form.PasswordActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogListener {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView_adv,recyclerView_categories;
    private AdvertisementAdapter advertisementAdapter;
    private CategoryAdapter categoryAdapter;

    private View view_badInternet;
    private CircularProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        inti();
        setupAdvertisementAdapterRec();
        setupCategoriesAdapterRec();
    }

    private void setupAdvertisementAdapterRec() {
        ContentApiController.getInstance().getAdvertisements(new ListCallback<Advertisement>() {
            @Override
            public void onSuccess(List<Advertisement> list) {
                view_badInternet.setVisibility(View.INVISIBLE);
                progressIndicator.setVisibility(View.INVISIBLE);

                advertisementAdapter = new AdvertisementAdapter(list);
                advertisementAdapter.setRvClickListener(ad_info -> AdInfoDialog.newInstance(ad_info).show(getSupportFragmentManager(), "Ad-Info"));
                recyclerView_adv.setAdapter(advertisementAdapter);
                Log.d(TAG, "onSuccess() called with: list Size = [" + list.size() + "]");
            }

            @Override
            public void onFailure(String message) {
                view_badInternet.setVisibility(View.VISIBLE);
                progressIndicator.setVisibility(View.VISIBLE);

                Log.d(TAG, "onFailure() returned: " + message);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupCategoriesAdapterRec() {
        ContentApiController.getInstance().getCategories(new ListCallback<Category>() {
            @Override
            public void onSuccess(List<Category> list) {
                view_badInternet.setVisibility(View.INVISIBLE);
                progressIndicator.setVisibility(View.INVISIBLE);

                categoryAdapter = new CategoryAdapter(list);
//                advertisementAdapter.setRvClickListener(ad_info -> AdInfoDialog.newInstance(ad_info).show(getSupportFragmentManager(), "Ad-Info"));
                recyclerView_categories.setAdapter(categoryAdapter);
                Log.d(TAG, "onSuccess() called with: list Size = [" + list.size() + "]");
            }

            @Override
            public void onFailure(String message) {
                view_badInternet.setVisibility(View.VISIBLE);
                progressIndicator.setVisibility(View.VISIBLE);

                Log.d(TAG, "onFailure() returned: " + message);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void inti() {
        findViews();
    }

    private void findViews() {
        recyclerView_adv = findViewById(R.id.recycler_adv);
        registerForContextMenu(recyclerView_adv);

        recyclerView_categories = findViewById(R.id.recycler_categories);

        view_badInternet = findViewById(R.id.view_badInternet);
        progressIndicator = findViewById(R.id.progressBar_loading);
    }
    /*0
    private void callTest() {
        testGetCategory();
        testGetOperation();
    }

    //**Test Data
    private void testGetCategory() {
        ContentApiController.getInstance().getCategories(new ListCallback<Category>() {
            @Override
            public void onSuccess(List<Category> list) {
                Log.i(TAG, "onSuccess: category=>");
                Log.d(TAG, "onSuccess() returned: " + list.size());
            }

            @Override
            public void onFailure(String message) {
                Log.d(TAG, "respond() returned: " + message);
            }
        });
    }

    private void testGetOperation() {
        ContentApiController.getInstance().getOperation(new ListCallback<Operation>() {
            @Override
            public void onSuccess(List<Operation> list) {
                Log.i(TAG, "onSuccess: operation=>");
                Log.d(TAG, "onSuccess() returned: " + list.size());
            }

            @Override
            public void onFailure(String message) {
                Log.d(TAG, "respond() returned: " + message);
            }
        });
    }
    */

    //**THE logout Section----------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                new LogoutDialog().show(getSupportFragmentManager(), "Logout");
                break;
            case R.id.menu_Password:
                startActivity(new Intent(this, PasswordActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //ContextMenu ---------TEST---------------------------------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_context_toast:
                Toast.makeText(this, "This Item Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit_app:
                finish();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void logout() {
        AuthApiController.getInstance().logout(new ProcessCallback() {
            @Override
            public void onSuccess(String message) {
                //performLogout and move to login
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

            @Override
            public void onFailure(String massage) {
                Snackbar.make(findViewById(R.id.snackBar_action), massage, Snackbar.LENGTH_LONG).setAction("Try Again", view -> logout()).show();
            }
        });
    }

    @Override
    public void onConfirmClicked(DialogType dialogType) {
        switch (dialogType) {
            case Logout:
                logout();
                break;
            case AdInfo:
                Log.d(TAG, "onConfirmClicked() called with: dialogType = [" + dialogType + "]");
                break;
        }
    }
}
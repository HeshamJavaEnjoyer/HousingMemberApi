package org.school.housingmember.ad_dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.school.housingmember.R;
import org.school.housingmember.enums.DialogType;
import org.school.housingmember.logout_tools.DialogListener;

public class AdInfoDialog extends DialogFragment {
    private DialogListener dialogListener;
    private Button btn_dialog_submit;

    private TextView tv_text_for_AdInfo;

    private static final String ARG_INFO_TEXT = "INFOText";

    private String textInfoForAd;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            dialogListener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context
                    + " must implement DialogListener ");
        }
    }

    public AdInfoDialog() {
    }

    public static AdInfoDialog newInstance(String info) {
        AdInfoDialog fragment = new AdInfoDialog();
        Bundle args = new Bundle();
        args.putString(ARG_INFO_TEXT, info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //test
            Bundle bundle = getArguments();
            textInfoForAd = bundle.getString(ARG_INFO_TEXT);
        } else {
            Log.i("RiddleDialog", "onCreate: theArgumentsAreEmpty");
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.setCancelable(false);
        new Handler().postDelayed(this::dismiss,4950);
        // for inflating and finds ids
        View view = findViews(inflater, container);
        //setting the hint into the dialog % the hint came from the newInstance from this Class
        tv_text_for_AdInfo.setText(textInfoForAd);
        //when btn inside dialog is clicked == will run my custom listener "okay_btn_listener" AND dismiss();
        btn_dialog_submit.setOnClickListener(view1 -> {
            if (dialogListener != null) {
                //its okay i called this method for getting faster (i should have created another one)
                dialogListener.onConfirmClicked(DialogType.AdInfo);
                dismiss();
            }
        });
        return view;
    }
    // Inflate the layout for this fragment
    @SuppressLint("MissingInflatedId")
    private View findViews(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.dialog_ad_info, container, false);
        tv_text_for_AdInfo = view.findViewById(R.id.dialog_title);
        btn_dialog_submit = view.findViewById(R.id.btn_dialog_okay);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dialogListener = null;
    }
}

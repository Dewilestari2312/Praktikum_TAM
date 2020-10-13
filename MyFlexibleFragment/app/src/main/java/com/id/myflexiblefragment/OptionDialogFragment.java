package com.id.myflexiblefragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.id.myflexiblefragment.R.id.rb_Bts;

public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{
private Button btnChoose, btnClose;
private RadioGroup rgOptions;
private RadioButton rbexo, rbBts, rbsrj, rbnct;
private OnOptionDialogListener onOptionDialogListener;
public OptionDialogFragment() {
        // Required empty public constructor
        }
public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
        }
public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
        }
public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button)view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button)view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = (RadioGroup)view.findViewById(R.id.rg_options);
        rbexo = (RadioButton)view.findViewById(R.id.rb_exo);
        rbBts = (RadioButton)view.findViewById(rb_Bts);
        rbsrj = (RadioButton)view.findViewById(R.id.rb_srj);
        rbnct = (RadioButton)view.findViewById(R.id.rb_nct);
        return view;
        }
@Override
public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    String coach = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_exo:
                            coach = rbexo.getText().toString().trim();
                            break;
                        case rb_Bts:
                            coach = rbBts.getText().toString().trim();
                            break;
                        case R.id.rb_srj:
                            coach = rbsrj.getText().toString().trim();
                            break;
                        case R.id.rb_nct:
                            coach = rbnct.getText().toString().trim();
                            break;
                        }
                    getOnOptionDialogListener().onOptionChoosen(coach);
                    getDialog().cancel();
                    }
                break;
            }
        }
public interface OnOptionDialogListener{
void onOptionChoosen(String text);
}
}
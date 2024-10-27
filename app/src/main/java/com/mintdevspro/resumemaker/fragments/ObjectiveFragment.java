package com.mintdevspro.resumemaker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.mintdevspro.resumemaker.CreateCVActivity;
import com.mintdevspro.resumemaker.interfaces.ObjectCallback;
import com.mintdevspro.resumemaker.db.ObjectiveDBHandler;
import com.mintdevspro.resumemaker.R;
import com.mintdevspro.resumemaker.models.ObjectiveModel;

import java.util.ArrayList;

public class ObjectiveFragment extends Fragment {
    private ObjectiveDBHandler dbHandler;
    EditText edtObj;
    LinearLayout linearLayout_obj;
    String objObeective;
    ArrayList<ObjectiveModel> objectiveModelArrayList;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_objective_, viewGroup, false);

        CreateCVActivity.viewPager.setSwipeEnabled(false);
        this.edtObj = (EditText) inflate.findViewById(R.id.cvobj_id);
        this.objectiveModelArrayList = new ArrayList<>();
        ObjectiveDBHandler objectiveDBHandler = new ObjectiveDBHandler(getContext());
        this.dbHandler = objectiveDBHandler;
        this.objectiveModelArrayList = objectiveDBHandler.readCourses();
        this.linearLayout_obj = (LinearLayout) inflate.findViewById(R.id.ly_editcv);
        this.edtObj.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ObjectiveFragment.this.linearLayout_obj.setBackgroundResource(R.drawable.objectbg);
                } else {
                    ObjectiveFragment.this.linearLayout_obj.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        gettingInformationFromObjectFragment();
        return inflate;
    }

    private void gettingInformationFromObjectFragment() {

        ((CreateCVActivity) requireActivity()).passMsgToObjectFrag(new ObjectCallback() {
            @Override
            public void callback(boolean z) {
                if (edtObj.getText().toString().trim().length() == 0) {
                    CreateCVActivity.isFilled = false;
                    return;
                }
                insert(objectiveModelArrayList);
                CreateCVActivity.isFilled = true;
            }
        });

    }

    public void onResume() {
        super.onResume();
        if (this.objectiveModelArrayList.size() > 0) {
            this.edtObj.setText(this.objectiveModelArrayList.get(0).getCvobective());
        }
    }

    public void insert(ArrayList<ObjectiveModel> arrayList) {
        if (this.dbHandler.getDataCount() > 0) {
            String cvobective = this.dbHandler.readCourses().get(0).getCvobective();
            this.objObeective = cvobective;
            this.dbHandler.updateCourse(cvobective, this.edtObj.getText().toString());
            return;
        }
        String obj = this.edtObj.getText().toString();
        this.objObeective = obj;
        this.dbHandler.addNewCourse(obj);
        this.edtObj.setText("");
    }
}

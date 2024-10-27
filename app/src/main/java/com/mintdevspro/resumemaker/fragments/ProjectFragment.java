package com.mintdevspro.resumemaker.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mintdevspro.resumemaker.CreateCVActivity;
import com.mintdevspro.resumemaker.ProjectAdapter;
import com.mintdevspro.resumemaker.db.ProjectDBHandler;
import com.mintdevspro.resumemaker.R;
import com.mintdevspro.resumemaker.models.ProjectRecylerviewModel;

import java.util.ArrayList;

public class ProjectFragment extends Fragment {
    ImageView addSkill;
    Dialog dialog;
    EditText edt_ProjectNameOne;
    EditText edt_ProjectNameTwo;
    EditText edt_ProjectUrlOne;
    EditText edt_ProjectUrlTwo;
    ImageView ivDelete;
    ImageView ivSaved;
    LinearLayout layoutSkills;
    LinearLayout linearLayout_projectOne;
    LinearLayout linearLayout_projectTwo;
    LinearLayout linearLayout_projecturlone;
    LinearLayout linearLayout_projecturltwo;
    ArrayList<ProjectRecylerviewModel> list;
    ProjectAdapter projectAdapter;
    ProjectDBHandler projectDBHandler;
    String projectOneName;
    String projectOneUrl;
    String projectTwoName;
    String projectTwoUrl;
    RecyclerView skill_recyclerView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_project, viewGroup, false);
        this.skill_recyclerView = (RecyclerView) inflate.findViewById(R.id.recyler_proj);
        CreateCVActivity.viewPager.setSwipeEnabled(false);
        this.list = new ArrayList<>();
        ProjectDBHandler projectDBHandler2 = new ProjectDBHandler(getContext());
        this.projectDBHandler = projectDBHandler2;
        this.list = projectDBHandler2.readCourses();
        this.skill_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ProjectAdapter projectAdapter2 = new ProjectAdapter(getContext(), this.list);
        this.projectAdapter = projectAdapter2;
        projectAdapter2.notifyDataSetChanged();
        this.skill_recyclerView.setAdapter(this.projectAdapter);
        this.ivSaved = (ImageView) inflate.findViewById(R.id.id_save_skill);
        this.addSkill = (ImageView) inflate.findViewById(R.id.addskills);
        this.layoutSkills = (LinearLayout) inflate.findViewById(R.id.lymainSkills_id);
        this.linearLayout_projectOne = (LinearLayout) inflate.findViewById(R.id.lyprojectfirsttitle);
        this.linearLayout_projecturlone = (LinearLayout) inflate.findViewById(R.id.ly_projectFirsturl);
        this.linearLayout_projectTwo = (LinearLayout) inflate.findViewById(R.id.lyprojectsecondname);
        this.linearLayout_projecturltwo = (LinearLayout) inflate.findViewById(R.id.lyprojectsecondurl);
        this.edt_ProjectNameOne = (EditText) inflate.findViewById(R.id.projNem_one_id);
        this.edt_ProjectUrlOne = (EditText) inflate.findViewById(R.id.projUrl_one_id);
        this.edt_ProjectNameTwo = (EditText) inflate.findViewById(R.id.proj_Name_id);
        this.edt_ProjectUrlTwo = (EditText) inflate.findViewById(R.id.projUrlTwo_id);
        this.edt_ProjectNameOne.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ProjectFragment.this.linearLayout_projectOne.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    ProjectFragment.this.linearLayout_projectOne.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.edt_ProjectUrlOne.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ProjectFragment.this.linearLayout_projecturlone.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    ProjectFragment.this.linearLayout_projecturlone.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.edt_ProjectNameTwo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ProjectFragment.this.linearLayout_projectTwo.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    ProjectFragment.this.linearLayout_projectTwo.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.edt_ProjectUrlTwo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ProjectFragment.this.linearLayout_projecturltwo.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    ProjectFragment.this.linearLayout_projecturltwo.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.addSkill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProjectFragment.this.layoutSkills.setVisibility(0);
            }
        });
        this.ivSaved.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ProjectFragment.this.edt_ProjectNameOne.getText().toString().trim().length() == 0 || ProjectFragment.this.edt_ProjectUrlOne.getText().toString().trim().length() == 0 || ProjectFragment.this.edt_ProjectNameTwo.getText().toString().trim().length() == 0 || ProjectFragment.this.edt_ProjectUrlTwo.getText().toString().trim().length() == 0) {
                    Toast.makeText(ProjectFragment.this.getActivity(), "Please provide your information", 0).show();
                    return;
                }
                ProjectFragment project_Fragment = ProjectFragment.this;
                project_Fragment.projectOneName = project_Fragment.edt_ProjectNameOne.getText().toString();
                ProjectFragment project_Fragment2 = ProjectFragment.this;
                project_Fragment2.projectOneUrl = project_Fragment2.edt_ProjectUrlOne.getText().toString();
                ProjectFragment project_Fragment3 = ProjectFragment.this;
                project_Fragment3.projectTwoName = project_Fragment3.edt_ProjectNameTwo.getText().toString();
                ProjectFragment project_Fragment4 = ProjectFragment.this;
                project_Fragment4.projectTwoUrl = project_Fragment4.edt_ProjectUrlTwo.getText().toString();
                ProjectFragment.this.edt_ProjectNameOne.setText("");
                ProjectFragment.this.edt_ProjectUrlOne.setText("");
                ProjectFragment.this.edt_ProjectNameTwo.setText("");
                ProjectFragment.this.edt_ProjectUrlTwo.setText("");
                ProjectFragment.this.layoutSkills.setVisibility(8);
                ProjectFragment.this.projectDBHandler.addNewCourse(ProjectFragment.this.projectOneName, ProjectFragment.this.projectOneUrl, ProjectFragment.this.projectTwoName, ProjectFragment.this.projectTwoUrl);
                ProjectFragment project_Fragment5 = ProjectFragment.this;
                project_Fragment5.list = project_Fragment5.projectDBHandler.readCourses();
                ProjectFragment.this.skill_recyclerView.setLayoutManager(new LinearLayoutManager(ProjectFragment.this.getContext()));
                ProjectFragment.this.projectAdapter = new ProjectAdapter(ProjectFragment.this.getContext(), ProjectFragment.this.list);
                ProjectFragment.this.projectAdapter.notifyDataSetChanged();
                ProjectFragment.this.skill_recyclerView.setAdapter(ProjectFragment.this.projectAdapter);
            }
        });
        return inflate;
    }
}

package com.mintdevspro.resumemaker.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mintdevspro.resumemaker.CreateCVActivity;
import com.mintdevspro.resumemaker.R;
import com.mintdevspro.resumemaker.SkillAdapter;
import com.mintdevspro.resumemaker.db.SkillDBHandler;
import com.mintdevspro.resumemaker.models.SkillRecylerviewModel;

import java.util.ArrayList;

public class SkillsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    String SkillFourth;
    String SkillThree;
    ImageView addSkill;
    Dialog dialog;
    EditText edt_KillTwo;
    EditText edt_SkillFifth;
    EditText edt_SkillFourth;
    EditText edt_SkillOne;
    EditText edt_SkillThree;
    ImageView ivDelete;
    ImageView ivSaved;
    LinearLayout linearLayout_skill1;
    LinearLayout linearLayout_skill2;
    LinearLayout linearLayout_skill3;
    LinearLayout linearLayout_skill4;
    ArrayList<SkillRecylerviewModel> list;
    LinearLayout lySkills;
    SkillAdapter skillAdapter;
    SkillDBHandler skillDBHandler;
    String skillFifth;
    String skillOne;
    String skillTwo;
    RecyclerView skill_recyclerView;
    String[] skillsLevel = {"Beginner", "Intermediate", "Expert"};
    Spinner spin;
    Spinner spin2;
    Spinner spin3;
    Spinner spin4;

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_skills_, viewGroup, false);

        CreateCVActivity.viewPager.setSwipeEnabled(false);
        this.skill_recyclerView = (RecyclerView) inflate.findViewById(R.id.recyler_skill);
        this.list = new ArrayList<>();
        SkillDBHandler skillDBHandler2 = new SkillDBHandler(getContext());
        this.skillDBHandler = skillDBHandler2;
        this.list = skillDBHandler2.readCourses();
        this.skillAdapter = new SkillAdapter(getContext(), this.list);
        this.skill_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.skillAdapter.notifyDataSetChanged();
        this.skill_recyclerView.setAdapter(this.skillAdapter);
        this.ivSaved = (ImageView) inflate.findViewById(R.id.id_save_skill);
        this.spin = (Spinner) inflate.findViewById(R.id.spinner);
        this.spin2 = (Spinner) inflate.findViewById(R.id.spinner2);
        this.spin3 = (Spinner) inflate.findViewById(R.id.spinner3);
        this.spin4 = (Spinner) inflate.findViewById(R.id.spinner4);
        this.spin.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), 17367048, this.skillsLevel);
        arrayAdapter.setDropDownViewResource(17367049);
        this.spin.setAdapter(arrayAdapter);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(), 17367048, this.skillsLevel);
        arrayAdapter2.setDropDownViewResource(17367049);
        this.spin2.setAdapter(arrayAdapter2);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(getContext(), 17367048, this.skillsLevel);
        arrayAdapter3.setDropDownViewResource(17367049);
        this.spin3.setAdapter(arrayAdapter3);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(getContext(), 17367048, this.skillsLevel);
        arrayAdapter4.setDropDownViewResource(17367049);
        this.spin4.setAdapter(arrayAdapter4);
        this.addSkill = (ImageView) inflate.findViewById(R.id.addskills);
        this.lySkills = (LinearLayout) inflate.findViewById(R.id.lymainSkills);
        this.linearLayout_skill1 = (LinearLayout) inflate.findViewById(R.id.lyskillone);
        this.linearLayout_skill2 = (LinearLayout) inflate.findViewById(R.id.lyskilltwo);
        this.linearLayout_skill3 = (LinearLayout) inflate.findViewById(R.id.lyskillthree);
        this.linearLayout_skill4 = (LinearLayout) inflate.findViewById(R.id.lyskillfourth);
        this.edt_SkillOne = (EditText) inflate.findViewById(R.id.skills_one_id);
        this.edt_KillTwo = (EditText) inflate.findViewById(R.id.skill_two_id);
        this.edt_SkillThree = (EditText) inflate.findViewById(R.id.skill_three_id);
        this.edt_SkillFourth = (EditText) inflate.findViewById(R.id.skill_fourth_id);
        this.edt_SkillOne.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SkillsFragment.this.linearLayout_skill1.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    SkillsFragment.this.linearLayout_skill1.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.edt_KillTwo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SkillsFragment.this.linearLayout_skill2.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    SkillsFragment.this.linearLayout_skill2.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.edt_SkillThree.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SkillsFragment.this.linearLayout_skill3.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    SkillsFragment.this.linearLayout_skill3.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.edt_SkillFourth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SkillsFragment.this.linearLayout_skill4.setBackgroundResource(R.drawable.ivinputbg);
                } else {
                    SkillsFragment.this.linearLayout_skill4.setBackgroundResource(R.drawable.ivbg_recyl);
                }
            }
        });
        this.skillDBHandler = new SkillDBHandler(getContext());
        this.addSkill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SkillsFragment.this.lySkills.setVisibility(0);
            }
        });
        this.ivSaved.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SkillsFragment.this.edt_SkillOne.getText().toString().trim().length() == 0 || SkillsFragment.this.edt_KillTwo.getText().toString().trim().length() == 0 || SkillsFragment.this.edt_SkillThree.getText().toString().trim().length() == 0 || SkillsFragment.this.edt_SkillFourth.getText().toString().trim().length() == 0) {
                    Toast.makeText(SkillsFragment.this.getActivity(), "Please provide your information", 0).show();
                    return;
                }
                SkillsFragment skills_Fragment = SkillsFragment.this;
                skills_Fragment.skillOne = skills_Fragment.edt_SkillOne.getText().toString();
                SkillsFragment skills_Fragment2 = SkillsFragment.this;
                skills_Fragment2.skillTwo = skills_Fragment2.edt_KillTwo.getText().toString();
                SkillsFragment skills_Fragment3 = SkillsFragment.this;
                skills_Fragment3.SkillThree = skills_Fragment3.edt_SkillThree.getText().toString();
                SkillsFragment skills_Fragment4 = SkillsFragment.this;
                skills_Fragment4.SkillFourth = skills_Fragment4.edt_SkillFourth.getText().toString();
                SkillsFragment.this.edt_SkillOne.setText("");
                SkillsFragment.this.edt_KillTwo.setText("");
                SkillsFragment.this.edt_SkillThree.setText("");
                SkillsFragment.this.edt_SkillFourth.setText("");
                SkillsFragment.this.lySkills.setVisibility(8);
                SkillsFragment.this.skillDBHandler.addNewCourse(SkillsFragment.this.skillOne, SkillsFragment.this.skillTwo, SkillsFragment.this.SkillThree, SkillsFragment.this.SkillFourth, SkillsFragment.this.spin.getSelectedItem().toString(), SkillsFragment.this.spin2.getSelectedItem().toString(), SkillsFragment.this.spin3.getSelectedItem().toString(), SkillsFragment.this.spin4.getSelectedItem().toString());
                SkillsFragment skills_Fragment5 = SkillsFragment.this;
                skills_Fragment5.list = skills_Fragment5.skillDBHandler.readCourses();
                SkillsFragment.this.skill_recyclerView.setLayoutManager(new LinearLayoutManager(SkillsFragment.this.getContext()));
                SkillsFragment.this.skillAdapter = new SkillAdapter(SkillsFragment.this.getContext(), SkillsFragment.this.list);
                SkillsFragment.this.skillAdapter.notifyDataSetChanged();
                SkillsFragment.this.skill_recyclerView.setAdapter(SkillsFragment.this.skillAdapter);
            }
        });
        return inflate;
    }
}

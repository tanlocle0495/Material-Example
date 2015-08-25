package com.example.loc.water_body.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.loc.water_body.Dao_Data.Dao_UserInfomation;
import com.example.loc.water_body.Model.UserInformation_Model;
import com.example.loc.water_body.R;
import com.example.loc.water_body.Navigation.Main_Navigattion;
import com.gc.materialdesign.views.CheckBox;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.DecimalFormat;

public class User_Information extends ActionBarActivity implements View.OnClickListener, CheckBox.OnCheckListener {

    private MaterialEditText edtUserName, edtWater, edtWeight;
    private RadioGroup radioGroup;
    private RadioButton Radiakg, Radialbs;
    CheckBox chkSport, chkSunny;
    DecimalFormat NumFormat = new DecimalFormat("#.##");
    UserInformation_Model UserInformation;

    public MaterialEditText findMaterialEDitText(int id) {
        return (MaterialEditText) findViewById(id);
    }

    Dao_UserInfomation UserDaoInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        setSupportActionBar((Toolbar) findViewById(R.id.mtoolBar));
        getSupportActionBar().setTitle("Information");

        UserDaoInformation = new Dao_UserInfomation(this);
        UserInformation = new UserInformation_Model();
        edtUserName = findMaterialEDitText(R.id.edtuserName);
        edtWater = findMaterialEDitText(R.id.edtWater);
        edtWeight = findMaterialEDitText(R.id.edtWeight);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Radiakg = (RadioButton) findViewById(R.id.radiakg);
        chkSunny = (CheckBox) findViewById(R.id.checkSunny);
        chkSport = (CheckBox) findViewById(R.id.checkSport);
        Radialbs = (RadioButton) findViewById(R.id.radiaolbs);

        Button btnUserLoginDone = (Button) findViewById(R.id.btnUserLoginDone);

        edtWater.setEnabled(!edtWater.isEnabled());
        edtWater.setText("00");

        this.setSelectEditext();
        setRadiaocheck();
        chkSunny.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(boolean b) {
                if (!(edtWeight.getText().toString()).trim().equalsIgnoreCase("")) {
                    String Sweight = edtWeight.getText().toString();

                    if (Radiakg.isChecked()) {
                        Log.e("CheckerKG: ", String.valueOf(SetLengghtKg()));
                        if (SetLengghtKg() == true) {
                            double dweight = (Double.parseDouble(Sweight) * 33) + setIdStateSport() + setIdStateSunny();
                            edtWater.setText(NumFormat.format(dweight));
                        } else {
                            edtWeight.setError("Value max");
                        }
                    } else {
                        Log.e("checkerLBS: ", String.valueOf(SetLengghtlbs()));
                        if (SetLengghtlbs() == true) {
                            double dweight = ((Double.parseDouble(Sweight) * 33) / 2.2) + setIdStateSport() + setIdStateSunny();
                            edtWater.setText(NumFormat.format(dweight));
                        } else {
                            edtWeight.setError("Value max1");
                        }
                    }


                }


            }
        });
        chkSport.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(boolean b) {

                if (!(edtWeight.getText().toString()).trim().equalsIgnoreCase("")) {
                    String Sweight = edtWeight.getText().toString();
                    if (Radiakg.isChecked()) {


                        Log.e("CheckerKG: ", String.valueOf(SetLengghtKg()));
                        if (SetLengghtKg() == true) {

                            double dweight = (Double.parseDouble(Sweight) * 33) + setIdStateSport() + setIdStateSunny();
                            edtWater.setText(NumFormat.format(dweight));
                        } else {
                            edtWeight.setError("Value max");
                        }
                    } else {
                        Log.e("checkerLBS: ", String.valueOf(SetLengghtlbs()));
                        if (SetLengghtlbs() == true) {
                            double dweight = ((Double.parseDouble(Sweight) * 33) / 2.2) + setIdStateSport() + setIdStateSunny();
                            edtWater.setText(NumFormat.format(dweight));
                        } else {
                            edtWeight.setError("Value max");
                        }
                    }


                }

            }
        });
        btnUserLoginDone.setOnClickListener(this);
    }

    public double setIdStateSport() {
        double dsport = 0;
        return dsport = chkSport.isCheck() ? 220 : 0;
    }

    // set lengh  from your weight (kg);
    public boolean SetLengghtKg() {
        String Sweight = edtWeight.getText() + "";
        boolean checker = false;
        if (Sweight.length() > 3) {
            String SweighCharAt3 = String.valueOf(Sweight.charAt(3));
            if (SweighCharAt3.trim().equals(".")) {
                checker = true;

            } else {

                checker = false;
            }


        } else {

            checker = true;
        }

        return checker;
    }

    ///======
    public boolean SetLengghtlbs() {
        String Sweight = edtWeight.getText() + "";
        boolean checkerlbs = false;

        if (Sweight.length() > 4) {
            String SweighCharAt3 = String.valueOf(Sweight.charAt(4));

            if (SweighCharAt3.trim().equals(".")) {
                checkerlbs = true;

            } else {
                checkerlbs = false;

            }

        } else {

            checkerlbs = true;
        }

        return checkerlbs;
    }

    public double setIdStateSunny() {

        double Sweight = 0;
        if (chkSunny.isCheck() == true) {

            Sweight = chkSunny.isCheck() ? 220 : 0;
        }
        return Sweight;
    }

    public void setSelectEditext() {
        edtWeight.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (!(edtWeight.getText() + "").trim().equalsIgnoreCase("")) {

                    String Sweight = edtWeight.getText().toString();
                    if (Radiakg.isChecked()) {
                        Log.e("CheckerKG: ", String.valueOf(SetLengghtKg()));
                        if (SetLengghtKg() == true) {
                            double dweight = (Double.parseDouble(Sweight) * 33) + setIdStateSport() + setIdStateSunny();
                            edtWater.setText(NumFormat.format(dweight));
                        } else {
                            edtWeight.setError("Value max");
                        }
                    } else {
                        Log.e("checkerLBS: ", String.valueOf(SetLengghtlbs()));
                        if (SetLengghtlbs() == true) {
                            double dweight = ((Double.parseDouble(Sweight) * 33) / 2.2) + setIdStateSport() + setIdStateSunny();
                            edtWater.setText(NumFormat.format(dweight));
                        } else {
                            edtWeight.setError("Value max");
                        }
                    }
                } else {


                }
                return false;
            }
        });

    }

    public void setRadiaocheck() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String sWeight = edtWeight.getText().toString();

                if (!sWeight.trim().equalsIgnoreCase("")) {

                    if (checkedId == R.id.radiakg) {
                        if (SetLengghtKg() == false) {

                            edtWeight.setError("Value max");
                        }

                        Log.e("check:", "kg");
                        double dweihgt = (Double.parseDouble(sWeight) / 2.2);
                        edtWeight.setText(NumFormat.format(dweihgt));


                    } else {
                        Log.e("check:", "lbs");

                        if (SetLengghtlbs() == false) {

                            edtWeight.setError("Value max");
                        }

                        double dweihgt = (Double.parseDouble(sWeight) * 2.2);
                        edtWeight.setText(NumFormat.format(dweihgt));
                    }

                }

            }
        });


    }

    //-------
//    public void CheckboxOncheck() {
//        chkSport.setOncheckListener(new CheckBox.OnCheckListener() {
//            @Override
//            public void onCheck(boolean b) {
//
//            }
//        });
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUserLoginDone) {
            if ((edtUserName.getText().toString()).trim().equalsIgnoreCase("")) {
                edtUserName.setError("your name null!");
            } else if ((edtWeight.getText().toString()).trim().equalsIgnoreCase("")) {
                edtWeight.setError("Your weight null !");
            } else {
                try {

                    String sname = edtUserName.getText().toString();
                    double dweight = Double.parseDouble(edtWeight.getText().toString());
                    double dwater = Double.parseDouble(edtWater.getText().toString());
                    int unit = 0;
                    if (Radiakg.isChecked()) {
                        unit = 1;
                    }
                    int idSateSport = 0;
                    if (chkSport.isCheck()) {
                        idSateSport = 1;
                    }
                    int idstateSunny = 0;
                    if (chkSunny.isCheck()) {
                        idstateSunny = 1;
                    }
                    UserInformation.setUserInformation_name(sname);
                    UserInformation.setIduserUnit(unit);
                    UserInformation.setUserInformationWater(dwater);
                    UserInformation.setUserInformationWeight(dweight);
                    UserInformation.setIduserStateSport(idSateSport);
                    UserInformation.setIduserStateSunny(idstateSunny);
                    Log.e("title:...:", UserInformation.toString());
                    UserDaoInformation.InserDb(UserInformation);
                    Log.e("status :", "success");
                    Intent inten = new Intent(this,Main_Navigattion.class);
                    startActivity(inten);
//                    for (int i = 0; i < (UserDaoInformation.getAllUserInformation()).size(); i++) {
//                        UserInformation = (UserDaoInformation.getAllUserInformation()).get(i);
//                        Log.e("getall:", UserInformation.toString());
//                    }

                } catch (Exception e) {

                    Log.e("error Inser Data", e.toString());

                }

            }

        }
    }

    // lấy sự kiện ấn cho nó
    @Override
    public void onCheck(boolean b) {


    }
//----------------------------------------


}

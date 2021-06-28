package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences; // Для сохранения и загрузки данных
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat; // Для синхронизации времении
import java.util.Calendar;

//------------------------------------------------//
//                                                //
//         BBBBBBBBBB        YYY     YYY          //
//         BB        BBB     YYY     YYY          //
//         BB        BBBB    YYY     YYY          //
//         BB      BBBB       YYYYYYYYY           //
//         BB        BBBB        YYY              //
//         BB        BBB         YYY              //
//         BBBBBBBBBBB           YYY              //
//                                                //
//        K I R I L L   V I K H L Y A E V         //
//------------------------------------------------//

public class MainActivity extends AppCompatActivity {
    User user;

    FrameLayout flMain;
    FrameLayout flWater;
    FrameLayout flProgram;
    FrameLayout flMarathon;
    FrameLayout flContent;
    FrameLayout flFirstStart;
    FrameLayout flNameOfProgram;
    FrameLayout flAchievements;
    FrameLayout flAnalytics;
    FrameLayout flWeightToday;
    FrameLayout flEndOfWeek;
    FrameLayout flMonday, flTuesday, flWednesday, flThursday, flFriday, flSaturday, flSunday;
    FrameLayout flGraph;

    ScrollView scrllChoose;
    ScrollView scrllSelect;

    LinearLayout monday_ll;
    LinearLayout tuesday_ll;
    LinearLayout wednesday_ll;
    LinearLayout thursday_ll;
    LinearLayout friday_ll;
    LinearLayout saturday_ll;
    LinearLayout sunday_ll;
    LinearLayout tasksToday;
    LinearLayout checkBoxes_ll;
    LinearLayout howmanywater_ll;

    Button button_water;
    Button button_marathon;
    Button button_edit_info;
    Button button_start;
    Button button_checkboxes;
    Button button_weightToday;
    Button button_anotherBuild;
    Button button_checkGraph;

    ImageButton iB_backinmainanal;
    ImageButton iB_backinmainach;
    ImageButton iB_weight_loss;
    ImageButton iB_maintaining;
    ImageButton iB_strength;
    ImageButton iB_ach;
    ImageButton iB_analytics;

    TextView tv_forwater;
    TextView tv_data_day;
    TextView tv_data_month;
    TextView tv_rules_marathon;
    TextView tv_age, tv_age_value;
    TextView tv_height, tv_height_value;
    TextView tv_weight, tv_weight_value;
    TextView tv_index_value;
    TextView tv_username;
    TextView tv_percents_water;
    TextView tv_percents_workouts;
    TextView tv_index_comment;
    TextView nameOfProgram;
    TextView monday_task;
    TextView tuesday_task;
    TextView wednesday_task;
    TextView thursday_task;
    TextView friday_task;
    TextView saturday_task;
    TextView sunday_task;
    TextView task_today;
    TextView tv_ach_1;
    TextView tv_howmanywater_done;
    TextView tv_howmanyweight_done;
    TextView tv_howmanyworkouts_done;
    TextView tv_ach_descr_1;
    TextView tv_ach_descr_2;
    TextView tv_ach_descr_3;
    TextView tv_ach_descr_4;
    TextView tv_ach_descr_5;

    CheckBox[] chBDoned;
    Boolean[] isChecked;
    Boolean[] dayIsCompleted = new Boolean[] {false, false, false, false, false, false, false};
    Boolean[] achievementsArray = new Boolean[] {false, false, false, false, false};
    Double [] weightArray = new Double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

    EditText etv_age, etv_height, etv_weight;
    EditText etv_fs_name_value, etv_fs_age, etv_fs_height, etv_fs_weight;
    EditText etv_howmanywater;
    EditText etv_weighttoday;

    String day;
    Boolean WorkoutsIsCompleted = false;
    Boolean WeekIsCompleted = false;
    Boolean ach_3_Was = false;
    Boolean ach_5_Was = false;
    Boolean ach_2_Was = false;

    RadioButton rdbtn_man, rdbtn_woman;
    SharedPreferences sPref;
    BottomNavigationView bottomNavigationView;


    SimpleDateFormat sdf_data_day_int = new SimpleDateFormat("u"); //Установка даты - день
    String day_int = sdf_data_day_int.format(Calendar.getInstance().getTime());

    int btn_tap = 1, daysIsCompleted_num;
    Typeface bebas;
    final String saved_name = "Saved_Name",
                 saved_age = "Saved_Age",
                 saved_height = "Saved_Height",
                 saved_weight = "Saved_Weight",
                 saved_sex = "Saved_Sex",
                 saved_TypeOfProgram = "Saved_Type",
                 saved_AmountWater = "Saved_AmountWater",
                 saved_AmountCompletedWorkouts = "Saved_AmountCompletedWorkouts",
                 saved_DaysIsCompleted = "Saved_DaysIsCompleted",
                 saved_CompletedPrograms = "Saved_CompletedPrograms";
    private long backPressedTime;
    private String actualTypeOfProgram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        user = new User();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        {
        flMain = (FrameLayout) findViewById(R.id.flMain);
        flWater = (FrameLayout) findViewById(R.id.fl_water);
        flProgram = (FrameLayout) findViewById(R.id.fl_program);
        flMarathon = (FrameLayout) findViewById(R.id.fl_marathon);
        flContent = (FrameLayout) findViewById(R.id.fl_content);
        flFirstStart = (FrameLayout) findViewById(R.id.fl_first_start);
        flNameOfProgram = (FrameLayout) findViewById(R.id.fl_name_of_program);
        flAchievements = (FrameLayout) findViewById(R.id.flAchievements);
        flAnalytics = (FrameLayout) findViewById(R.id.flAnalytics);
        flMonday = (FrameLayout) findViewById(R.id.fl_program_block_1);
        flTuesday = (FrameLayout) findViewById(R.id.fl_program_block_2);
        flWednesday = (FrameLayout) findViewById(R.id.fl_program_block_3);
        flThursday = (FrameLayout) findViewById(R.id.fl_program_block_4);
        flFriday = (FrameLayout) findViewById(R.id.fl_program_block_5);
        flSaturday = (FrameLayout) findViewById(R.id.fl_program_block_6);
        flSunday = (FrameLayout) findViewById(R.id.fl_program_block_7);
        flWeightToday = (FrameLayout) findViewById(R.id.fl_whatsurweighttoday);
        flEndOfWeek = (FrameLayout) findViewById(R.id.fl_endweek);
        flGraph = (FrameLayout) findViewById(R.id.fl_graph);

        monday_ll = (LinearLayout) findViewById(R.id.monday_ll);
        tuesday_ll = (LinearLayout) findViewById(R.id.tuesday_ll);
        wednesday_ll = (LinearLayout) findViewById(R.id.wednesday_ll);
        thursday_ll = (LinearLayout) findViewById(R.id.thursday_ll);
        friday_ll = (LinearLayout) findViewById(R.id.friday_ll);
        saturday_ll = (LinearLayout) findViewById(R.id.saturday_ll);
        sunday_ll = (LinearLayout) findViewById(R.id.sunday_ll);
        tasksToday = (LinearLayout) findViewById(R.id.ll_tasks);
        checkBoxes_ll = (LinearLayout) findViewById(R.id.ll_chb);
        howmanywater_ll = (LinearLayout) findViewById(R.id.ll_howmanywater);

        scrllChoose = (ScrollView) findViewById(R.id.scrollChooseProgram);
        scrllSelect = (ScrollView) findViewById(R.id.scrollSelectProgram);

        button_water = (Button) findViewById(R.id.btn_add_water);
        button_marathon = (Button) findViewById(R.id.btn_marathon);
        button_edit_info = (Button) findViewById(R.id.btn_change_info);
        button_start = (Button) findViewById(R.id.btn_start);
        button_checkboxes = (Button) findViewById(R.id.btn_checkboxes);
        button_weightToday = (Button) findViewById(R.id.btn_weighttoday);
        button_anotherBuild = (Button) findViewById(R.id.btn_another_done);
        button_checkGraph = (Button) findViewById(R.id.btn_checkGraph);

        iB_weight_loss = (ImageButton) findViewById(R.id.imgbtn_weight_loss);
        iB_maintaining = (ImageButton) findViewById(R.id.imgbtn_maintaining);
        iB_strength = (ImageButton) findViewById(R.id.imgbtn_streight);
        iB_ach = (ImageButton) findViewById(R.id.btn_ach);
        iB_analytics = (ImageButton) findViewById(R.id.btn_analytics);
        iB_backinmainach = (ImageButton) findViewById(R.id.btn_backinmainach);
        iB_backinmainanal = (ImageButton) findViewById(R.id.btn_backinmainanal);

        tv_forwater = (TextView) findViewById(R.id.tv_yourwater);
        tv_data_day = (TextView) findViewById(R.id.tv_data_day);
        tv_data_month = (TextView) findViewById(R.id.tv_data_month);
        tv_rules_marathon = (TextView) findViewById(R.id.tv_rules);
        tv_age = (TextView) findViewById(R.id.tv_info_age);
        tv_age_value = (TextView) findViewById(R.id.tv_info_age_value);
        tv_height = (TextView) findViewById(R.id.tv_info_height);
        tv_height_value = (TextView) findViewById(R.id.tv_info_height_value);
        tv_weight = (TextView) findViewById(R.id.tv_info_weight);
        tv_weight_value = (TextView) findViewById(R.id.tv_info_weight_value);
        tv_username = (TextView) findViewById(R.id.tv_info_name);
        tv_percents_water = (TextView) findViewById(R.id.tv_water_percents);
        tv_percents_workouts = (TextView) findViewById(R.id.tv_workouts_percents);
        tv_index_value = (TextView) findViewById(R.id.index_field);
        tv_index_comment = (TextView) findViewById(R.id.index_comment);
        tv_ach_1 = (TextView) findViewById(R.id.tv_ach_descr_1);
        tv_howmanywater_done = (TextView) findViewById(R.id.tv_water_value_done);
        tv_howmanyweight_done = (TextView) findViewById(R.id.tv_weight_value_done);
        tv_howmanyworkouts_done = (TextView) findViewById(R.id.tv_workouts_value_done);
        tv_ach_descr_1 = (TextView) findViewById(R.id.tv_ach_descr_1);
        tv_ach_descr_2 = (TextView) findViewById(R.id.tv_ach_descr_2);
        tv_ach_descr_3 = (TextView) findViewById(R.id.tv_ach_descr_3);
        tv_ach_descr_4 = (TextView) findViewById(R.id.tv_ach_descr_4);
        tv_ach_descr_5 = (TextView) findViewById(R.id.tv_ach_descr_5);


        nameOfProgram = (TextView) findViewById(R.id.nameOfProgram);
        monday_task = (TextView) findViewById(R.id.monday_task);
        tuesday_task = (TextView) findViewById(R.id.tuesday_task);
        wednesday_task = (TextView) findViewById(R.id.wednesday_task);
        thursday_task = (TextView) findViewById(R.id.thursday_task);
        friday_task = (TextView) findViewById(R.id.friday_task);
        saturday_task = (TextView) findViewById(R.id.saturday_task);
        sunday_task = (TextView) findViewById(R.id.sunday_task);
        task_today = (TextView) findViewById(R.id.tasksToday);

        etv_age = (EditText) findViewById(R.id.etv_age);
        etv_height = (EditText) findViewById(R.id.etv_height);
        etv_weight = (EditText) findViewById(R.id.etv_weight);
        etv_fs_name_value = (EditText) findViewById(R.id.etv_fs_name_value);
        etv_fs_age = (EditText) findViewById(R.id.etv_fs_age_value);
        etv_fs_height = (EditText) findViewById(R.id.etv_fs_height_value);
        etv_fs_weight = (EditText) findViewById(R.id.etv_fs_weight_value);
        etv_howmanywater = (EditText) findViewById(R.id.etv_howmanywater);
        etv_weighttoday = (EditText) findViewById(R.id.edt_weighttoday);

        rdbtn_man = (RadioButton) findViewById(R.id.rdbtn_fs_man);
        rdbtn_woman = (RadioButton) findViewById(R.id.rdbtn_fs_woman);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bebas = ResourcesCompat.getFont(this, R.font.bebasneueregular);
        }//Привязывание id к переменным

        SimpleDateFormat sdf_data_day = new SimpleDateFormat("dd"); //Установка даты - день
        String date_day = sdf_data_day.format(Calendar.getInstance().getTime());
        tv_data_day.setText(date_day);
        SimpleDateFormat sdf_data_month = new SimpleDateFormat("MMMM"); //Установка даты - месяц
        String date_month = sdf_data_month.format(Calendar.getInstance().getTime());
        tv_data_month.setText(date_month);

        FirstTimeCheck();
        AchievementsManager();
        CoolDown();
//        Toast.makeText(this, "День: " + user.getDayOfWeek(), Toast.LENGTH_SHORT).show();

        button_checkGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphInTheEnd();

                flGraph.setVisibility(View.VISIBLE);
                button_checkGraph.setVisibility(View.GONE);
            }
        });
        button_anotherBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flEndOfWeek.setVisibility(View.GONE);
                flContent.setVisibility(View.VISIBLE);
                flMain.setVisibility(View.GONE);

                flMonday.setBackgroundColor(getResources().getColor(R.color.program_block));
                flTuesday.setBackgroundColor(getResources().getColor(R.color.program_block));
                flWednesday.setBackgroundColor(getResources().getColor(R.color.program_block));
                flThursday.setBackgroundColor(getResources().getColor(R.color.program_block));
                flFriday.setBackgroundColor(getResources().getColor(R.color.program_block));
                flSaturday.setBackgroundColor(getResources().getColor(R.color.program_block));
                flSunday.setBackgroundColor(getResources().getColor(R.color.program_block));
                checkBoxes_ll.removeAllViewsInLayout();
                BuildProgram("null");
                WeekIsCompleted = true;

                user.setDayOfWeek("1");
                GraphOfWeight("simple");
                saveInfo();
                flProgram.setVisibility(View.VISIBLE);
            }
        });
        button_weightToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etv_weighttoday.getText().toString().length() > 0) {
                    user.setWeight(Double.parseDouble(etv_weighttoday.getText().toString()));
                    weightArray[Integer.parseInt(day_int)-1] = user.getWeight();
                    //Toast.makeText(MainActivity.this, "Назначил вес: " + user.getWeight() + " в массиве - " + weightArray[Integer.parseInt(day_int)-1], Toast.LENGTH_SHORT).show();
                    flContent.setVisibility(View.VISIBLE);
                    tv_weight_value.setText(Double.toString(user.getWeight()));
                    saveInfo();
                    loadInfo();
                }
            }
        });
        iB_backinmainach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flMain.setVisibility(View.VISIBLE);
                flAchievements.setVisibility(View.GONE);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        }); //Обратно в меню из достижений
        iB_backinmainanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flMain.setVisibility(View.VISIBLE);
                flAnalytics.setVisibility(View.GONE);
                bottomNavigationView.setVisibility(View.VISIBLE);
                GraphOfWeight("remove");
            }
        }); //Обратно в меню из аналитики
        iB_ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flMain.setVisibility(View.GONE);
                flWater.setVisibility(View.GONE);
                flProgram.setVisibility(View.GONE);
                flMarathon.setVisibility(View.GONE);
                flAchievements.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.GONE);
            }
        }); //Переход в достижения
        iB_analytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flMain.setVisibility(View.GONE);
                flWater.setVisibility(View.GONE);
                flProgram.setVisibility(View.GONE);
                flMarathon.setVisibility(View.GONE);
                flAnalytics.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.GONE);
                GraphOfWeight("simple");
                tv_index_value.setText(String.format("%.1f",(user.calcIndex(user.getWeight(),user.getHeight()))));
                tv_index_comment.setText(IndexClassification(user.calcIndex(user.getWeight(),user.getHeight())));

            }
        }); //Переход в аналитику
        iB_weight_loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTypeOfProgram("weightloss");
                scrllChoose.setVisibility(View.GONE);
                scrllSelect.setVisibility(View.VISIBLE);
                BuildProgram(user.getTypeOfProgram());
                saveInfo();
            }
        }); //Выбор тренировки похудения и сохранения типа тренировки в USER
        iB_maintaining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTypeOfProgram("maintaining");
                scrllChoose.setVisibility(View.GONE);
                scrllSelect.setVisibility(View.VISIBLE);
                BuildProgram(user.getTypeOfProgram());
                saveInfo();
            }
        }); //Выбор тренировки поддержания и сохранения типа тренировки в USER
        iB_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setTypeOfProgram("strength");
                scrllChoose.setVisibility(View.GONE);
                scrllSelect.setVisibility(View.VISIBLE);
                BuildProgram(user.getTypeOfProgram());
                saveInfo();
            }
        });//Выбор тренировки силовые и сохранения типа тренировки в USER
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(etv_fs_name_value.getText().toString());
                user.setAge(Integer.parseInt(etv_fs_age.getText().toString()));
                user.setHeight(Integer.parseInt(etv_fs_height.getText().toString()));
                user.setWeight(Integer.parseInt(etv_fs_weight.getText().toString()));
                if (rdbtn_man.isChecked()) {
                    user.setSex("мужской");
                } else user.setSex("женский");
                user.setDayOfWeek("1");
                saveInfo();
                loadInfo();

                flFirstStart.setVisibility(View.GONE);
                flContent.setVisibility(View.VISIBLE);
                flMain.setVisibility(View.VISIBLE);
            }
        }); //Стартовая страница
        button_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (btn_tap) {
                    case 1:
                        howmanywater_ll.setVisibility(View.VISIBLE);
                        btn_tap = 2;
                        break;
                    case 2:
                        if (Integer.parseInt(etv_howmanywater.getText().toString()) < 10000 && Integer.parseInt(etv_howmanywater.getText().toString()) > 0 && etv_howmanywater.getText().toString() != "") {
                            tv_forwater.setText(Integer.toString(user.addWater(Integer.parseInt(etv_howmanywater.getText().toString()), 10000)));
                            user.setTotalAmountOfWater(user.getTotalAmountOfWater() + Integer.parseInt(etv_howmanywater.getText().toString()));
                            //Toast.makeText(MainActivity.this, "Всего воды: " + user.getTotalAmountOfWater(), Toast.LENGTH_SHORT).show();
                            tv_percents_water.setText(Integer.toString(CalcPercentsWater()) + "%");
                            howmanywater_ll.setVisibility(View.GONE);
                            btn_tap = 1;
                        } else Toast.makeText(MainActivity.this, "Ошибка ввода!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }); //Водичка
        button_marathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ach_5_Was) { AchievementCompleted(5); ach_5_Was = true;}
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ale20100039.wixsite.com/my-site"));
                startActivity(intent);

            }
        }); //Марафон
        tv_rules_marathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ale20100039.wixsite.com/my-site"));
                startActivity(intent);
            }
        });//Условия и правила участия
        button_edit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (button_edit_info.getText().toString()) {
                    case "изменить":
                        tv_age_value.setVisibility(View.GONE);
                        tv_height_value.setVisibility(View.GONE);
                        tv_weight_value.setVisibility(View.GONE);

                        etv_age.setVisibility(View.VISIBLE); etv_age.setText(Integer.toString(user.getAge()));
                        etv_height.setVisibility(View.VISIBLE); etv_height.setText(Integer.toString(user.getHeight()));
                        etv_weight.setVisibility(View.VISIBLE); etv_weight.setText(Double.toString(user.getWeight()));
                        button_edit_info.setText("применить");
                        break;
                    case "применить":
                        double weight_tmp;
                        weight_tmp = user.getWeight();
                        user.setAge(Integer.parseInt(etv_age.getText().toString()));
                        user.setHeight(Integer.parseInt(etv_height.getText().toString()));
                        user.setWeight(Double.parseDouble(etv_weight.getText().toString()));
                        if (user.getWeight() != weight_tmp) weightArray[Integer.parseInt(day_int)-1] = user.getWeight();
                        saveInfo();
                        loadInfo();

                        tv_age.setVisibility(View.VISIBLE);
                        tv_age_value.setVisibility(View.VISIBLE);
                        tv_height.setVisibility(View.VISIBLE);
                        tv_height_value.setVisibility(View.VISIBLE);
                        tv_weight.setVisibility(View.VISIBLE);
                        tv_weight_value.setVisibility(View.VISIBLE);

                        etv_age.setVisibility(View.GONE);
                        etv_height.setVisibility(View.GONE);
                        etv_weight.setVisibility(View.GONE);

                        button_edit_info.setText("изменить");
                        break;
                }
            }
        }); // Редактирование личной информации
        button_checkboxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (button_checkboxes.getText().toString()) {
                    case "изменить":
                        for (int i = 0; i < chBDoned.length; i++) {
                            chBDoned[i].setEnabled(true);
                        }
                        button_checkboxes.setText("применить");
                        break;
                    case "применить":
                        for (int i = 0; i < chBDoned.length; i++) {
                            chBDoned[i].setEnabled(false);
                        }
                        CheckNewChecked();
                        user.setTotalAmountOfWorkouts(user.getTotalAmountOfWorkouts() + user.getCompletedWorkouts());
//                        Toast.makeText(MainActivity.this, "Всего тренировок: " + user.getTotalAmountOfWorkouts(), Toast.LENGTH_SHORT).show();
                        CalcPercentsWorkouts();
                        button_checkboxes.setText("изменить");
                        break;
                }
            }
        }); // Отметка проделанных тренировок *1
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_calendary:
                                flMain.setVisibility(View.VISIBLE);
                                flWater.setVisibility(View.GONE);
                                flProgram.setVisibility(View.GONE);
                                flMarathon.setVisibility(View.GONE);
                                break;
                            case R.id.navigation_water:
                                flMain.setVisibility(View.GONE);
                                flWater.setVisibility(View.VISIBLE);
                                flProgram.setVisibility(View.GONE);
                                flMarathon.setVisibility(View.GONE);
                                break;
                            case R.id.navigation_build:
                                flMain.setVisibility(View.GONE);
                                flWater.setVisibility(View.GONE);
                                flProgram.setVisibility(View.VISIBLE);
                                flMarathon.setVisibility(View.GONE);
                                break;
                            case R.id.navigation_marathon:
                                flMain.setVisibility(View.GONE);
                                flWater.setVisibility(View.GONE);
                                flProgram.setVisibility(View.GONE);
                                flMarathon.setVisibility(View.VISIBLE);
                                break;
                        }
                        if (!ach_3_Was && user.getAmountOfWater() > 2000) { AchievementCompleted(3); ach_3_Was = true;}
                        saveInfo();
                        loadInfo();
                        CompleteDay();
                        return false;
                    }
                }); //Навигация
    }
    @Override
    protected void onStop() {
        super.onStop();
        CheckBoxManager("save");
        saveInfo();
    } // Сохранение при закрытии
    @Override
    public void onBackPressed() {
        saveInfo();
        super.onBackPressed();
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            saveInfo();
            finish();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();

    } // Подтверждение выхода при нажатии на "Back" - на самом деле сохранение
    public void WeightToday() {
        if (NewDay() && !WeekIsCompleted) {
            flContent.setVisibility(View.GONE);
            flWeightToday.setVisibility(View.VISIBLE);

        }
    } // "Какой вес у тебя сегодня?"
    public String IndexClassification(double index) {
        if (index <= 18.5) {tv_index_comment.setTextColor(Color.rgb(255, 140, 0)); return "Дефицит массы тела";}
        if (index > 18.5 && index < 24.9) {tv_index_comment.setTextColor(Color.rgb(0, 240, 0)); return "Нормальная масса"; }
        if (index > 24.9 && index < 31) {tv_index_comment.setTextColor(Color.rgb(255, 140, 0)); return "Избыточная масса"; }
        if (index > 30 && index < 36) {tv_index_comment.setTextColor(Color.rgb(255, 140, 0)); return "Ожирение I степени"; }
        if (index > 35 && index < 39.9) {tv_index_comment.setTextColor(Color.rgb(255, 100, 0)); return "Ожирение II степени"; }
        else {tv_index_comment.setTextColor(Color.rgb(255, 0, 0)); return "Ожирение III степени"; }
    } // Комментарий на индекс (норм/много/мало)
    public void GraphOfWeight(String command) {
        // Line Graph
        double max = 0, min = 0;
        GraphView line_graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> line_series =
                    new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(1, weightArray[0]),
                            new DataPoint(2, weightArray[1]),
                            new DataPoint(3, weightArray[2]),
                            new DataPoint(4, weightArray[3]),
                            new DataPoint(5, weightArray[4]),
                            new DataPoint(6, weightArray[5]),
                            new DataPoint(7, weightArray[6])
                    });
            line_graph.addSeries(line_series);
            line_series.setDrawDataPoints(true);
            line_series.setDataPointsRadius(10);

        // set the bound

        for (int i = 0; i < weightArray.length-1; i++) {
            if (weightArray[i] > weightArray[i + 1]) max = weightArray[i];
            if (weightArray[i] < weightArray[i + 1]) min = weightArray[i];
        }

        // set manual X bounds
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(line_graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"1","2","3","4","5","6","7"});
        line_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        line_graph.getViewport().setScalable(true);
        line_graph.getViewport().setScrollable(true);
        line_graph.getViewport().setMinY(min);
        line_graph.getViewport().setMaxY(max);
        line_graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);
        line_graph.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        line_graph.getGridLabelRenderer().reloadStyles();
        if (command == "remove") line_graph.removeAllSeries();
    }; // График веса
    public void GraphInTheEnd() {
        double max = 0, min = 0;
        GraphView graphView = (GraphView) findViewById(R.id.graph2);
        LineGraphSeries<DataPoint> lines = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, weightArray[0]),
                new DataPoint(2, weightArray[1]),
                new DataPoint(3, weightArray[2]),
                new DataPoint(4, weightArray[3]),
                new DataPoint(5, weightArray[4]),
                new DataPoint(6, weightArray[5]),
                new DataPoint(7, weightArray[6])
        });
        graphView.addSeries(lines);
        lines.setColor(Color.GREEN);
        lines.setDrawDataPoints(true);
        lines.setDataPointsRadius(10);

        for (int i = 0; i < weightArray.length-1; i++) {
            if (weightArray[i] > weightArray[i + 1]) max = weightArray[i];
            if (weightArray[i] < weightArray[i + 1]) min = weightArray[i];
        }

        // Работа с границами

        StaticLabelsFormatter slf = new StaticLabelsFormatter(graphView);
        slf.setHorizontalLabels(new String[] {"1","2","3","4","5","6","7"});
        graphView.getGridLabelRenderer().setLabelFormatter(slf);

        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setMaxY(max);
        graphView.getViewport().setMinY(min);

    }
    public void AchievementCompleted(int numOfAch) {
        achievementsArray[numOfAch - 1] = true;
        switch (numOfAch) {
            case 1:
                Toast.makeText(this, "Вы получили достижение: '" + getString(R.string.ach_1_name) + "'!", Toast.LENGTH_SHORT).show();
                tv_ach_descr_1.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                Toast.makeText(this, "Вы получили достижение: '" + getString(R.string.ach_2_name) + "'!", Toast.LENGTH_SHORT).show();
                tv_ach_descr_2.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                Toast.makeText(this, "Вы получили достижение: '" + getString(R.string.ach_3_name) + "'!", Toast.LENGTH_SHORT).show();
                tv_ach_descr_3.setBackgroundColor(Color.GREEN);
                break;
            case 4:
                Toast.makeText(this, "Вы получили достижение: '" + getString(R.string.ach_4_name) + "'!", Toast.LENGTH_SHORT).show();
                tv_ach_descr_4.setBackgroundColor(Color.GREEN);
                break;
            case 5:
                Toast.makeText(this, "Вы получили достижение: '" + getString(R.string.ach_5_name) + "'!", Toast.LENGTH_SHORT).show();
                tv_ach_descr_5.setBackgroundColor(Color.GREEN);
                break;
        }
        saveInfo();
    }
    public void AchievementsManager() {
        for (int i = 0; i < achievementsArray.length; i++) {
            if (achievementsArray[i]) {
                switch (i+1) {
                    case 1:
                        tv_ach_descr_1.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        tv_ach_descr_2.setBackgroundColor(Color.GREEN);
                        break;
                    case 3:
                        tv_ach_descr_3.setBackgroundColor(Color.GREEN);
                        break;
                    case 4:
                        tv_ach_descr_4.setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        tv_ach_descr_5.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
            if (!achievementsArray[i]) {
                switch (i+1) {
                    case 1:
                        tv_ach_descr_1.setBackgroundColor(getResources().getColor(R.color.tv_background_ach));
                        break;
                    case 2:
                        tv_ach_descr_2.setBackgroundColor(getResources().getColor(R.color.tv_background_ach));
                        break;
                    case 3:
                        tv_ach_descr_3.setBackgroundColor(getResources().getColor(R.color.tv_background_ach));
                        break;
                    case 4:
                        tv_ach_descr_4.setBackgroundColor(getResources().getColor(R.color.tv_background_ach));
                        break;
                    case 5:
                        tv_ach_descr_5.setBackgroundColor(getResources().getColor(R.color.tv_background_ach));
                        break;
                }
            }
        }
    }
    public void CompleteDay() {
            if (user.getAmountOfWater() >= 2000 && user.getCompletedWorkouts() == chBDoned.length) {

                dayIsCompleted[Integer.parseInt(user.getDayOfWeek())-1] = true;
                WorkoutsIsCompleted = true;
            }
            for (int i = 0; i < dayIsCompleted.length; i++) {
                if (dayIsCompleted[i]) {
                    switch (i + 1) {
                        case 1:
                            flMonday.setBackgroundColor(Color.GREEN);
                            break;
                        case 2:
                            flTuesday.setBackgroundColor(Color.GREEN);
                            break;
                        case 3:
                            flWednesday.setBackgroundColor(Color.GREEN);
                            break;
                        case 4:
                            flThursday.setBackgroundColor(Color.GREEN);
                            break;
                        case 5:
                            flFriday.setBackgroundColor(Color.GREEN);
                            break;
                        case 6:
                            flSaturday.setBackgroundColor(Color.GREEN);
                            break;
                        case 7:
                            flSunday.setBackgroundColor(Color.GREEN);
                            break;
                    }
                }
                if (!dayIsCompleted[i]) {
                    switch (i + 1) {
                        case 1:
                            flMonday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                        case 2:
                            flTuesday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                        case 3:
                            flWednesday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                        case 4:
                            flThursday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                        case 5:
                            flFriday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                        case 6:
                            flSaturday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                        case 7:
                            flSunday.setBackgroundColor(getResources().getColor(R.color.program_block));
                            break;
                    }
                }
            }
            int tmp = 0;
            for (int j = 0; j < dayIsCompleted.length; j++) {
                if (dayIsCompleted[j]) tmp++;
                daysIsCompleted_num = tmp;
            }

        CompleteProgram(daysIsCompleted_num);
    } // Выполнение дня (отметка зеленным цветом в программе)
    public boolean NewDay() {
        SimpleDateFormat sdf_dayOfWeek = new SimpleDateFormat("u");
        String dayOfWeek = sdf_dayOfWeek.format(Calendar.getInstance().getTime());
        if (Integer.parseInt(dayOfWeek) != Integer.parseInt(day)) {
            return true;
        } else {
            return false;
        }
    } // Проверка на наступления нового дня
    public void CompleteProgram(int days) {
        if (days == 7) {
            user.setCompletedWorkouts(0);
            user.setAmountOfWater(0);
            daysIsCompleted_num = 0;

            for (int i = 0; i < dayIsCompleted.length; i++) {
                dayIsCompleted[i] = false;
//                Toast.makeText(this, "День " + (i+1) + " - " + dayIsCompleted[i], Toast.LENGTH_SHORT).show();
                saveInfo();
            }

            CheckBoxManager("remove");
            CheckBoxManager("save");
            user.setCompletedPrograms(user.getCompletedPrograms()+1);
            if (user.getCompletedPrograms() == 1) AchievementCompleted(1); else if (user.getCompletedPrograms() == 2) AchievementCompleted(4);
            for (int l = 0; l < isChecked.length; l++) isChecked[l] = false;
            saveInfo();
            tv_howmanywater_done.setText(Integer.toString(user.getTotalAmountOfWater()));
            tv_howmanyworkouts_done.setText(Integer.toString(user.getTotalAmountOfWorkouts()));
            tv_howmanyweight_done.setText(Double.toString(weightArray[0]-weightArray[6]));
            if (!ach_2_Was && weightArray[6] < weightArray[0]) {AchievementCompleted(2); ach_2_Was = true;}

            flWeightToday.setVisibility(View.GONE);
            flContent.setVisibility(View.GONE);
            flEndOfWeek.setVisibility(View.VISIBLE);

        }
    }
    public void CheckBoxManager(String type) {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        isChecked = new Boolean[chBDoned.length];
        switch (type) {
            case "save":
                for (int i = 0; i < chBDoned.length; i++) {
                    if (chBDoned[i].isChecked()) {
                        isChecked[i] = true;
                    } else isChecked[i] = false;
                }
                for (int j = 0; j < chBDoned.length; j++) {
                    ed.remove("isChecked_value_" + j);
                    ed.putBoolean("isChecked_value_" + j, chBDoned[j].isChecked());
                    //Toast.makeText(this, "Сохранил значение " + chBDoned[j].isChecked() + " для индекса " + (j+1), Toast.LENGTH_SHORT).show();
                }
                break;
            case "load":
                    if (NewDay()) {
                        for (int i = 0; i < chBDoned.length; i++) {
                            chBDoned[i].setChecked(false);
                        }
                    } else {
                        for (int i = 0; i < chBDoned.length; i++) {
                        chBDoned[i].setChecked(sPref.getBoolean("isChecked_value_" + i, false));
                        //Toast.makeText(this, "Загрузил значение " + chBDoned[i].isChecked() + " для индекса " + (i+1), Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case "remove":
                for (int i = 0; i < chBDoned.length; i++) {
                    chBDoned[i].setChecked(false);
                }
                CheckBoxManager("save");
        }
        ed.commit();

    } // Сохранение чекбоксов
    public void CheckBoxCreator(int howManyChB) {
        chBDoned = new CheckBox[howManyChB];
                for (int i = 0; i < howManyChB; i++) {
                    CheckBox checkBox = new CheckBox(getApplicationContext());
                    chBDoned[i] = checkBox;
                    checkBoxes_ll.addView(checkBox);
                    chBDoned[i].setEnabled(false);
                }

    } //Создание чекбоксов, в зависимости от количество тасков
    public int CalcPercentsWater() {
        int a = user.getAmountOfWater();
        int b = 2000;
        return (a*100)/b;
    } // Высчитывание процента баласа воды
    public int CalcPercentsWorkouts() {
        int a = user.getCompletedWorkouts();
        int b = chBDoned.length;
        return (a*100)/b;
    } // Высчитывание процента выполненных тренировок
    public void CheckNewChecked() {
        user.setCompletedWorkouts(chBDoned.length);
        for (int i = 0; i < chBDoned.length; i++) {
            if (!chBDoned[i].isChecked()) user.setCompletedWorkouts(user.getCompletedWorkouts() - 1);
            tv_percents_workouts.setText(Integer.toString(CalcPercentsWorkouts()) + "%");
        }
    }
    public void FirstTimeCheck() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedName = sPref.getString(saved_name, "");
        String savedType = sPref.getString(saved_TypeOfProgram, "");
        if (savedName == "") {
            flFirstStart.setVisibility(View.VISIBLE);
            flWeightToday.setVisibility(View.GONE);
        } else if (savedName != "") {
            flContent.setVisibility(View.VISIBLE);
            flMain.setVisibility(View.VISIBLE);
            loadInfo();

            WeightToday();
        }
        if (savedType == "") {
            scrllChoose.setVisibility(View.VISIBLE);

            scrllSelect.setVisibility(View.GONE);
        } else if (savedType != "") {
            scrllSelect.setVisibility(View.VISIBLE);
            scrllChoose.setVisibility(View.GONE);
            loadInfo();
            switch (user.getTypeOfProgram()) {
                case "weightloss":
                    BuildProgram("weightloss");
                    break;
                case "maintaining":
                    BuildProgram("maintaining");
                    break;
                case "strength":
                    BuildProgram("strength");
                    break;
            }
        }
    } // Проверка на первый заход (и не первый)
    public void CoolDown() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedName = sPref.getString(saved_name, "");
        String savedType = sPref.getString(saved_TypeOfProgram, "");
        if (savedName != "" && savedType != "")
        if (NewDay()) {
            if (WorkoutsIsCompleted) {
                if (!WeekIsCompleted) user.setDayOfWeek(Integer.toString(Integer.parseInt(user.getDayOfWeek()) + 1));
                CheckBoxManager("remove");
                user.setAmountOfWater(0);
                WorkoutsIsCompleted = false;
                checkBoxes_ll.removeAllViewsInLayout();
                switch (user.getTypeOfProgram()) {
                    case "weightloss":
                        BuildProgram("weightloss");
                        break;
                    case "maintaining":
                        BuildProgram("maintaining");
                        break;
                    case "strength":
                        BuildProgram("strength");
                        break;
                }
            }
        }
    }
    public void TaskToday(String type, String dayOfWeek) {
        SimpleDateFormat sdf_data_day_int = new SimpleDateFormat("u"); //Установка даты - день
        String day_int = sdf_data_day_int.format(Calendar.getInstance().getTime());
            switch (dayOfWeek) {
                case "1":
                    task_today.setText(monday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_monday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_monday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_monday_howmany)));
                    break;
                case "2":
                    task_today.setText(tuesday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_tuesday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_tuesday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_tuesday_howmany)));
                    break;
                case "3":
                    task_today.setText(wednesday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_wednesday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_wednesday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_wednesday_howmany)));
                    break;
                case "4":
                    task_today.setText(thursday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_thursday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_thursday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_thursday_howmany)));
                    break;
                case "5":
                    task_today.setText(friday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_friday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_friday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_friday_howmany)));
                    break;
                case "6":
                    task_today.setText(saturday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_saturday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_saturday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_saturday_howmany)));
                    break;
                case "7":
                    task_today.setText(sunday_task.getText().toString());
                    if (type == "weightloss")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.weightloss_sunday_howmany)));
                    if (type == "maintaining")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.maintaining_sunday_howmany)));
                    if (type == "strength")
                        CheckBoxCreator(Integer.parseInt(getString(R.string.strength_sunday_howmany)));
                    break;
            }
    } // Вывод заданий на "сегодня" на главную страницу
    public void BuildProgram (String type) {
        if (type == "weightloss") {
            nameOfProgram.setText(getString(R.string.name_of_program_weightloss));
            monday_task.setText(getString(R.string.weightloss_monday));
            tuesday_task.setText(getString(R.string.weightloss_tuesday));
            wednesday_task.setText(getString(R.string.weightloss_wednesday));
            thursday_task.setText(getString(R.string.weightloss_thursday));
            friday_task.setText(getString(R.string.weightloss_friday));
            saturday_task.setText(getString(R.string.weightloss_saturday));
            sunday_task.setText(getString(R.string.weightloss_sunday));
        } else if (type == "maintaining") {
            nameOfProgram.setText(getString(R.string.name_of_program_maintaining));
            monday_task.setText(getString(R.string.maintaining_monday));
            tuesday_task.setText(getString(R.string.maintaining_tuesday));
            wednesday_task.setText(getString(R.string.maintaining_wednesday));
            thursday_task.setText(getString(R.string.maintaining_thursday));
            friday_task.setText(getString(R.string.maintaining_friday));
            saturday_task.setText(getString(R.string.maintaining_saturday));
            sunday_task.setText(getString(R.string.maintaining_sunday));
        } else if (type == "strength") {
            nameOfProgram.setText(getString(R.string.name_of_program_strength));
            monday_task.setText(getString(R.string.strength_monday));
            tuesday_task.setText(getString(R.string.strength_tuesday));
            wednesday_task.setText(getString(R.string.strength_wednesday));
            thursday_task.setText(getString(R.string.strength_thursday));
            friday_task.setText(getString(R.string.strength_friday));
            saturday_task.setText(getString(R.string.strength_saturday));
            sunday_task.setText(getString(R.string.strength_sunday));
        } else if (type == "null") {
            scrllChoose.setVisibility(View.VISIBLE);
            scrllSelect.setVisibility(View.GONE);
            user.setDayOfWeek("1");
            Toast.makeText(MainActivity.this, "Пожалуйста, выберите тип тренировки", Toast.LENGTH_SHORT).show();
        }
        TaskToday(type, user.getDayOfWeek());
        CheckBoxManager("load");
        CheckNewChecked();
    } // Построение программы в зависимости от типа
    private void saveInfo() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        SimpleDateFormat sdf_dayOfWeek = new SimpleDateFormat("u");
        String dayOfWeek = sdf_dayOfWeek.format(Calendar.getInstance().getTime());
        ed.putInt(saved_DaysIsCompleted, daysIsCompleted_num);
        ed.putString("day", dayOfWeek);
        ed.putString(saved_name, user.getName());
        ed.putString(saved_age, Integer.toString(user.getAge()));
        ed.putString(saved_height, Integer.toString(user.getHeight()));
        ed.putString(saved_weight, Double.toString(user.getWeight()));
        ed.putString(saved_sex, user.getSex());
        ed.putString(saved_TypeOfProgram, user.getTypeOfProgram());
        ed.putString(saved_AmountWater, Integer.toString(user.getAmountOfWater()));
        ed.putString(saved_AmountCompletedWorkouts, Integer.toString(user.getCompletedWorkouts()));
        ed.putInt("TotalWater", user.getTotalAmountOfWater());
        ed.putInt("TotalWorkouts", user.getTotalAmountOfWorkouts());
        ed.putString("passedDays", user.getDayOfWeek());
        ed.putInt(saved_CompletedPrograms, user.getCompletedPrograms());
        ed.putBoolean("ach3_Was", ach_3_Was);
        ed.putBoolean("ach5_Was", ach_5_Was);
        ed.putBoolean("ach2_Was", ach_2_Was);
        ed.putBoolean("WorkoutsComplete", WorkoutsIsCompleted);
        for (int i = 0; i < dayIsCompleted.length; i++) { // Сохранение выполненных дней
            if (dayIsCompleted[i]) ed.putBoolean("day " + i + "is completed", true);
            if (!dayIsCompleted[i]) ed.putBoolean("day " + i + "is completed", false);
        }
        if (WeekIsCompleted) {
            weightArray[0] = user.getWeight();
            for (int j = 1; j < weightArray.length; j++) {
                ed.putString("day " + j + " : ", Double.toString(0.0));
            }
        } else {
            weightArray[Integer.parseInt(user.getDayOfWeek()) - 1] = user.getWeight();
            ed.putString("day " + (Integer.parseInt(user.getDayOfWeek())-1) + " : ", Double.toString(weightArray[Integer.parseInt(user.getDayOfWeek()) - 1]));
        }

        for (int a = 0; a < achievementsArray.length; a++) {
            ed.putBoolean("Ach " + a+1 + ": ", achievementsArray[a]);
        }

        //Toast.makeText(this, "day " + (Integer.parseInt(user.getDayOfWeek())-1) + " : " + Double.toString(weightArray[Integer.parseInt(user.getDayOfWeek()) - 1]), Toast.LENGTH_SHORT).show();
        ed.commit();
    } // Сохранение
    private void loadInfo() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedName = sPref.getString(saved_name, "");
        String savedAge = sPref.getString(saved_age, "");
        String savedHeight = sPref.getString(saved_height, "");
        String savedWeight = sPref.getString(saved_weight, "");
        String savedSex = sPref.getString(saved_sex, "");
        String savedType = sPref.getString(saved_TypeOfProgram, "");
        String savedAmountWater = sPref.getString(saved_AmountWater, "");
        String savedAmountCompletedWorkouts = sPref.getString(saved_AmountCompletedWorkouts, "");
        int savedAmountCompletedPrograms = sPref.getInt(saved_CompletedPrograms, 0);
        int savedDaysIsCompleted = sPref.getInt(saved_DaysIsCompleted, 0);
        user.setDayOfWeek(sPref.getString("passedDays", "1"));
        day = sPref.getString("day", "");
        daysIsCompleted_num = savedDaysIsCompleted;
        user.setName(savedName);
        user.setAge(Integer.parseInt(savedAge));
        user.setHeight(Integer.parseInt(savedHeight));
        user.setWeight(Double.parseDouble(savedWeight));
        user.setTypeOfProgram(savedType);
        user.setCompletedPrograms(savedAmountCompletedPrograms);
        ach_3_Was = sPref.getBoolean("ach3_Was", false);
        ach_5_Was = sPref.getBoolean("ach5_Was", false);
        ach_2_Was = sPref.getBoolean("ach2_Was", false);
        WorkoutsIsCompleted = sPref.getBoolean("WorkoutsComplete", false);
        if (NewDay()) {
            user.setAmountOfWater(0);
            user.setCompletedWorkouts(0);
        } else {
            user.setAmountOfWater(Integer.parseInt(savedAmountWater));
            user.setCompletedWorkouts(Integer.parseInt(savedAmountCompletedWorkouts));
        }

        user.setTotalAmountOfWater(sPref.getInt("TotalWater", 0));
        user.setTotalAmountOfWorkouts(sPref.getInt("TotalWorkouts", 0));

        for (int i = 0; i < dayIsCompleted.length; i++) {
            dayIsCompleted[i] = sPref.getBoolean("day " + i + "is completed", false);
        }
        for (int j = 0; j < weightArray.length; j++) {
            weightArray[j] = Double.parseDouble(sPref.getString("day " + j + " : ", "0.0"));
        }
        for (int a = 0; a < achievementsArray.length; a++) {
            achievementsArray[a] = sPref.getBoolean("Ach " + a+1 + ": ", false);
        }
        //Toast.makeText(this, "Загрузил вес: " + weightArray[4], Toast.LENGTH_SHORT).show();
        tv_percents_water.setText(Integer.toString(CalcPercentsWater())+ "%");
        tv_username.setText(user.getName());
        tv_age_value.setText(Integer.toString(user.getAge()));
        tv_weight_value.setText(Double.toString(user.getWeight()));
        tv_height_value.setText(Integer.toString(user.getHeight()));
        tv_forwater.setText(Integer.toString(user.getAmountOfWater()));
    } // Загрузка
}

// |    1. Сделать количество воды не фиксированным, а высчитывать его по формуле
// |    2. Уведомления
// |    3. Доработать тёмную тему
// |    
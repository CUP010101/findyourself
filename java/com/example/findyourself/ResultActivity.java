package com.example.findyourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private TextView displayGameJobTextView, displayFriendTextView, displayFinalResultTextView;
    private ImageView mbtiImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        displayGameJobTextView = findViewById(R.id.JobText);
        displayFriendTextView = findViewById(R.id.friendText);
        displayFinalResultTextView = findViewById(R.id.finalResult);
        mbtiImageView = findViewById(R.id.imageView);

        Intent intent1 = getIntent();
        int[] intArray = intent1.getIntArrayExtra("MbtiIntArray");

        if (intArray != null) {
            String mbtiType = determineMbtiType(intArray);
            String jobType = gameJobType(mbtiType);
            String friendType = jobFriendType(mbtiType);
            String resultType = finalResultType(mbtiType);
            displayGameJobTextView.setText(jobType);
            displayFriendTextView.setText("추천하는 파티원 : " + friendType);
            displayFinalResultTextView.setText(resultType);
            displayMbtiImage(mbtiType);
        }
        else {
            displayGameJobTextView.setText("값이 없습니다.");
            displayFriendTextView.setText("값이 없습니다.");
            displayFinalResultTextView.setText("다시 하십시오.");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String determineMbtiType(int[] intArray) {
        String First = intArray[0] > intArray[1] ? "E" : "I";
        String Second = intArray[2] > intArray[3] ? "N" : "S";
        String Third = intArray[4] > intArray[5] ? "F" : "T";
        String Fourth = intArray[6] > intArray[7] ? "P" : "J";
        return First + Second + Third + Fourth;
    }

    private String gameJobType(String mbtiType){
        String job = "";
        switch (mbtiType) {
            case "ENTJ":
                job = "네크로멘서";
                break;
            case "ENTP":
                job = "드루이드";
                break;
            case "ENFJ":
                job = "법사";
                break;
            case "ENFP":
                job = "소환사";
                break;
            case "ESTJ":
                job = "해적";
                break;
            case "ESTP":
                job = "가디언";
                break;
            case "ESFJ":
                job = "바드";
                break;
            case "ESFP":
                job = "버서커";
                break;
            case "INTJ":
                job = "전략가";
                break;
            case "INTP":
                job = "레인저";
                break;
            case "INFJ":
                job = "마검사";
                break;
            case "INFP":
                job = "사제";
                break;
            case "ISTJ":
                job = "군주";
                break;
            case "ISTP":
                job = "연금술사";
                break;
            case "ISFJ":
                job = "클레릭";
                break;
            case "ISFP":
                job = "거상";
                break;
            default:
                job = "값이 없습니다.";
                break;
        }
        return job;
    }

    private String jobFriendType(String mbtiType){
        String friend = "";
        switch (mbtiType) {
            case "ENTJ":
                friend = "해적";
                break;
            case "ENTP":
                friend = "가디언";
                break;
            case "ENFJ":
                friend = "바드";
                break;
            case "ENFP":
                friend = "버서커";
                break;
            case "ESTJ":
                friend = "네크로멘서";
                break;
            case "ESTP":
                friend = "드루이드";
                break;
            case "ESFJ":
                friend = "법사";
                break;
            case "ESFP":
                friend = "소환사";
                break;
            case "INTJ":
                friend = "군주";
                break;
            case "INTP":
                friend = "연금술사";
                break;
            case "INFJ":
                friend = "클레릭";
                break;
            case "INFP":
                friend = "거상";
                break;
            case "ISTJ":
                friend = "전략가";
                break;
            case "ISTP":
                friend = "레인저";
                break;
            case "ISFJ":
                friend = "마검사";
                break;
            case "ISFP":
                friend = "사제";
                break;
            default:
                friend = "값이 없습니다.";
                break;
        }
        return friend;
    }
    private String finalResultType(String mbtiType){
        String result = "";
        switch (mbtiType) {
            case "ENTJ":
                result = "계획과 전략을 세워서 게임하는 편.\n목표를 이루기 위해 최선을 다하지만 가끔 오해도 삼.";
                break;
            case "ENTP":
                result = "사람 만나려고 게임 접속하는 경우가 많음.\n경쟁도 좋지만 협동 게임에 더 능함.";
                break;
            case "ENFJ":
                result = "친구랑 협동 플레이 좋아함.\n하지만 혼자 게임하는 게 더 좋음.";
                break;
            case "ENFP":
                result = "다양한 게임을 돌아다니며 즐기는 편.\n같이 게임하는 소수의 고정 인원이 있는 경우가 많음.";
                break;
            case "ESTJ":
                result = "파티를 너무 사랑해서 게임에서도 사람들과 어울려야 함.\n게임보단 캐릭터 커스터마이징에 더 진심인 편.";
                break;
            case "ESTP":
                result = "고집쟁이, 타고난 리더, 임기응변 강함.\n협동심과 리더십이 좋아 나도 모르게 파티장 역할을 하고 있음.";
                break;
            case "ESFJ":
                result = "게임할 때 게임과 관련 없이 궁금한 게 너무 많음.\n화를 거의 내지 않음.\n만일 화를 냈다면 인내심의 한계를 넘었다는 뜻.";
                break;
            case "ESFP":
                result = "자유분방, 호기심이 많지만 끈기는 부족.\n돌발 상황에서 대처가 매우 뛰어남.";
                break;
            case "INTJ":
                result = "기본 정보는 철저하게 습득, 조사.\n항상 냉정함을 잃지 않음.";
                break;
            case "INTP":
                result = "한 번 꽂히면 밤샐 때까지 눈에 불 켜고 게임함.\n누가 도와준다고 해도 혼자 함.";
                break;
            case "INFJ":
                result = "철저한 개인주의자. 게임은 혼자 하는 게 편함.\n항상 1인분 이상을 보여주는 노력과 실력.";
                break;
            case "INFP":
                result = "공격, 경쟁하는 게임이 싫음.\n멀티플레이도 하지만 싱글플레이가 더 편안함.";
                break;
            case "ISTJ":
                result = "팀플할 때 누가 못하면 핵답답. 결국 혼자 다 함.\n어떤 게임이든 웬만해선 상위권을 노림.";
                break;
            case "ISTP":
                result = "혼자 머리 쓰는 게임을 좋아함.\n상쾌하게 딱 떨어지는 게임도 좋아함.";
                break;
            case "ISFJ":
                result = "한 게임에 꽂히면 굉장히 열정적.\n게임에서 뭘 정하는데 한 세월 걸림.";
                break;
            case "ISFP":
                result = "게임을 남들보다 더 효율적으로 하는 편.\n아군도 많지만 적도 많이 만드는 타입.";
                break;
            default:
                result = "다시 하십시오.";
                break;
        }
        return result;
    }

    private void displayMbtiImage(String mbtiType) {
        int imageResId = getResources().getIdentifier(mbtiType.toLowerCase(), "drawable", getPackageName());
        if (imageResId != 0) {
            mbtiImageView.setImageResource(imageResId);
            mbtiImageView.setVisibility(View.VISIBLE);
        } else {
            mbtiImageView.setVisibility(View.GONE); // Скрыть изображение, если ресурс не найден
        }
    }
}

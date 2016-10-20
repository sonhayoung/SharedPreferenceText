package kr.hs.emirim.thsgkdud123.sharedpreferencetext;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAge;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);
        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String name=sp.getString("name","");
        String age=sp.getString("age","");
        editName.setText(name);
        editAge.setText(age);
    }//다시 나타날때호출

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("name",editName.getText().toString());
        edit.putString("age",editAge.getText().toString());
        edit.commit();
    }//액티비티가 사라질때, 화면에 나오지 않을때 호출됨
}

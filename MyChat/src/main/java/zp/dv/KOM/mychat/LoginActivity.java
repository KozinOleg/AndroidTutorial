package zp.dv.KOM.mychat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity implements OnClickListener {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN = "([A-Za-z0-9-\\-\\_]{6,}$)";
    private static final String LOGINBAD = "Логин должен быть в формате\n"
            + "электронного адреса !";
    private static final String PASSWORDBAD = "Пароль долен быть не короче шести символов,\n"
            + "содержать буквы, цифры, подчеркивание и тире !";
    public static String sLoginName = "userDefault";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.buttonLogin);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etLogin = (EditText) findViewById(R.id.etLogin);
        EditText etPass = (EditText) findViewById(R.id.etPassword);

//        try {
//            if (!validator(sEMAIL_PATTERN, etLogin.getText().toString())) {
//                Toast.makeText(LoginActivity.this,
//                        sLOGINBAD,
//                        Toast.LENGTH_LONG).show();
//            } else if (!validator(sPASSWORD_PATTERN, etPass.getText().toString())) {
//                Toast.makeText(LoginActivity.this,
//                        sPASSWORDBAD,
//                        Toast.LENGTH_LONG).show();
//            } else {
//                sLoginName = etLogin.getText().toString();
//                startActivity(new Intent(LoginActivity.this,
//                        ChatActivity.class));
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
///////////////////////////////////////////////////////////
        sLoginName = etLogin.getText().toString();
        startActivity(new Intent(LoginActivity.this,
                ChatActivity.class));
//////////////////////////////////////////////////////////
    }

    private boolean validator(String patternStr, String str) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}



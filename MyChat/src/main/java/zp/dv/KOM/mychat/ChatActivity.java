package zp.dv.KOM.mychat;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends Activity {
    private static final String MESSAGE = "Message";
    private final static String PATTERN_DATE = "dd.MM.yy hh:mm:ss";
    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(PATTERN_DATE);
    private static ArrayList<Message> sMessages = new ArrayList<Message>();
    private ChatAdapter mChatAdapter;
    private ListView mListViewChat;
    private EditText mMessageText;
    private Button mButtonSend;
    private Bot mBot;

    public void setButtonSend(Button buttonSend) {
        this.mButtonSend = buttonSend;
    }

    public void setListViewChat(ListView listViewChat) {
        this.mListViewChat = listViewChat;
    }

    public EditText getMessageText() {
        return mMessageText;
    }

    public void setMessageText(EditText messageText) {
        this.mMessageText = messageText;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(MESSAGE, sMessages);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sMessages = (ArrayList<Message>) savedInstanceState.getSerializable(MESSAGE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setMessageText((EditText) findViewById(R.id.editTextMessage));
        setButtonSend((Button) findViewById(R.id.buttonSendMessage));
        setListViewChat((ListView) findViewById(R.id.listViewChat));

        mBot = new Bot("Вася", Color.GREEN);

        mChatAdapter = new ChatAdapter(this, sMessages);
        mListViewChat.setAdapter(mChatAdapter);

        setData();
        setButtonState();
    }

    public void onSend(View v) {
        addMessage();
        setData();
    }

    private void setData() {
        mChatAdapter.setMessages(sMessages);
        mChatAdapter.notifyDataSetChanged();
        mMessageText.setText("");
    }

    private void addMessage() {
        // Message User
        sMessages.add(new Message(LoginActivity.sLoginName,
                getMessageText().getText().toString(),
                mSimpleDateFormat.format(new Date())
                ,Color.MAGENTA));
        // Message Bot
        sMessages.add(new Message(mBot.getBotName(),
                mBot.genBotMessage(),
                mSimpleDateFormat.format(new Date()),
                mBot.getColor()));
    }

    private void setButtonState() {
        mMessageText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) mButtonSend.setEnabled(true);
                else mButtonSend.setEnabled(false);
            }
        });
    }
}

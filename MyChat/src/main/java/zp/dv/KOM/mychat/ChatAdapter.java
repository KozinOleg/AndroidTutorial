package zp.dv.KOM.mychat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLinflater;
    private ArrayList<Message> mMessages;

    public void setMessages(ArrayList<Message> messages) {
        this.mMessages = messages;
    }

    public ChatAdapter(Context context, ArrayList<Message> messages) {
        this.mContext = context;
        this.mLinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mMessages = messages;
    }

    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return mMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =  new ViewHolder();
        if (convertView == null) {
            convertView = mLinflater.inflate(R.layout.message_item, null);
            holder.mVHUserName = (TextView) convertView.findViewById(R.id.topText);
            holder.mVHMessage = (TextView) convertView.findViewById(R.id.botText);
            holder.mVHDate = (TextView) convertView.findViewById(R.id.rightText);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mVHUserName.setText(mMessages.get(position).getName());
        holder.mVHUserName.setTextColor(mMessages.get(position).getmColor());

        holder.mVHMessage.setText(mMessages.get(position).getText());
        holder.mVHDate.setText(String.valueOf(mMessages.get(position).getDate()));

        convertView.setTag(holder);

        return convertView;
    }

    class ViewHolder {
        private TextView mVHUserName;
        private TextView mVHMessage;
        private TextView mVHDate;
    }
}
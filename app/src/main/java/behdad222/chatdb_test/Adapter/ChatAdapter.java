package behdad222.chatdb_test.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.chatdb_test.R;
import behdad222.chatdb_test.object.messageObject;

/**
 * Created by behdad on 4/1/15.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private ArrayList<messageObject> messageObjects;
    private Context context;

    public ChatAdapter(ArrayList<messageObject> object) {
        this.messageObjects = object;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;

        public ViewHolder(View v) {
            super(v);
            id = (TextView) itemView.findViewById(R.id.id);
        }
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.convarsation_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        messageObject object = messageObjects.get(position);
        holder.id.setText(object.getBody());
    }

    @Override
    public int getItemCount() {
        return messageObjects.size();
    }
}

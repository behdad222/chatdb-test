package behdad222.chatdb_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.chatdb_test.R;
import behdad222.chatdb_test.object.conversationObject;

/**
 * Created by behdad on 4/1/15.
 */
public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {
    private ArrayList<conversationObject> conversationObjects;
    private Context context;

    public ConversationAdapter(ArrayList<conversationObject> object, Context context) {
        this.conversationObjects = object;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView id;

        public ViewHolder(View v) {
            super(v);
            id = (TextView) itemView.findViewById(R.id.id);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(context, DescriptionActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//            intent.putExtra("id", meetings.get(getPosition()).getId());
//            context.startActivity(intent);
        }

    }

    @Override
    public ConversationAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.convarsation_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        conversationObject object = conversationObjects.get(position);
        holder.id.setText(object.getConversationId());
    }

    @Override
    public int getItemCount() {
        return conversationObjects.size();
    }
}

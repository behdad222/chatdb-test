package behdad222.chatdb_test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import behdad222.chatdb_test.Adapter.ChatAdapter;
import behdad222.chatdb_test.Adapter.ConversationAdapter;
import behdad222.chatdb_test.object.messageObject;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by behdad on 4/1/15.
 */
public class ChatActivity extends ActionBarActivity {


    private RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private Realm realm;
    private ArrayList<messageObject> objects;
    private String conId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getInstance(this);
        objects = new ArrayList<>();

        recycleView = (RecyclerView) findViewById(R.id.main_recycle_view);
        recycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        adapter = new ChatAdapter(objects);
        recycleView.setAdapter(adapter);

        conId = "1";



        RealmResults<messageObject> result = realm
                .where(messageObject.class)
                .equalTo("conversationId",conId).findAll();

        for (int i = 0; i < result.size(); i++) {
            objects.add(result.get(i));
            Log.e("obj", String.valueOf(i));
        }

        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            for (int j = 1; j<10; j++) {
            for (int i = 1; i <300; i++) {
                //   conversationObject obj = new conversationObject();
//                obj.setId(i);
//                obj.setConversationId(String.valueOf(i));

                realm.beginTransaction();

                messageObject obj = realm.createObject(messageObject.class);

//                obj.setId(i);
                obj.setBody("con id = " + i + " chat num " + j);
                obj.setConversationId(String.valueOf(i));
//                realm.copyToRealmOrUpdate(obj);
                realm.commitTransaction();

                objects.add(obj);


            }
                }

            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

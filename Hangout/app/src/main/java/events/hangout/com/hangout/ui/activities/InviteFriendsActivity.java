package events.hangout.com.hangout.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Gustavo Forer on 12/09/2017.
 */

public class InviteFriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getFriendsList() {
        AccessToken token = AccessToken.getCurrentAccessToken();
        GraphRequest graphRequest = GraphRequest.newMeRequest(token, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                try {
                    JSONArray jsonArrayFriends = jsonObject.getJSONObject("friendlist").getJSONArray("data");
                    JSONObject friendlistObject = jsonArrayFriends.getJSONObject(0);
                    String friendListID = friendlistObject.getString("id");
                    myNewGraphReq(friendListID);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle param = new Bundle();
        param.putString("fields", "friendlist", "members");
        graphRequest.setParameters(param);
        graphRequest.executeAsync();
    }

    private void myNewGraphReq(String friendlistId) {
        final String graphPath = "/" + friendlistId + "/members/";
        AccessToken token = AccessToken.getCurrentAccessToken();
        GraphRequest request = new GraphRequest(token, graphPath, null, HttpMethod.GET, new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {
                JSONObject object = graphResponse.getJSONObject();
                try {
                    JSONArray arrayOfUsersInFriendList = object.getJSONArray("data");
                /* Do something with the user list */
                /* ex: get first user in list, "name" */
                    JSONObject user = arrayOfUsersInFriendList.getJSONObject(0);
                    String usersName = user.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle param = new Bundle();
        param.putString("fields", "name");
        request.setParameters(param);
        request.executeAsync();
    }
}

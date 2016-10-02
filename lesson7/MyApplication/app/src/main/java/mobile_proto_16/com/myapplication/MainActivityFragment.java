package mobile_proto_16.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.ButterKnife;


import org.json.JSONException;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.button) Button button;
    @BindView(R.id.input) EditText input;
    @BindView(R.id.price) TextView price;

    private final String TAG = this.getClass().getName();

    private Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                final JSONArray jsonData = new JSONArray(response.substring(3));
                final String amount = extractPriceFromJSON(jsonData);
                price.setText(amount);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "A VolleyError occurred.");
            error.printStackTrace();
        }
    };

    public MainActivityFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        final Context c = this.getContext();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = buildSearchURL(input.getText().toString());
                final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
                MySingleton.getInstance(c).addToRequestQueue(stringRequest);
            }
        });

        return view;
    }

    private String buildSearchURL(String companyTicker) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("finance.google.com")
                .appendPath("finance")
                .appendPath("info")
                .appendQueryParameter("client", "iq")
                .appendQueryParameter("q", companyTicker);
        return builder.build().toString();
    }

    private String extractPriceFromJSON(JSONArray array) throws JSONException {
        // Get the 0th element of the array, find the price value (has key "l")
        return array.getJSONObject(0).getString("l");
    }

}
